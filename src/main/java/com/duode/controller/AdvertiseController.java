package com.duode.controller;

import com.duode.config.IDGeneratorUtils;
import com.duode.constant.ApiStatusCode;
import com.duode.model.Advertise;
import com.duode.model.Advertiser;
import com.duode.model.Card;
import com.duode.response.ResponseDataModel;
import com.duode.service.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/16
 */

@RestController
@RequestMapping("/advertise")
public class AdvertiseController {
    @Autowired
    public AdvertiseService advertiseService;

    @RequestMapping(value="/getAdvertiseDetail",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getAdvertiseDetail(@RequestBody Advertise advertise) {
        ResponseDataModel response = new ResponseDataModel();
        Advertise code = advertiseService.findAdvertise(advertise.getId());
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


    @RequestMapping(value="/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel updateAdvertise(@RequestBody Advertise advertise){
        ResponseDataModel response = new ResponseDataModel();
        int code = advertiseService.updateAdvertise(advertise);
        if (code ==1) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }

    @RequestMapping(value="/updateDetail", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel updateAdvertiseDetail(@RequestBody Advertise advertise){
        ResponseDataModel response = new ResponseDataModel();
        int code = advertiseService.updateAdvertiseDetail(advertise);
        if (code ==1) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }


    @RequestMapping(value="/getAdvertiseList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getAdvertiseList(@RequestBody Advertise advertise){
        ResponseDataModel response = new ResponseDataModel();
        List<Advertise> advertiseList = advertiseService.getAdvertiseList();
        if (advertiseList !=null) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
            response.setData(advertiseList);
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }
}
