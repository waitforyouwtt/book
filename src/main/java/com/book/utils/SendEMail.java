package com.book.utils;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @Author: 一点点
 * @Date: 2019/4/21 18:05
 * @Version 1.0
 */
public class SendEMail {

    /**
     * 发送email
     * @param email
     * @param emailMsg
     * @return
     */
    public static boolean sendMail(String email, String emailMsg) {

        String from = email;
        String to = email;
        final String username = "17621007255@163.com";
        //授权码，不同与登陆密码
        final String password = "abcd1234";


        Properties props = new Properties();

        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", "smtp.163.com");
        props.setProperty("mail.smtp.auth", "true");
        Session session = Session.getInstance(props);
        session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setSubject("激活注册验证码");
            //message.setText("Welcome to JavaMail World!");
            message.setContent(emailMsg,"text/html;charset=utf-8");
            Transport transport=session.getTransport();
            transport.connect("smtp.163.com",25, username, password);
            transport.sendMessage(message,new Address[]{new InternetAddress(to)});
            transport.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
