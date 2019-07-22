package com.action;
import java.util.*;
import  com.service.*;
import  com.entity.*;

import com.util.CalculatorUtil;
import com.util.CaptchaUtil;
import com.util.VerifyCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Value("${spring.datasource.url}")
     private String url;
    @Autowired
    private IDeptService ds;

    @Autowired
    private IEmpService es;

    @RequestMapping(value = "/index")
    public  String index(){
      System.out.println("-----------idnex");
        System.out.println("--url"+url);

        List<Dept> list=ds.selectAll();
        System.out.println("list"+list);
        return "index";
    }
  @RequestMapping(value = "/regist")
   @ResponseBody()
    public  void  zhu(ModelAndView mov, String tel, HttpSession session){

      System.out.println("---tel"+tel);
      String num = CaptchaUtil.sendCaptcha(tel);
      System.out.println("------num="+num);
      session.setAttribute("news",num);;
      this.removeAttrbute(session);

  }


    @RequestMapping(value="/zhuce")
    public ModelAndView reg(ModelAndView mvo,HttpSession session,String code){
        System.out.println("code="+code);
        String news = (String) session.getAttribute("news");
        System.out.println("news="+news);
        if (code.equals(news)){
            System.out.println("1111");
            mvo.setViewName("success");
        }
        return mvo;
    }


  @RequestMapping(value="testAction")
    public String test(HttpServletRequest request){
      String content=request.getParameter("editorValue");
      System.out.println("editorValue= /n"+content);
      request.setAttribute("content", content);

        return "success" ;
  }

    private void removeAttrbute(final HttpSession session){
            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    session.removeAttribute("news");
                    timer.cancel();
                }
            },60000);
    }
    @RequestMapping("/info")
    public ModelAndView info(ModelAndView mvo){
        System.out.println("---------info");
        mvo.setViewName("info");
        return mvo;
    }
}




