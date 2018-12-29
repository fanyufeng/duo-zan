package com.duode.service;

import com.duode.mapper.AdvertiseMapper;
import com.duode.mapper.CardMapper;
import com.duode.model.Advertise;
import com.duode.model.Card;
import com.duode.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/2
 */
@Service
public class AdvertiseService {
    @Autowired
    public AdvertiseMapper advertiseMapper;

    public int addAdvertise(Advertise advertise) {
        int advertiseResponse = advertiseMapper.addAdvertise(advertise);
        return advertiseResponse;
    }

    public Advertise findAdvertise(int id) {
        Advertise advertise =  advertiseMapper.findAdvertise(id);
        return advertise;
    }


    public int updateAdvertise(Advertise advertise){
        int code = advertiseMapper.updateAdvertise(advertise);
        return code;
    }

    public List<Advertise> getAdvertiseList(){
        List<Advertise> advertiseList= advertiseMapper.findAdvertise();
        if ( advertiseList.size() !=0) {
            return advertiseList;
        } else {
            return null;

        }
    }

}
