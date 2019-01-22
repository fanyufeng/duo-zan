package com.duode.service;

import com.duode.mapper.CheckinMapper;
import com.duode.model.Checkin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/25
 */
@Service
public class CheckinService {

    @Autowired
    public CheckinMapper checkinMapper;

    public List<Checkin>  getCheckin(int checkin_id){
        List<Checkin>  checkinReponse = checkinMapper.findCheckinInfo(checkin_id);

        if(checkinReponse.size()==0) {
            return null;
        } else {
            return checkinReponse;
        }

    }

    public Checkin  addCheckin(Checkin checkin){
        int  checkinReponse = checkinMapper.addCheckin(checkin);
        return checkin;
    }

    public List<Checkin> getcheckinList(){
        List<Checkin> checkinList= checkinMapper.findCheckin();
        if (((List) checkinList).size() !=0) {
            return checkinList;
        } else {
            return null;

        }
    }

    public List<Checkin> findCheckinNow(Checkin checkin) {
        List<Checkin> checkinList = checkinMapper.findCheckinNow(checkin);
        if (checkinList.size()!=0) {
            return checkinList;
        } else {
            return null;
        }
    }
}
