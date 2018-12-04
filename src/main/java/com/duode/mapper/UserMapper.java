package com.duode.mapper;

import com.duode.model.User;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

/**
 * Created by fanyufeng on 2018/11/25.
 */
public interface UserMapper {
    public User findUserInfo(@Param("id") int id);

    public int addUser(@Param("user") User user);

    public User getByUnionId(@Param("unionid") String unionid);
    public int updateUser(@Param("user") User user);

}
