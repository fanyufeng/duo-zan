package com.duode.mapper;

import com.duode.model.Factory;
import com.duode.model.Manager;
import com.duode.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/23
 */
public interface FactoryMapper {
    public int addFactory(@Param("factory") Factory factory);
    public int updateFactory(@Param("factory") Factory factory);
    public List<Factory> findFactory();

}
