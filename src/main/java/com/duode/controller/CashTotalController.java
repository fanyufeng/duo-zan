package com.duode.controller;
import com.duode.constant.ApiStatusCode;
import com.duode.model.Cashtotal;
import com.duode.request.CashtotalRequest;
import com.duode.response.ResponseDataModel;
import com.duode.service.CardService;
import com.duode.service.CashtotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fanyufeng in 18/12/25
 */
@RestController
@RequestMapping("/cash/total")
public class CashTotalController {
    @Autowired
    public CashtotalService cashtotalService;

    @Autowired
    public CardService cardService;

    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel addCashtotal(@RequestBody CashtotalRequest cashtotalRequest) {
        ResponseDataModel response = new ResponseDataModel();


        Cashtotal cashtotal = new Cashtotal();
        cashtotal.setStatus(cashtotalRequest.getStatus());
        cashtotal.setCash_total(cashtotalRequest.getCash_total());
        cashtotal.setComment(cashtotalRequest.getComment());
        cashtotal.setUser_id(cashtotalRequest.getUser_id());
        cashtotal.setDeadline(cashtotalRequest.getDeadline());
        int code = cashtotalService.addCashtotal(cashtotal);
        if (code!= 0){
            response.setStatusCode(ApiStatusCode.SUCCESS.value());

        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel updateCashtotal(@RequestBody Cashtotal cashtotal){
        ResponseDataModel response = new ResponseDataModel();
        int code = cashtotalService.updateCashtotal(cashtotal);
        if (code ==1) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }


    @RequestMapping(value="/getCashtotalList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getCashtotalList(@RequestBody Cashtotal cashtotal){
        ResponseDataModel response = new ResponseDataModel();
        List<Cashtotal> cashtotalList = cashtotalService.getCashtotalList();
        if (cashtotalList !=null) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
            response.setData(cashtotalList);
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }


    @RequestMapping(value="/getCashtotalStatus", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getCashtotalStatus(@RequestBody Cashtotal cashtotal){
        ResponseDataModel response = new ResponseDataModel();
        try {
            List<Cashtotal> cashtotalList = cashtotalService.getCashtotalStatus(cashtotal.getStatus());
            List<Cashtotal> cashtotalList1 = new ArrayList<>();

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            if (cashtotalList !=null) {

                for (Cashtotal elem : cashtotalList) {
                    Date ft = simpleDateFormat.parse(elem.getDeadline());
                    long ts = ft.getTime();
                    elem.setDeadline(String.valueOf(ts));
                    cashtotalList1.add(elem);
                }
                response.setStatusCode(ApiStatusCode.SUCCESS.value());
                response.setData(cashtotalList);
            } else {
                response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }


//    public static  void main(String[] argv) {
//        try {
//            String date="2019-01-20 19:56:34";
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date ft = simpleDateFormat.parse(date);
//            long ts = ft.getTime();
//            System.out.println(String.valueOf(ts));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
}
