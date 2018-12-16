package com.duode.service;

import com.duode.mapper.UserMapper;
import com.duode.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanyufeng on 2018/11/25.
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserInfo(int id){
        User user=userMapper.findUserInfo(id);
        return user;
    }

    public int  addUserInfo(User user){
        int  userReponse = userMapper.addUser(user);
        return userReponse;
    }

    public User getUserByUnionId(String unionid) {

        User user = userMapper.getByUnionId(unionid);

        return user;

    }

    public int updateUser(User user){
        int code = userMapper.updateUser(user);
        return code;
    }

    public int updateUserIntegration(User user) {
        int code = userMapper.updateUserIntegration(user);
        return code;
    }

}
