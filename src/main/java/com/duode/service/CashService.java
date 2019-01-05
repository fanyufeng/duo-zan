package com.duode.service;

import com.duode.mapper.CashMapper;
import com.duode.model.Cash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/25
 */
@Service
public class CashService {

    @Autowired
    public CashMapper cashMapper;

    public int  addCash(Cash cash){
        int  cashReponse = cashMapper.addCash(cash);
        return cashReponse;
    }


    public int updateCash(Cash cash){
        int code = cashMapper.updateCash(cash);
        return code;
    }

    public List<Cash> getcashList(){
        List<Cash> cashList= cashMapper.findCash();
        if (((List) cashList).size() !=0) {
            return cashList;
        } else {
            return null;

        }
    }
}
