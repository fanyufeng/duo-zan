package com.duode.mapper;

import com.duode.model.Checkin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/23
 */
public interface CheckinMapper {
    public List<Checkin> findCheckinInfo(@Param("id") int id);
    public int addCheckin(Checkin checkin);
    public List<Checkin> findCheckin();

}
