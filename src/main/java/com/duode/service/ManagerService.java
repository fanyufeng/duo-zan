package com.duode.service;

import com.duode.mapper.ManagerMapper;
import com.duode.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by fanyufeng in 18/12/23
 */
@Service
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
