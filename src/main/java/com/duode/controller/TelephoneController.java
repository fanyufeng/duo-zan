package com.duode.controller;

import com.duode.constant.ApiStatusCode;
import com.duode.model.TelephoneCode;
import com.duode.model.User;
import com.duode.model.Withdraw;
import com.duode.request.TelephoneMessageRequest;
import com.duode.response.ResponseDataModel;
import com.duode.service.TelephoneCodeService;
import com.duode.service.UserService;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fanyufeng in 19/1/9
 */
@RestController
@RequestMapping("/telephone")
public class TelephoneController {

    @Autowired
    public TelephoneCodeService telephoneCodeService;

    @Autowired
    public UserService userService;

    // 短信应用SDK AppID
    private static int appid = 1400178509; // 1400开头

    // 短信应用SDK AppKey
    private static String appkey = "dfd543945f1b7e30512adb7d6e1d5bae";

    // 需要发送短信的手机号码
    String[] phoneNumbers = {"15201315375"};

    // 短信模板ID，需要在短信应用中申请
    int templateId = 7839; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请

    // 签名
    String smsSign = "腾讯云"; // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`

    @RequestMapping(value="/code/send",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel codeSend(@RequestBody TelephoneCode telephoneCode) {
        ResponseDataModel response = new ResponseDataModel();
        try {
            String code = createRandomCode();
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            String msg="【多得科技】您的验证码为"+code;
            telephoneCode.setCode(code);

            List<TelephoneCode> telephoneCodeList = telephoneCodeService.gettelephoneCodeList(telephoneCode);
            if (telephoneCodeList !=null) {
                TelephoneCode ty= telephoneCodeList.get(0);
                ty.setCode(code);
                telephoneCodeService.updateTelephoneCode(ty);
            } else {
                int result1 = telephoneCodeService.addTelephoneCode(telephoneCode);
            }

            SmsSingleSenderResult result = ssender.send(0, "86", telephoneCode.getTelephone(),
                    msg, "", "");
            System.out.println(result);
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @RequestMapping(value="/code/compare",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel codeCompare(@RequestBody TelephoneMessageRequest telephoneMessageRequest) {
        ResponseDataModel response = new ResponseDataModel();
        try {
            TelephoneCode telephoneCode = new TelephoneCode();
            telephoneCode.setTelephone(telephoneMessageRequest.getTelephone());
            telephoneCode.setCode(telephoneMessageRequest.getCode());


            List<TelephoneCode> compareList= telephoneCodeService.gettelephoneCodeList(telephoneCode);
            User user = userService.getUserInfo(telephoneMessageRequest.getUser_id());
            if (compareList!=null && user!=null) {
                TelephoneCode compareElem= compareList.get(0);
                if (compareElem.getCode().equals(telephoneCode.getCode())) {
                    user.setTelephone(compareElem.getTelephone());
                    userService.updateUser(user);
                } else {
                    response.setStatusCode(ApiStatusCode.CODE_COMPARE_ERROR.value());
                }
            } else {
                response.setStatusCode(ApiStatusCode.CODE_COMPARE_ERROR.value());
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     *  注册验证码生成
     * @return
     */
    public static String createRandomCode(){
        String code="";
        for(int i=0;i<4;i++){
            code=code+(int)(Math.random()*9);
        }
        return code;
    }
}
