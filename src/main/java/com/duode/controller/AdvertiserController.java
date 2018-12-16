package com.duode.controller;

import com.duode.constant.ApiStatusCode;
import com.duode.model.Advertise;
import com.duode.model.Advertiser;
import com.duode.response.ResponseDataModel;
import com.duode.service.AdvertiseService;
import com.duode.service.AdvertiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by fanyufeng in 18/12/16
 */

@RestController
@RequestMapping("/advertiser")
public class AdvertiserController {
    @Autowired
    public AdvertiserService advertiseService;

    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel addCard(@RequestBody Advertiser advertiser) {
        ResponseDataModel response = new ResponseDataModel();
        int code = advertiseService.addAdvertiser(advertiser);
        if (code==1){
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }
}
