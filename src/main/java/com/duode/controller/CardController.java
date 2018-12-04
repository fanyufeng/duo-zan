package com.duode.controller;

import com.duode.config.IDGeneratorUtils;
import com.duode.constant.ApiStatusCode;
import com.duode.model.Card;
import com.duode.response.ResponseDataModel;
import com.duode.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by fanyufeng in 18/12/4
 */
@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    public CardService cardService;

    @RequestMapping(value="add",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel addCard(@RequestBody Card cardRequest) {
        ResponseDataModel response = new ResponseDataModel();
        cardRequest.setUnique_id(IDGeneratorUtils.uuid32());
        int code = cardService.addCard(cardRequest);
        if (code==1){
            Card re = cardService.findCard(cardRequest.getUnique_id());
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
            response.setData(re);
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }
}
