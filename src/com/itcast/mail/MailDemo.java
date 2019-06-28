package com.itcast.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;


public class MailDemo {

	public static void main(String[] args) throws Exception {
		fun1();
	}

	public static void fun1() throws Exception {
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.smtp.auth", "true");
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
//				return new PasswordAuthentication("1272157479", "ZJNO.1ZYY");
				return new PasswordAuthentication("zzj19930120", "204513ZZJ");
			}
		};
		Session session = Session.getInstance(props, auth);
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("zzj19930120@163.com"));
//		msg.addRecipients(RecipientType.TO, "1272157479@qq.com");
		msg.addRecipients(RecipientType.TO, "zzj19930120@163.com");
		msg.setSubject("硕1603团支部-毕业生团员组织关系介绍信登记表");
		msg.setContent("远光软件股份有限公司：\r\n" + 
				"    您好，我是张中建，三方协议违约金已转入，请查收。\r\n" + 
				"    转账流水号：116825695737\r\n" + 
				"    转账时间：2018年11月20日11点14分\r\n" + 
				"    解约函收件人：张中建\r\n" + 
				"    联系电话：13164154651\r\n" + 
				"    寄送地址：湖北省武汉市洪山区珞喻路华中科技大学在地图中查看西六舍\r\n" + 
				"    邮政编码：430074","text/html;charset=utf-8");
		
		Transport.send(msg);
	}
}
