package com.duode.service;

import com.duode.mapper.CashtotalMapper;
import com.duode.mapper.WithdrawMapper;
import com.duode.model.Cashtotal;
import com.duode.model.Withdraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/25
 */
@Service
public class CashtotalService {

    @Autowired
    public CashtotalMapper cashtotalMapper;

    public List<Cashtotal>  getCashTotal(int id){
        List<Cashtotal>  withdrawReponse = cashtotalMapper.findCashTotalInfo(id);

        if(withdrawReponse.size()==0) {
            return null;
        } else {

            return withdrawReponse;
        }

    }

    public int  addCashtotal(Cashtotal withdraw){
        int  withdrawReponse = cashtotalMapper.addCashtotal(withdraw);
        return withdrawReponse;
    }


    public int updateCashtotal(Cashtotal withdraw){
        int code = cashtotalMapper.updateCashtotal(withdraw);
        return code;
    }

    public List<Cashtotal> getCashtotalStatus (int status) {
        List<Cashtotal> cashtotalList = cashtotalMapper.getCashtotalStatus(status);
        if (cashtotalList.size()!=0) {
            return cashtotalList;
        } else {
            return null;
        }
    }
    public List<Cashtotal> getCashtotalList(){
        List<Cashtotal> withdrawList= cashtotalMapper.findCashtotal();
        if (((List) withdrawList).size() !=0) {
            return withdrawList;
        } else {
            return null;

        }
    }
}
