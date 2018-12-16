package com.duode.service;

import com.duode.mapper.AdvertiseMapper;
import com.duode.mapper.AdvertiserMapper;
import com.duode.model.Advertise;
import com.duode.model.Advertiser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fanyufeng in 18/12/2
 */
@Service
public class AdvertiserService {
    @Autowired
    public AdvertiserMapper advertiserMapper;

    public int addAdvertiser(Advertiser advertiser) {
        int advertiseResponse = advertiserMapper.addAdvertiser(advertiser);
        return advertiseResponse;
    }

    public Advertiser findAdvertiser(int id) {
        Advertiser advertiser =  advertiserMapper.findAdvertiser(id);
        return advertiser;
    }


}
