package com.duode.controller;

import com.duode.constant.ApiStatusCode;
import com.duode.model.*;
import com.duode.response.CardUseResponse;
import com.duode.response.CashUseResponse;
import com.duode.response.ResponseDataModel;
import com.duode.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fanyufeng in 18/12/25
 */
@RestController
@RequestMapping("/cash/use/")
public class CashUseController {
    @Autowired
    public CashUseService cashUseService;

    @Autowired
    public CashtotalService cashtotalService;


    @RequestMapping(value="/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel add(@RequestBody CashUse cashUse){
        ResponseDataModel response = new ResponseDataModel();

        try {
            CashUse cashUse1 = new CashUse();

            cashUse1.setUser_id(1);
            cashUse1.setCash_total_id(2);
            cashUse1.setCash_num(1.1);
            CashUse cashUseList = cashUseService.addCashUse(cashUse1);

            response.setData(cashUseList);
        } catch(Exception e) {

        }

        return response;
    }

    @RequestMapping(value="/findCashUse", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel findCardUser(@RequestBody CashUse cashUse){
        ResponseDataModel response = new ResponseDataModel();

        try {
            List<CashUse> cashUseList = cashUseService.findCardUser(cashUse);

            List<CashUseResponse> cashUseResponseList = new ArrayList<>();
            if (cashUseList != null) {
                for (CashUse elem : cashUseList) {
                    List<Cashtotal> cashtotalList = cashtotalService.getCashTotal(elem.getCash_total_id());
                    Cashtotal cashtotal = cashtotalList.get(0);
                    CashUseResponse rt = new CashUseResponse();
                    rt.setCash_num(elem.cash_num);
                    rt.setCash_total_create_time(cashtotal.getCreate_time());
                    rt.setCash_total_id(elem.getCash_total_id());
                    rt.setCash_total_name(cashtotal.getName());
                    rt.setComment(elem.getComment());
                    rt.setCreate_time(elem.getCreate_time());
                    rt.setModify_time(elem.getModify_time());
                    rt.setSatus(elem.getSatus());
                    rt.setUser_id(elem.getUser_id());

                    cashUseResponseList.add(rt);

                }
                response.setData(cashUseResponseList);
                response.setStatusCode(ApiStatusCode.SUCCESS.value());
            } else {
                response.setStatusCode(ApiStatusCode.CODE_COMPARE_ERROR.value());
            }
        } catch(Exception e) {

        }

        return response;
    }

    @RequestMapping(value="/findCashUseAll", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel findCardUseAll(@RequestBody CashUse cashUse){
        ResponseDataModel response = new ResponseDataModel();

        try {
            List<CashUse> cashUseList = cashUseService.findCardUseAll(cashUse);

            List<CashUseResponse> cashUseResponseList = new ArrayList<>();
            if (cashUseList != null) {
                for (CashUse elem : cashUseList) {
                    List<Cashtotal> cashtotalList = cashtotalService.getCashTotal(elem.getCash_total_id());
                    Cashtotal cashtotal = cashtotalList.get(0);
                    CashUseResponse rt = new CashUseResponse();
                    rt.setCash_num(elem.cash_num);
                    rt.setCash_total_create_time(cashtotal.getCreate_time());
                    rt.setCash_total_id(elem.getCash_total_id());
                    rt.setCash_total_name(cashtotal.getName());
                    rt.setComment(elem.getComment());
                    rt.setCreate_time(elem.getCreate_time());
                    rt.setModify_time(elem.getModify_time());
                    rt.setSatus(elem.getSatus());
                    rt.setUser_id(elem.getUser_id());
                    cashUseResponseList.add(rt);
                }
                response.setData(cashUseResponseList);
                response.setStatusCode(ApiStatusCode.SUCCESS.value());
            } else {
                response.setStatusCode(ApiStatusCode.CODE_COMPARE_ERROR.value());
            }
        } catch(Exception e) {

        }

        return response;
    }
//    public static void main(String[] argv) {
//
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//
//        Date date = new Date();
//        System.out.println(date.toString());
//        String dateStr=df.format(date);
//        System.out.println(dateStr);
//    }
}
