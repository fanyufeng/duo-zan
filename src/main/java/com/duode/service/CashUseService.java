package com.duode.service;

import com.duode.mapper.CardUseMapper;
import com.duode.mapper.CashUseMapper;
import com.duode.model.CardUse;
import com.duode.model.CashUse;
import com.duode.response.UserInternationalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by fanyufeng in 18/12/11
 */
@Service
public class CashUseService {

    @Autowired
    public CashUseMapper cashUseMapper;


    public CashUse addCashUse(CashUse cashUse) {
        int cardResponse = cashUseMapper.addCashUse(cashUse);
        return cashUse;
    }

    public List<CashUse> findCardUser(CashUse cashUse){
        List<CashUse> cardUseList = cashUseMapper.findCashUser(cashUse);
        if (cardUseList.size()!=0) {
            return cardUseList;
        } else {
            return null;
        }
    }

    public List<CashUse> findCardUseAll(CashUse cashUse){
        List<CashUse> cardUseList = cashUseMapper.findCashUseAll();
        if (cardUseList.size()!=0) {
            return cardUseList;
        } else {
            return null;
        }
    }
}
