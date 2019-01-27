package com.duode.mapper;

import com.duode.model.Cashtotal;
import com.duode.model.Withdraw;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/23
 */
public interface CashtotalMapper {
    public List<Cashtotal> findCashTotalInfo(@Param("id") int id);
    public List<Cashtotal> findDistributeInfo(@Param("cashTotal") Cashtotal cashtotal);
    public int addCashtotal(@Param("cashTotal") Cashtotal cashTotal);
    public int updateCashtotal(@Param("cashTotal") Cashtotal cashTotal);
    public List<Cashtotal> getCashtotalStatus(@Param("status") int status);
    public List<Cashtotal> findCashtotal();
}
