package com.duode.controller;

import com.duode.constant.ApiStatusCode;
import com.duode.model.Card;
import com.duode.model.Cash;
import com.duode.model.Cashtotal;
import com.duode.model.User;
import com.duode.request.CashRequest;
import com.duode.response.ResponseDataModel;
import com.duode.service.CardService;
import com.duode.service.CashService;
import com.duode.service.CashtotalService;
import com.duode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/25
 */
@RestController
@RequestMapping("/cash")
public class CashController {
    @Autowired
    public CashService cashService;

    @Autowired
    public UserService userService;

    @Autowired
    public CashtotalService cashtotalService;

    @Autowired
    public CardService cardService;



    @RequestMapping(value="/show",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel addCash(@RequestBody Cash cash) {
        ResponseDataModel response = new ResponseDataModel();
        try {
            User user = userService.getUserInfo(cash.getUser_id());

            List<Cashtotal> cashtotal =cashtotalService.getCashTotal(1);

            Cashtotal cashtotal1=cashtotal.get(0);

            int integration=user.getIntegration();

            List<Card> cardList = cardService.findCardAll();
            int sum = 0;
            for (Card card : cardList) {
                sum =sum+card.getIntegration_num();
            }


            double proprotion=cashtotal1.getCash_total()/sum;
            double cash_elem=integration * proprotion;//设置保留位数

            cash.setCash_elem(cash_elem);
            int code = cashService.addCash(cash);
            user.setCash(cash_elem);
            userService.updateUser(user);
            if (code==1){
                response.setStatusCode(ApiStatusCode.SUCCESS.value());
            } else {
                response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
            }

        } catch (Exception e) {

        }


        return response;
    }


    @RequestMapping(value="/distribute",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel distributeCash(@RequestBody CashRequest cashRequest) {
        ResponseDataModel response = new ResponseDataModel();
        try {
            List<User> userList = userService.getUserList();

            List<Cashtotal> cashtotal =cashtotalService.getCashTotal(cashRequest.getCashTotalId());

            Cashtotal cashtotal1=cashtotal.get(0);
            cashtotal1.setStatus(1);

            cashtotalService.updateCashtotal(cashtotal1);

            List<Card> cardList = cardService.findCardAll();
            int sum = 0;
            for (User user : userList) {
                sum =sum+user.getIntegration();
            }


            double proprotion=cashtotal1.getCash_total()/sum;

            for (User userL : userList) {
                double cash_elem = userL.getIntegration() * proprotion;
                userL.setCash(cash_elem + userL.getCash());
                userService.updateUser(userL);
            }

            response.setStatusCode(ApiStatusCode.SUCCESS.value());
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());


        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }


    @RequestMapping(value="/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel updateCash(@RequestBody Cash cash){
        ResponseDataModel response = new ResponseDataModel();
        int code = cashService.updateCash(cash);
        if (code ==1) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }


    @RequestMapping(value="/getCashList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getCashList(@RequestBody Cash cash){
        ResponseDataModel response = new ResponseDataModel();
        List<Cash> cashList = cashService.getcashList();
        if (cashList !=null) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
            response.setData(cashList);
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }
}
