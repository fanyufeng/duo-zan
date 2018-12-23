package com.duode.controller;

import com.duode.constant.ApiStatusCode;
import com.duode.model.Manager;
import com.duode.model.User;
import com.duode.request.UserRegisterRequest;
import com.duode.response.ResponseDataModel;
import com.duode.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fanyufeng in 18/12/23
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    public ManagerService managerService;


    @RequestMapping(value = "/getByTelephone", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getByTelephone(@RequestBody Manager manager, HttpServletRequest request, HttpServletResponse response) {
        ResponseDataModel resDataModel = new ResponseDataModel();
        Manager manager1 = managerService.getByTelephone(manager);
        if(manager1 != null ) {
            resDataModel.setData(manager1);
            resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            resDataModel.setStatusCode(ApiStatusCode.EMPLOYEE_LOGIN_PASSWORD_ERROR.value());
        }
        return resDataModel;
    }
}
