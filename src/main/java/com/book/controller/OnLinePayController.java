package com.book.controller;

import com.book.utils.PaymentUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 一点点
 * @Date: 2019/4/12 12:09
 * @Version 1.0
 */
@Controller
@Slf4j
public class OnLinePayController {

    @Value("${static.resources.domain}")
    private String staticResourceDomain;

    @GetMapping("/choosePayChannel")
    public ModelAndView payPage(){
        ModelAndView modelAndView = new ModelAndView("choosePayChannel");
        return modelAndView;
    }

    @PostMapping("/toPayPage")
    public String onLinePay(HttpServletRequest request){
       String orderId = request.getParameter( "orderId");
       String money = request.getParameter( "money" );
       String pd_FrpId = request.getParameter( "bank" );
        String p0_Cmd ="Buy";
        String p1_MerId ="10001126856";
        String p2_Order =orderId;
        String p3_Amt =money;
        String p4_Cur = "CNY";
        String p5_Pid ="unknow";
        String p6_Pcat ="unknow";
        String p7_Pdesc ="unknow";
        String p8_Url ="http://localhost:8080/product/callBackServlet";
        String p9_SAF ="1";
        String pa_MP ="unknow";
        String pr_NeedResponse ="1";
        String  hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl");

        request.setAttribute("pd_FrpId", pd_FrpId);
        request.setAttribute("p0_Cmd", p0_Cmd);
        request.setAttribute("p1_MerId", p1_MerId);
        request.setAttribute("p2_Order", p2_Order);
        request.setAttribute("p3_Amt", p3_Amt);
        request.setAttribute("p4_Cur", p4_Cur);
        request.setAttribute("p5_Pid", p5_Pid);
        request.setAttribute("p6_Pcat", p6_Pcat);
        request.setAttribute("p7_Pdesc", p7_Pdesc);
        request.setAttribute("p8_Url", p8_Url);
        request.setAttribute("p9_SAF", p9_SAF);
        request.setAttribute("pa_MP", pa_MP);
        request.setAttribute("pr_NeedResponse", pr_NeedResponse);
        request.setAttribute("hmac", hmac);

        return "confirmPay";
    }
}
