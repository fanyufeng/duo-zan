package com.duode.mapper;

import com.duode.model.Advertise;
import com.duode.model.Advertiser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fanyufeng on 2018/11/25.
 */
public interface AdvertiserMapper {
    public Advertiser findAdvertiser(@Param("id") int id);
    public int addAdvertiser(@Param("advertiser") Advertiser advertiser);
    public int updateAdvertiser(@Param("advertiser") Advertiser advertiser);
    public List<Advertiser> findAdvertiser();
}
