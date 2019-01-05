package com.duode.mapper;

import com.duode.model.Product;
import com.duode.model.Withdraw;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/23
 */
public interface WithdrawMapper {
    public List<Withdraw> findWithdrawInfo(@Param("id") int id);
    public int addWithdraw(@Param("withdraw") Withdraw withdraw);
    public int updateWithdraw(@Param("withdraw") Withdraw withdraw);
    public List<Withdraw> findWithdraw();

}
