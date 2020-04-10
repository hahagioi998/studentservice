package shiyan;

import java.security.GeneralSecurityException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import swu.zhj.util.DateDown;
import swu.zhj.util.SendqqMail;

public class shiyan1 {

	public static void main(String[] args) throws AddressException, MessagingException, GeneralSecurityException {
		// TODO Auto-generated method stub
        /*String people="1640085377@qq.com";
        SendqqMail.send(people);*/
		Random rd=new Random();
		String x="a";
		for(int i=1;i<=5;i++){
			x=x+(rd.nextInt(10)+1);
		}
		System.out.println(x);
	}

}
