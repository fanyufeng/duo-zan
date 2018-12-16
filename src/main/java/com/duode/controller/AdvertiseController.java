package com.duode.controller;

import com.duode.config.IDGeneratorUtils;
import com.duode.constant.ApiStatusCode;
import com.duode.model.Advertise;
import com.duode.model.Card;
import com.duode.response.ResponseDataModel;
import com.duode.service.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by fanyufeng in 18/12/16
 */

@RestController
@RequestMapping("/advertise")
public class AdvertiseController {
    @Autowired
    public AdvertiseService advertiseService;

    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel addCard(@RequestBody Advertise advertise) {
        ResponseDataModel response = new ResponseDataModel();
        int code = advertiseService.addAdvertise(advertise);
        if (code==1){
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }
}
