package com.duode.controller;

import com.duode.constant.ApiStatusCode;
import com.duode.model.User;
import com.duode.model.Withdraw;
import com.duode.response.ResponseDataModel;
import com.duode.service.CardService;
import com.duode.service.UserService;
import com.duode.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/25
 */
@RestController
@RequestMapping("/withdraw")
public class WithdrawController {
    @Autowired
    public WithdrawService withdrawService;

    @Autowired
    public CardService cardService;

    @Autowired
    public UserService userService;


    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel addWithdraw(@RequestBody Withdraw withdraw) {
        ResponseDataModel response = new ResponseDataModel();
        int code = withdrawService.addWithdraw(withdraw);
        User elem = userService.getUserInfo(withdraw.getUser_id());
        if (elem != null) {
            elem.setCash(elem.getCash()-withdraw.getPay());
            userService.updateUser(elem);
        }

        if (code!= 0){
            response.setStatusCode(ApiStatusCode.SUCCESS.value());

        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel updateWithdraw(@RequestBody Withdraw withdraw){
        ResponseDataModel response = new ResponseDataModel();
        int code = withdrawService.updateWithdraw(withdraw);
        if (code ==1) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }


    @RequestMapping(value="/getWithdrawList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getWithdrawList(@RequestBody Withdraw withdraw){
        ResponseDataModel response = new ResponseDataModel();
        List<Withdraw> withdrawList = withdrawService.getwithdrawList();
        if (withdrawList !=null) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
            response.setData(withdrawList);
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }
}
