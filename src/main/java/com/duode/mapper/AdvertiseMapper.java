package com.duode.mapper;

import com.duode.model.Advertise;
import com.duode.model.Card;
import org.apache.ibatis.annotations.Param;

/**
 * Created by fanyufeng on 2018/11/25.
 */
public interface AdvertiseMapper {
    public Advertise findAdvertise(@Param("id") int id);
    public int addAdvertise(@Param("advertise") Advertise advertise);
}
