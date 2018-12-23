package com.duode.mapper;


import com.duode.model.CardUse;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by fanyufeng in 18/12/11
 */
public interface CardUseMapper {
    public int addCardUse(@Param("card_use") CardUse card_use);

    public Map getUserListYesterday(@Param("date") String date);
}
