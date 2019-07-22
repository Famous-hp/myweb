package com.util;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Map;


public class CaptchaUtil {
    // 短信应用SDKAppID
            private static int appid = 1400216273; // 1400开头

         // 短信应用SDKAppKey
         private static String appkey ="d2b1669f99986418c9fb69ff00ef5387";

         // 短信模板ID，需要在短信应用中申请
        // NOTE:真实的模板ID需要在短信控制台中申请
        private static int templateId =348041;
        // 签名
        // NOTE:真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`
         private static String smsSign = "晨曦zyx";

     /**
      * 发送短信验证码
      *
      * @paramtel 电话号码
      * @paramverifyCode 验证码
      * @return
      */
         public static String sendCaptcha(String tel){
             String news = "";
            try{
         // 需要发送短信的手机号码
               String phoneNumber = tel;

                // 单发短信

                // SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
                // SmsSingleSenderResult result = ssender.send(0, "86", phoneNumber, "您正在注册成为好学堂用户，您的验证码为：" + verifyCode + "，请在10分钟内完成验证，感谢您的支持！", "", "");

               //指定模板ID单发短信
                    int num = (int) (Math.random()*9000+1000);
                    news = num + "";
                    String[] params = {news};
                    SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
                    SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber,templateId, params, smsSign, "", "");
                    // 签名参数未提供或者为空时，会使用默认签名发送短信
                   System.out.print(result);

            } catch(HTTPException e) {
                // HTTP响应码错误
                e.printStackTrace();
                } catch(JSONException e) {
                    // json解析错误
                    e.printStackTrace();
                } catch(IOException e) {
                    // 网络IO错误
                e.printStackTrace();
                }

                return news;
         }


}
