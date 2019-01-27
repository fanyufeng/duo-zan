package com.duode.service;

import com.duode.constant.ApiStatusCode;
import com.duode.model.Card;
import com.duode.model.CashUse;
import com.duode.model.Cashtotal;
import com.duode.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by fanyufeng in 19/1/27
 */
@Component
public class ScheduledService {

    @Autowired
    public UserService userService;
    @Autowired
    public CashtotalService cashtotalService;
    @Autowired
    public CardService cardService;
    @Autowired
    public CashUseService cashUseService;


    SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd");

    @Scheduled(cron = "0 18 17 * * ?")
    public void cashDistribute () {
        try {
            List<User> userList = userService.getUserList();

            Cashtotal cashtotal = new Cashtotal();
            cashtotal.setStatus(0);
            Date date = new Date();
            String timex=sdft.format(date);
            cashtotal.setDeadline(timex);
            System.out.println("sgsd"+cashtotal.toString());
            List<Cashtotal> cashtotalList =cashtotalService.findDistributeInfo(cashtotal);

            if (cashtotalList != null) {
                Cashtotal cashtotal1=cashtotalList.get(0);
                cashtotal1.setStatus(1);
                cashtotalService.updateCashtotal(cashtotal1);
                List<Card> cardList = cardService.findCardAll();
                int sum = 0;
                for (User user : userList) {
                    sum =sum+user.getIntegration();
                }


                double proprotion=cashtotal1.getCash_total()/sum;

                for (User userL : userList) {
                    double cash_elem = userL.getIntegration() * proprotion;
                    userL.setCash(cash_elem + userL.getCash());
                    userService.updateUser(userL);
                    CashUse cashUse = new CashUse();
                    cashUse.setCash_num(cash_elem);
                    cashUse.setCash_total_id(cashtotal1.getId());
                    cashUse.setUser_id(userL.getId());
                    cashUseService.addCashUse(cashUse);
                }
            }






        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
