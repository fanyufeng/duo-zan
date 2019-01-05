package com.duode.mapper;

import com.duode.model.Cash;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/23
 */
public interface CashMapper {
    public int addCash(@Param("cash") Cash cash);
    public int updateCash(@Param("cash") Cash cash);
    public List<Cash> findCash();

}
