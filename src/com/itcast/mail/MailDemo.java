package com.itcast.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.junit.Test;

public class MailDemo {

	@Test
	public void fun1() throws AddressException, MessagingException {
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.smtp.auth", "true");
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("zzj19930120", "204513ZZJ");
			}
		};
		Session session = Session.getInstance(props, auth);
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("zzj19930120@163.com"));
		msg.addRecipients(RecipientType.TO, "1272157479@qq.com");
		msg.setSubject("这是测试邮件");
		msg.setContent("JavaMail之HelloWorld","text/plain;charset=utf-8");
	}
}
