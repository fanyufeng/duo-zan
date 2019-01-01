package com.duode.response;

import com.duode.model.Advertise;
import com.duode.model.Card;
import com.duode.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanyufeng in 19/1/1
 */
public class CardScanResponse {
    List<Card> cardList = new ArrayList<>();
    List<Product> productList = new ArrayList<>();
    List<Advertise> advertiseList = new ArrayList<>();

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Advertise> getAdvertiseList() {
        return advertiseList;
    }

    public void setAdvertiseList(List<Advertise> advertiseList) {
        this.advertiseList = advertiseList;
    }

    @Override
    public String toString() {
        return "CardScanResponse{" +
                "cardList=" + cardList +
                ", productList=" + productList +
                ", advertiseList=" + advertiseList +
                '}';
    }
}
