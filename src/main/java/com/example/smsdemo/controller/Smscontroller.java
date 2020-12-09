package com.example.smsdemo.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.example.smsdemo.util.Sms;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sms")
public class Smscontroller {

    @RequestMapping(value = "/sendCode",method = RequestMethod.GET)
    public String zhuansms(){
        System.out.println("转页面=================");
        return "yanzhengma";
    }

    @RequestMapping(value = "/sendCode",method = RequestMethod.POST)
    @ResponseBody
    public String sms(String phone) throws ClientException {
        System.out.println(phone+"===============================");
        String code = RandomStringUtils.randomNumeric(6);
        SendSmsResponse sendSms =Sms.sendSms(phone,code);//填写你需要测试的手机号码
        System.out.println("短信接口返回的数据----------------");
        System.out.println("Code=" + sendSms.getCode());
        System.out.println("Message=" + sendSms.getMessage());
        System.out.println("RequestId=" + sendSms.getRequestId());
        System.out.println("BizId=" + sendSms.getBizId());
        return code;
    }
}
