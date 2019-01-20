package com.duode.controller;

import com.duode.config.IDGeneratorUtils;
import com.duode.constant.ApiStatusCode;
import com.duode.model.*;
import com.duode.request.CardRequest;
import com.duode.response.CardAdvertiseResponse;
import com.duode.response.CardIdResponse;
import com.duode.response.CardScanResponse;
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
    @Autowired
    public ProductService productService;





    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel addCard(@RequestBody CardRequest cardRequest) {
        ResponseDataModel response = new ResponseDataModel();

        if (cardRequest.getCard_num()!=0) {
            for (int i=0;i<cardRequest.getCard_num(); i++) {

                Card card =new Card();
                card.setProduct_id(cardRequest.getProduct_id());
                card.setAdvertise_id(cardRequest.getAdvertise_id());
                card.setIntegration_num(cardRequest.getIntegration_num());
                card.setVideo_url(cardRequest.getVideo_url());
                card.setUnique_id(IDGeneratorUtils.uuid32());
                card.setTimes(5);
                int code = cardService.addCard(card);
                if (code==1){
                    Card re = cardService.findCard(cardRequest.getUnique_id());
                    response.setStatusCode(ApiStatusCode.SUCCESS.value());
                    response.setData(re);
                } else {
                    response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
                }
            }

        }

        return response;
    }

    @RequestMapping(value="/findCardIdList",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getStatus(@RequestBody CardRequest cardRequest) {
        ResponseDataModel response = new ResponseDataModel();

        List<Card> cardList=cardService.findCardIdList(0);

        List<CardIdResponse> idList = new ArrayList<>();

        if (cardList !=null) {
            for (Card elem : cardList) {
                CardIdResponse cardIdResponse = new CardIdResponse();

                List<Product> productList = productService.getProduct(elem.getProduct_id());
                if (productList!=null) {
                    Product product = productList.get(0);
                    cardIdResponse.setProductName(product.getName());
                }
                cardIdResponse.setUniqueId(elem.getUnique_id());
                idList.add(cardIdResponse);
            }

            response.setStatusCode(ApiStatusCode.SUCCESS.value());
            response.setData(idList);
        } else {
            response.setStatusCode(ApiStatusCode.CODE_COMPARE_ERROR.value());
        }
        return response;
    }

    @RequestMapping(value="/getByUnionId",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getByUnionId(@RequestBody Card cardRequest) {
        ResponseDataModel response = new ResponseDataModel();
        System.out.println("unique_id: " + cardRequest.getUnique_id());
        Card re = cardService.findCard(cardRequest.getUnique_id());
        Advertise advertise = advertiseService.findAdvertise(re.getAdvertise_id());
        System.out.println("advertiser_id: " +advertise.getAdvertiser_id());
        Advertiser advertiser= advertiserService.findAdvertiser(advertise.getAdvertiser_id());
        System.out.println("advertiser: "+ advertiser);
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
            cardAdvertiseResponse.setAdvertiserList(advertiserList);
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

        CardScanResponse cardScanResponse = new CardScanResponse();
        Card re = cardService.findCard(cardRequest.getUnique_id());

        if (re.getTimes()==0) {
            response.setStatusCode(ApiStatusCode.CARD_FORBID.value());
        } else {
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
            cardUse.setIntegration_num(re.getIntegration_num());
            cardUseService.addCardUse(cardUse);

            User user = userService.getUserInfo(cardRequest.getUser_id());
            user.setIntegration(user.getIntegration() + re.getIntegration_num());
            userService.updateUserIntegration(user);

            List<Product> productList = productService.getProduct(re.getProduct_id());
            Advertise advertise = advertiseService.findAdvertise(re.getAdvertise_id());
            List<Advertise> advertises = new ArrayList<>();
            advertises.add(advertise);

            List<Card> cards = new ArrayList<>();
            cards.add(re);

            cardScanResponse.setProductList(productList);
            cardScanResponse.setCardList(cards);
            cardScanResponse.setAdvertiseList(advertises);

            if (re !=null){
                response.setStatusCode(ApiStatusCode.SUCCESS.value());
                response.setData(cardScanResponse);
            } else {
                response.setStatusCode(ApiStatusCode.SUCCESS.value());
            }
        }

        return response;
    }
}
