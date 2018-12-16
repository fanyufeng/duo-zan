package com.duode.service;

import com.duode.mapper.AdvertiseMapper;
import com.duode.mapper.CardMapper;
import com.duode.model.Advertise;
import com.duode.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
