package com.duode.controller;

import com.duode.config.IDGeneratorUtils;
import com.duode.constant.ApiStatusCode;
import com.duode.model.*;
import com.duode.request.CardRequest;
import com.duode.response.CardAdvertiseResponse;
import com.duode.response.ResponseDataModel;
import com.duode.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanyufeng in 18/12/4
 */
@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    public CardService cardService;
    @Autowired
    public UserService userService;
    @Autowired
    public CardUseService cardUseService;
    @Autowired
    public AdvertiseService advertiseService;

    @Autowired
    public AdvertiserService advertiserService;




    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel addCard(@RequestBody Card cardRequest) {
        ResponseDataModel response = new ResponseDataModel();
        cardRequest.setUnique_id(IDGeneratorUtils.uuid32());
        cardRequest.setTimes(5);
        int code = cardService.addCard(cardRequest);
        if (code==1){
            Card re = cardService.findCard(cardRequest.getUnique_id());
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
            response.setData(re);
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }

    @RequestMapping(value="/getByUnionId",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getByUnionId(@RequestBody Card cardRequest) {
        ResponseDataModel response = new ResponseDataModel();
        Card re = cardService.findCard(cardRequest.getUnique_id());
        Advertise advertise = advertiseService.findAdvertise(re.getAdvertise_id());
        Advertiser advertiser= advertiserService.findAdvertiser(advertise.getAdvertiser_id());
        if (re !=null){
            List<Card> reList =new ArrayList<>();
            List<Advertise> advertiseListResponse = new ArrayList<>();
            List<Advertiser> advertiserList = new ArrayList<>();

            reList.add(re);
            advertiseListResponse.add(advertise);
            advertiserList.add(advertiser);

            CardAdvertiseResponse cardAdvertiseResponse =new CardAdvertiseResponse();
            cardAdvertiseResponse.setCardList(reList);
            cardAdvertiseResponse.setAdvertises(advertiseListResponse);
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
            response.setData(cardAdvertiseResponse);
        } else {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
        }
        return response;
    }

    @RequestMapping(value="/scanCode",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel updateCard(@RequestBody CardRequest cardRequest) {
        ResponseDataModel response = new ResponseDataModel();
        Card re = cardService.findCard(cardRequest.getUnique_id());

        if (re.getTimes()==0) {
            response.setStatusCode(ApiStatusCode.CARD_FORBID.value());
        } else {
            re.setIntegration_num(re.getIntegration_num() + 1);
            re.setTimes(re.times - 1);
            if (re.getTimes()==0) {
                re.setStatus(1);
            } else {
                re.setStatus(0);
            }
            cardService.updateCard(re);

            CardUse cardUse = new CardUse();
            cardUse.setCard_id(re.getId());
            cardUse.setUser_id(cardRequest.getUser_id());
            cardUse.setNum(re.getTimes());
            cardUse.setComment(re.getComment());
            cardUseService.addCardUse(cardUse);

            User user = userService.getUserInfo(cardRequest.getUser_id());
            user.setIntegration(user.getIntegration() + re.getIntegration_num());
            userService.updateUserIntegration(user);

            if (re !=null){
                response.setStatusCode(ApiStatusCode.SUCCESS.value());
                response.setData(re);
            } else {
                response.setStatusCode(ApiStatusCode.SUCCESS.value());
            }
        }

        return response;
    }
}
