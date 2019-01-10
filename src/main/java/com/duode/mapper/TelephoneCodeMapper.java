package com.duode.mapper;

import com.duode.model.TelephoneCode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/23
 */
public interface TelephoneCodeMapper {
    public List<TelephoneCode> findTelephoneCodeInfo(@Param("id") int id);
    public int addTelephoneCode(@Param("telephoneCode") TelephoneCode telephoneCode);
    public int updateTelephoneCode(@Param("telephoneCode") TelephoneCode telephoneCode);
    public List<TelephoneCode> findTelephoneCode(@Param("telephoneCode") TelephoneCode telephoneCode);

}
