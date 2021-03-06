package com.duode.mapper;



import com.duode.model.CashUse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/11
 */
public interface CashUseMapper {
    public int addCashUse(CashUse cashUse);
    public List<CashUse> findCashUser(@Param("cash_use") CashUse cash_use);

    public List<CashUse> findCashUseAll();
}
