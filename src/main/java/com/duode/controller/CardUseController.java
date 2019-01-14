package com.duode.controller;

import com.duode.constant.ApiStatusCode;
import com.duode.model.CardUse;
import com.duode.model.Product;
import com.duode.response.ResponseDataModel;
import com.duode.service.CardService;
import com.duode.service.CardUseService;
import com.duode.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/25
 */
@RestController
@RequestMapping("/card/use/")
public class CardUseController {
    @Autowired
    public CardUseService cardUseService;






    @RequestMapping(value="/getCardUseList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getCardUseList(@RequestBody CardUse cardUse){
        ResponseDataModel response = new ResponseDataModel();
        List<CardUse> cardUseList = cardUseService.findCardUser(cardUse.getUser_id());
        if (cardUseList !=null) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
            response.setData(cardUseList);
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }
}
