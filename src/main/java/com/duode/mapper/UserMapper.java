package com.duode.mapper;

import com.duode.model.User;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fanyufeng on 2018/11/25.
 */
public interface UserMapper {
    public List<User> findUserInfo(@Param("id") int id);

    public int addUser(@Param("user") User user);

    public List<User> getByUnionId(@Param("unionid") String unionid);

    public List<User> findUserList();
    public int updateUser(@Param("user") User user);
    public int updateUserIntegration(@Param("user") User user);
}
