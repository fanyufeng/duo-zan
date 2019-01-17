package com.duode.controller;

import com.duode.constant.ApiStatusCode;
import com.duode.model.Card;
import com.duode.model.CardUse;
import com.duode.model.Product;
import com.duode.response.CardUseResponse;
import com.duode.response.ResponseDataModel;
import com.duode.service.CardService;
import com.duode.service.CardUseService;
import com.duode.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanyufeng in 18/12/25
 */
@RestController
@RequestMapping("/card/use/")
public class CardUseController {
    @Autowired
    public CardUseService cardUseService;

    @Autowired
    public CardService cardService;

    @Autowired
    public ProductService productService;


    @RequestMapping(value="/getCardUseList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getCardUseList(@RequestBody CardUse cardUse){
        ResponseDataModel response = new ResponseDataModel();
        List<CardUse> cardUseList = cardUseService.findCardUser(cardUse);

        List<CardUseResponse> cardUseResponseList = new ArrayList<>();

        if (cardUseList !=null) {
            for (CardUse elem : cardUseList) {
                CardUseResponse cardUseResponse = new CardUseResponse();
                cardUseResponse.setId(elem.getId());
                cardUseResponse.setCard_id(elem.getCard_id());
                cardUseResponse.setComment(elem.getComment());
                cardUseResponse.setIntegration_num(elem.getIntegration_num());
                cardUseResponse.setNum(elem.getNum());
                cardUseResponse.setSatus(elem.getSatus());
                cardUseResponse.setUser_id(elem.getUser_id());

                Card cardResponse = cardService.findCardDetail(elem.getCard_id());
                if (cardResponse != null) {
                    List<Product> productList = productService.getProduct(cardResponse.getProduct_id());
                    if (productList != null) {
                        Product product = productList.get(0);
                        cardUseResponse.setProductName(product.getName());
                        cardUseResponse.setProductTime(product.getModify_time());
                    }
                }

                cardUseResponseList.add(cardUseResponse);

            }
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
            response.setData(cardUseResponseList);
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }
}
