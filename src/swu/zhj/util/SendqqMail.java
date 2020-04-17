package swu.zhj.util;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class SendqqMail {
	public static void send(String people,String password,String title) throws AddressException, MessagingException, GeneralSecurityException {
        Properties props = new Properties();
        props.setProperty("mail.host", "smtp.qq.com");
        props.setProperty("mail.smtp.auth", "true");
        //QQ邮箱的SSL加密。
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);
        //authenticator参数，登录自己的邮箱帐号密码，
        Authenticator authenticator = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("你的qq@qq.com","你的");
            }
        };        
        Session session = Session.getDefaultInstance(props, authenticator);                     
        //2、发送的内容对象Mesage
        Message message = new MimeMessage(session);
        //2.1、发件人是谁
        message.setFrom(new InternetAddress("你的qq@qq.com"));
        // 2.2  , to:收件人 ; cc:抄送 ; bcc :暗送.
        /**
         * 收件人是谁？
         *         第一个参数：
         *             RecipientType.TO    代表收件人 
         *             RecipientType.CC    抄送
         *             RecipientType.BCC    暗送
         *         比如A要给B发邮件，但是A觉得有必要给要让C也看看其内容，就在给B发邮件时，
         *         将邮件内容抄送给C，那么C也能看到其内容了，但是B也能知道A给C抄送过该封邮件
         *         而如果是暗送(密送)给C的话，那么B就不知道A给C发送过该封邮件。
         *     第二个参数
         *         收件人的地址，或者是一个Address[]，用来装抄送或者暗送人的名单。或者用来群发。
         */
        message.setRecipient(RecipientType.TO, new InternetAddress(people));
        // 2.3 主题（标题）
        message.setSubject(title);
        // 2.4 正文
        String str =password;
        message.setContent(str, "text/html;charset=UTF-8");
        //3、发送
        Transport.send(message);
    }
}
