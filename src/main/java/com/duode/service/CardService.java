package com.duode.service;

import com.duode.mapper.CardMapper;
import com.duode.model.Card;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Card card = cardMapper.findCard(unique_id);
        return card;
    }


}
