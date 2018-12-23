package com.duode.service;

import com.duode.mapper.ManagerMapper;
import com.duode.model.Manager;
import com.duode.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by fanyufeng in 18/12/23
 */
public class ManagerService {
    @Autowired
    public ManagerMapper managerMapper;

    public int  addManagerInfo(Manager manager){
        int  userReponse = managerMapper.addManager(manager);
        return userReponse;
    }

    public Manager  getByTelephone(Manager manager){
        List<Manager> userReponseList = managerMapper.getByTelephone(manager);
        if(userReponseList.size()!=0) {
            Manager userResponse = userReponseList.get(0);
            return userResponse;
        } else {
            return null;
        }
    }
}
