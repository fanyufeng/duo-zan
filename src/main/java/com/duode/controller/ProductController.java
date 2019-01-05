package com.duode.controller;

import com.duode.config.IDGeneratorUtils;
import com.duode.constant.ApiStatusCode;
import com.duode.model.Card;
import com.duode.model.Product;
import com.duode.response.ResponseDataModel;
import com.duode.service.CardService;
import com.duode.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/25
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    public ProductService productService;

    @Autowired
    public CardService cardService;

    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel addProduct(@RequestBody Product product) {
        ResponseDataModel response = new ResponseDataModel();
        int code = productService.addProduct(product);


        for (int i=0;i<product.getCard_num();i++) {
            Card cardRequest = new Card();
            cardRequest.setUnique_id(IDGeneratorUtils.uuid32());
            cardRequest.setTimes(5);
            cardRequest.setProduct_id();
            int code = cardService.addCard(cardRequest);
        }



        if (code==1){
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel updateProduct(@RequestBody Product product){
        ResponseDataModel response = new ResponseDataModel();
        int code = productService.updateProduct(product);
        if (code ==1) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }


    @RequestMapping(value="/getProductList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getProductList(@RequestBody Product product){
        ResponseDataModel response = new ResponseDataModel();
        List<Product> productList = productService.getproductList();
        if (productList !=null) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
            response.setData(productList);
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }
}
