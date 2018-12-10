package com.duode.service;

import com.duode.mapper.CardUseMapper;
import com.duode.model.CardUse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fanyufeng in 18/12/11
 */
public class CardUseService {

    @Autowired
    public CardUseMapper cardUseMapper;

    public int addCardUse(CardUse cardUse) {
        int cardResponse = cardUseMapper.addCardUse(cardUse);
        return cardResponse;
    }
}
