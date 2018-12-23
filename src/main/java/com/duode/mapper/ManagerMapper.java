package com.duode.mapper;

import com.duode.model.Manager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/23
 */
public interface ManagerMapper {
    public int addManager(@Param("manager") Manager manager);
    public List<Manager> getByTelephone(@Param("manager") Manager manager);
}
