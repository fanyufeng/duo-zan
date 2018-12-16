package com.duode.response;

import com.duode.model.Advertise;
import com.duode.model.Advertiser;
import com.duode.model.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanyufeng in 18/12/16
 */
public class CardAdvertiseResponse {
    public List<Card> cardList;
    public List<Advertise> advertises;
    List<Advertiser> advertiserList;


    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public List<Advertise> getAdvertises() {
        return advertises;
    }

    public void setAdvertises(List<Advertise> advertises) {
        this.advertises = advertises;
    }

    public List<Advertiser> getAdvertiserList() {
        return advertiserList;
    }

    public void setAdvertiserList(List<Advertiser> advertiserList) {
        this.advertiserList = advertiserList;
    }

    @Override
    public String toString() {
        return "CardAdvertiseResponse{" +
                "cardList=" + cardList +
                ", advertises=" + advertises +
                ", advertiserList=" + advertiserList +
                '}';
    }
}
