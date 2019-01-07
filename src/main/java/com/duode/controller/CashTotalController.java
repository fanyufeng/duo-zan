package com.duode.controller;
import com.duode.constant.ApiStatusCode;
import com.duode.model.Cashtotal;
import com.duode.response.ResponseDataModel;
import com.duode.service.CardService;
import com.duode.service.CashtotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/25
 */
@RestController
@RequestMapping("/cash/total")
public class CashTotalController {
    @Autowired
    public CashtotalService cashtotalService;

    @Autowired
    public CardService cardService;

    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel addCashtotal(@RequestBody Cashtotal cashtotal) {
        ResponseDataModel response = new ResponseDataModel();
        int code = cashtotalService.addCashtotal(cashtotal);
        if (code!= 0){
            response.setStatusCode(ApiStatusCode.SUCCESS.value());

        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel updateCashtotal(@RequestBody Cashtotal cashtotal){
        ResponseDataModel response = new ResponseDataModel();
        int code = cashtotalService.updateCashtotal(cashtotal);
        if (code ==1) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }


    @RequestMapping(value="/getCashtotalList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getCashtotalList(@RequestBody Cashtotal cashtotal){
        ResponseDataModel response = new ResponseDataModel();
        List<Cashtotal> cashtotalList = cashtotalService.getCashtotalList();
        if (cashtotalList !=null) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
            response.setData(cashtotalList);
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }
}
