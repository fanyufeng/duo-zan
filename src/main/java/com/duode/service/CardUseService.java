package com.duode.service;

import com.duode.mapper.CardUseMapper;
import com.duode.model.CardUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by fanyufeng in 18/12/11
 */
@Service
public class CardUseService {

    @Autowired
    public CardUseMapper cardUseMapper;


    public int addCardUse(CardUse cardUse) {
        int cardResponse = cardUseMapper.addCardUse(cardUse);
        return cardResponse;
    }


    public Map getUserListYesterday(){
        Map result = cardUseMapper.getUserListYesterday(GetNowDate());
        if (result !=null) {
            return result;
        } else {
            return null;
        }
    }


    public String GetNowDate(){
        String temp_str="";
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        temp_str=sdf.format(dt);
        return temp_str;
    }
}
