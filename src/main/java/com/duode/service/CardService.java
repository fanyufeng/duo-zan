package com.duode.service;

import com.duode.mapper.CardMapper;
import com.duode.model.Card;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/2
 */
@Service
public class CardService {
    @Autowired
    public CardMapper cardMapper;

    public int addCard(Card card) {
        int cardResponse = cardMapper.addCard(card);
        return cardResponse;
    }

    public int updateCard(Card card) {
        int updateResponse= cardMapper.updateCard(card);
        return updateResponse;
    }

    public Card findCard(String unique_id) {
        List<Card> cardList = cardMapper.findCard(unique_id);
        if (cardList.size()!=0) {
            Card card = cardList.get(0);
            return card;
        } else {
            return null;
        }
    }

    public List<Card> findCardAll() {
        List<Card> cardList = cardMapper.findCardAll();
        if (cardList.size()!=0) {
            return cardList;
        } else {
            return null;
        }
    }



    public List<Card> findCardIdList(int status) {
        List<Card> cardList = cardMapper.findCardIdList(status);
        if (cardList.size()!=0) {
            return cardList;
        } else {
            return null;
        }
    }

    public Card findCardDetail(int cardId) {
        List<Card> cardList = cardMapper.findCardDetail(cardId);
        if (cardList.size() != 0) {
            Card cardElem = cardList.get(0);
            return cardElem;
        } else {
            return null;
        }

    }


}
