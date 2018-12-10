package com.duode.mapper;

import com.duode.model.Card;
import org.apache.ibatis.annotations.Param;

/**
 * Created by fanyufeng on 2018/11/25.
 */
public interface CardMapper {
    public Card findCard(@Param("unique_id") String unique_id);
    public int addCard(@Param("card") Card card);
    public int updateCard(@Param("card") Card card);

}
