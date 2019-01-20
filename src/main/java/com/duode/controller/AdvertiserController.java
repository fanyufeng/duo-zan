package com.duode.controller;

import com.duode.constant.ApiStatusCode;
import com.duode.model.Advertise;
import com.duode.model.Advertiser;
import com.duode.model.Product;
import com.duode.response.ResponseDataModel;
import com.duode.service.AdvertiseService;
import com.duode.service.AdvertiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/16
 */

@RestController
@RequestMapping("/advertiser")
public class AdvertiserController {
    @Autowired
    public AdvertiserService advertiserService;

    @RequestMapping(value="/getAdvertiserDetail",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getAdvertiserDetail(@RequestBody Advertiser advertiser) {
        ResponseDataModel response = new ResponseDataModel();
        Advertiser code = advertiserService.findAdvertiser(advertiser.getId());
        if (code!=null){
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
            response.setData(code);
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel addAdvertiser(@RequestBody Advertiser advertiser) {
        ResponseDataModel response = new ResponseDataModel();
        int code = advertiserService.addAdvertiser(advertiser);
        if (code==1){
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel updateAdvertiser(@RequestBody Advertiser advertiser){
        ResponseDataModel response = new ResponseDataModel();
        int code = advertiserService.updateAdvertiser(advertiser);
        if (code ==1) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }


    @RequestMapping(value="/getAdvertiserList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getAdvertiserList(@RequestBody Advertiser advertiser){
        ResponseDataModel response = new ResponseDataModel();
        List<Advertiser> advertiserList = advertiserService.getAdvertiserList();
        if (advertiserList !=null) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
            response.setData(advertiserList);
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }

}
