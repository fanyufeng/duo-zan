package com.duode.controller;

import com.duode.constant.ApiStatusCode;
import com.duode.model.Advertiser;
import com.duode.model.Factory;
import com.duode.response.ResponseDataModel;
import com.duode.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/25
 */
@RestController
@RequestMapping("/factory")
public class FactoryController {
    @Autowired
    public FactoryService factoryService;

    @RequestMapping(value="/getFactoryDetail",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getFactoryDetail(@RequestBody Factory factory) {
        ResponseDataModel response = new ResponseDataModel();
        List<Factory> code = factoryService.findFactoryDetail(factory.getId());
        if (code !=null){
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
            response.setData(code);
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel addFactory(@RequestBody Factory factory) {
        ResponseDataModel response = new ResponseDataModel();
        int code = factoryService.addFactory(factory);
        if (code==1){
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel updateFactory(@RequestBody Factory factory){
        ResponseDataModel response = new ResponseDataModel();
        int code = factoryService.updateFactory(factory);
        if (code ==1) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }


    @RequestMapping(value="/getFactoryList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getFactoryList(@RequestBody Factory factory){
        ResponseDataModel response = new ResponseDataModel();
        List<Factory> factoryList = factoryService.getfactoryList();
        if (factoryList !=null) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
            response.setData(factoryList);
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }
}
