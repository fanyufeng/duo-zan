package com.duode.controller;

import com.duode.constant.ApiStatusCode;
import com.duode.model.User;
import com.duode.model.Withdraw;
import com.duode.response.ResponseDataModel;
import com.duode.service.TelephoneCodeService;
import com.duode.service.UserService;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResponseDataModel codeSend(@RequestBody Withdraw withdraw) {
        ResponseDataModel response = new ResponseDataModel();
        try {
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.send(0, "86", phoneNumbers[0],
                    "【多得科技】您的验证码是: 5678", "", "");
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @RequestMapping(value="/code/compare",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel codeCompare(@RequestBody Withdraw withdraw) {
        ResponseDataModel response = new ResponseDataModel();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
