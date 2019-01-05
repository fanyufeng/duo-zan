package com.duode.service;

import com.duode.mapper.FactoryMapper;
import com.duode.model.Factory;
import com.duode.model.Manager;
import com.duode.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/25
 */
@Service
public class FactoryService {
    @Autowired
    public FactoryMapper factoryMapper;

    public int  addFactory(Factory factory){
        int  factoryReponse = factoryMapper.addFactory(factory);
        return factoryReponse;
    }


    public int updateFactory(Factory factory){
        int code = factoryMapper.updateFactory(factory);
        return code;
    }

    public List<Factory> getfactoryList(){
        List<Factory> factoryList= factoryMapper.findFactory();
        if (((List) factoryList).size() !=0) {
            return factoryList;
        } else {
            return null;

        }
    }
}
