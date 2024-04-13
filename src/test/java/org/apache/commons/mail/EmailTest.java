package org.apache.commons.mail;

import junit.framework.TestCase;

public class EmailTest extends TestCase {
    private Email email;

    public void setUp() throws Exception {
        email = new SimpleEmail();
        email.setHostName("smtp.163.com");
        email.setSmtpPort(465);
    }

    public void testSetHostName() {
        String actualHostName = email.getHostName();
        assertEquals("smtp.163.com", actualHostName);
    }

    public void testSend() {
        email.setAuthentication("iwanna1222@163.com", "KUHDZGDPJCEJAWFJ");
        email.setSSLOnConnect(true);

        try {
            email.setFrom("iwanna1222@163.com");
            email.addTo("2358599752@qq.com");
            email.setSubject("Test Email");
            email.setMsg("This is a test email.(with JUnit)");
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
