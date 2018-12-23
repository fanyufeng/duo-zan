package com.duode.controller;

import com.duode.service.CardUseService;
import net.sf.json.JSONObject;

import com.duode.config.AESUtil;
import com.duode.constant.ApiStatusCode;
import com.duode.constant.Constants;
import com.duode.model.User;
import com.duode.request.UserRegisterRequest;
import com.duode.response.ResponseDataModel;
import com.duode.service.UserService;
import org.apache.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fanyufeng on 2018/11/25.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CardUseService cardUseService;

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel addUserX(@RequestBody UserRegisterRequest userRegisterRequest, HttpServletRequest request, HttpServletResponse response) {
        ResponseDataModel resDataModel = new ResponseDataModel();
        User user = userService.getUserInfo(userRegisterRequest.getUser_id());
        if(user != null ) {
            resDataModel.setData(user);
            resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            resDataModel.setStatusCode(ApiStatusCode.CODE_COMPARE_ERROR.value());
        }

        return resDataModel;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel addUser(@RequestBody UserRegisterRequest userRegisterRequest, HttpServletRequest request, HttpServletResponse response) {
        ResponseDataModel resDataModel = new ResponseDataModel();
        try {
            String JSCODE=userRegisterRequest.getCode();
            String jsonString="https://api.weixin.qq.com/sns/jscode2session?appid="+ Constants.APPID+"&secret="+Constants.SECRET+"&js_code="+JSCODE+"&grant_type=authorization_code";
            String jsonFan = loadJson(jsonString);
            //检测jsonFan字符串
            String res=".*errmsg.*";

            Boolean matchResult= jsonFan.matches(res);
            if(matchResult){
                resDataModel.setStatusCode(ApiStatusCode.EMPLOYEE_OPENID_ERROR.value());
            }else{


                JSONObject jsonObject = JSONObject.fromObject(jsonFan);
                System.out.println(jsonFan);
                String openid = jsonObject.getString("openid");
                String sessionKey=jsonObject.getString("session_key");

                byte[] resultByte = AESUtil.instance.decrypt(Base64.decodeBase64(userRegisterRequest.getEncryptedData()), Base64.decodeBase64(sessionKey), Base64.decodeBase64(userRegisterRequest.getIv()));


                logger.info("=========resultByte======="+resultByte);
                if(null != resultByte && resultByte.length > 0){
                    String userInfo = new String(resultByte, "UTF-8");
                    JSONObject json = JSONObject.fromObject(userInfo); //将字符串{“id”：1}
                    logger.info("=========json======="+json);
                    System.out.println("json:" + json);
                    String unionidx=json.getString("unionId");



                    if(unionidx!=null){
                        System.out.println("=====unionidx=====: " + unionidx);

                        User user=userService.getUserByUnionId(unionidx);
                        System.out.print("======user==== :"+ user);

                        if(user==null){
                            User  employeeVOModel=new User();
                            employeeVOModel.setOpenid(openid);
                            employeeVOModel.setUnionid(unionidx);
                            request.getSession().setAttribute(Constants._SESSION_USER_ID_KEYPREFIX,unionidx);
                            employeeVOModel.setAvatar_url(userRegisterRequest.getAvatarUrl());
                            employeeVOModel.setNick_name(userRegisterRequest.getNickName());
                            employeeVOModel.setGender(userRegisterRequest.getGender());
                            employeeVOModel.setSession_key(sessionKey);

                            int userTY =userService.addUserInfo(employeeVOModel);
                            User employeeVOElem=userService.getUserByUnionId(unionidx);
                            if (employeeVOElem != null) {
                                resDataModel.setData(employeeVOElem);
                                resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
                            } else {
                               resDataModel.setData(ApiStatusCode.EMPLOYEE_USER_NOT_EXIST.value());
                            }

                        }else{
                            request.getSession().setAttribute(Constants._SESSION_USER_ID_KEYPREFIX,unionidx);
                            user.setOpenid(openid);
                            user.setUnionid(unionidx);
                            user.setSession_key(sessionKey);
                            userService.updateUser(user);
                            resDataModel.setData(user);
                            resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
                        }
                    }else{
                        resDataModel.setStatusCode(ApiStatusCode.EMPLOYEE_OPENID_ERROR.value());
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resDataModel;
    }

    @RequestMapping(value = "/getUserDetail", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getUserDetail(@RequestBody UserRegisterRequest userRegisterRequest, HttpServletRequest request, HttpServletResponse response) {
        ResponseDataModel resDataModel = new ResponseDataModel();
        User userU = userService.getUserInfo(userRegisterRequest.getUser_id());
        if (userU !=null) {
            resDataModel.setData(userU);
            resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
        }
        return resDataModel;
    }

    @RequestMapping(value = "/getUserListByIntegration", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getUserListByIntegration(@RequestBody UserRegisterRequest userRegisterRequest, HttpServletRequest request, HttpServletResponse response) {
        ResponseDataModel resDataModel = new ResponseDataModel();
        List<User> userU = userService.getUserListByIntegration();
        if (userU !=null) {
            resDataModel.setData(userU);
            resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
        }
        return resDataModel;
    }

    @RequestMapping(value = "/getUserByIntegrationYesterday", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getUserByIntegrationYesterday(@RequestBody UserRegisterRequest userRegisterRequest, HttpServletRequest request, HttpServletResponse response) {
        ResponseDataModel resDataModel = new ResponseDataModel();
        Map userU = cardUseService.getUserListYesterday();
        if (userU !=null) {
            resDataModel.setData(userU);
            resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
        }
        return resDataModel;
    }

    public static String loadJson (String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }


}
