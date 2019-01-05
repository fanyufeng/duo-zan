package com.duode.service;

import com.duode.mapper.WithdrawMapper;
import com.duode.model.Withdraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/25
 */
@Service
public class WithdrawService {

    @Autowired
    public WithdrawMapper withdrawMapper;

    public List<Withdraw>  getWithdraw(int withdraw_id){
        List<Withdraw>  withdrawReponse = withdrawMapper.findWithdrawInfo(withdraw_id);

        if(withdrawReponse.size()==0) {
            return null;
        } else {

            return withdrawReponse;
        }

    }

    public int  addWithdraw(Withdraw withdraw){
        int  withdrawReponse = withdrawMapper.addWithdraw(withdraw);
        return withdrawReponse;
    }


    public int updateWithdraw(Withdraw withdraw){
        int code = withdrawMapper.updateWithdraw(withdraw);
        return code;
    }

    public List<Withdraw> getwithdrawList(){
        List<Withdraw> withdrawList= withdrawMapper.findWithdraw();
        if (((List) withdrawList).size() !=0) {
            return withdrawList;
        } else {
            return null;

        }
    }
}
