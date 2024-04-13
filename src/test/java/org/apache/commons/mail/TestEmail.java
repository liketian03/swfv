package org.apache.commons.mail;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TestEmail {
    public static void main(String[] args) {
        // 创建Email对象
        Email email = new SimpleEmail();
        // 设置邮件服务器主机名和端口号
        email.setHostName("smtp.163.com");
        email.setSmtpPort(465);

        //检查主机名设置是否出错
        if(!email.getHostName().equals("smtp.163.com")){
            System.out.println("Error: Failed to set HostName");
        }

        email.setAuthentication("iwanna1222@163.com", "KUHDZGDPJCEJAWFJ");
        email.setSSLOnConnect(true);

        //检查是否能发送邮件
        try {
            email.setFrom("iwanna1222@163.com");
            email.addTo("2358599752@qq.com");
            email.setSubject("Test Email");
            email.setMsg("This is a test email.(without JUnit)");
            email.send();
            System.out.println("Email sent successfully!");
        } catch (EmailException e) {
            System.out.println("Error: Failed to send email");
            //获取异常原因
            Throwable cause = e.getCause();
            if(cause != null)
                System.out.println("Error: " + cause.getMessage());
            e.printStackTrace();
        }

    }
}


