package com.duode.controller;

import com.duode.constant.ApiStatusCode;
import com.duode.model.Cash;
import com.duode.model.User;
import com.duode.response.ResponseDataModel;
import com.duode.service.CashService;
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


    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel addCash(@RequestBody Cash cash) {
        ResponseDataModel response = new ResponseDataModel();
        User user = userService.getUserInfo(cash.getUser_id());
        int integration=user.getIntegration();

        if (cash.getIntegration_elem() > user.getIntegration() ) {
            response.setStatusCode(ApiStatusCode.OUT_OF_INTEGRATION.value());

        }else {
            double cash_elem= cash.getIntegration_elem() * cash.getProportion();
            cash.setCash_elem(cash_elem);
            int code = cashService.addCash(cash);
            user.setCash(user.getCash()+cash_elem);
            userService.updateUser(user);
            if (code==1){
                response.setStatusCode(ApiStatusCode.SUCCESS.value());
            } else {
                response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
            }
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
