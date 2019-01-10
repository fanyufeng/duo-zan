package com.duode.service;

import com.duode.mapper.TelephoneCodeMapper;
import com.duode.mapper.TelephoneCodeMapper;
import com.duode.model.TelephoneCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/25
 */
@Service
public class TelephoneCodeService {

    @Autowired
    public TelephoneCodeMapper telephoneCodeMapper;

    public List<TelephoneCode>  getTelephoneCode(int telephoneCode_id){
        List<TelephoneCode>  telephoneCodeReponse = telephoneCodeMapper.findTelephoneCodeInfo(telephoneCode_id);

        if(telephoneCodeReponse.size()==0) {
            return null;
        } else {

            return telephoneCodeReponse;
        }

    }

    public int  addTelephoneCode(TelephoneCode telephoneCode){
        int  telephoneCodeReponse = telephoneCodeMapper.addTelephoneCode(telephoneCode);
        return telephoneCodeReponse;
    }


    public int updateTelephoneCode(TelephoneCode telephoneCode){
        int code = telephoneCodeMapper.updateTelephoneCode(telephoneCode);
        return code;
    }

    public List<TelephoneCode> gettelephoneCodeList(){
        List<TelephoneCode> telephoneCodeList= telephoneCodeMapper.findTelephoneCode();
        if (((List) telephoneCodeList).size() !=0) {
            return telephoneCodeList;
        } else {
            return null;

        }
    }
}
