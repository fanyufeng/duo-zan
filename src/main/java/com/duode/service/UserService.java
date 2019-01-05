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
        List<User> userList=userMapper.findUserInfo(id);
        if (userList.size()!=0 ){
            User user = userList.get(0);
            return user;
        } else {
            return null;
        }

    }

    public int  addUserInfo(User user){
        int  userReponse = userMapper.addUser(user);
        return userReponse;
    }

    public User getUserByUnionId(String unionid) {

        List<User> userList = userMapper.getByUnionId(unionid);
        System.out.println("userList:" + userList);
        if (userList.size() != 0) {
            User user = userList.get(0);
            return user;
        } else {
            return null;
        }
    }

    public List<User> getUserListByIntegration() {

        List<User> userList = userMapper.findUserList();
        if (userList.size() != 0) {
            return userList;
        } else {
            return null;
        }

    }

    public List<User> getUserList() {
        List<User> userList = userMapper.getUserList();
        if (userList.size() != 0) {
            return userList;
        } else {
            return null;
        }

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
