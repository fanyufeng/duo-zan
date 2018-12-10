package com.duode.mapper;


import com.duode.model.CardUse;
import org.apache.ibatis.annotations.Param;

/**
 * Created by fanyufeng in 18/12/11
 */
public interface CardUseMapper {
    public int addCardUse(@Param("card_use") CardUse card_use);
}
