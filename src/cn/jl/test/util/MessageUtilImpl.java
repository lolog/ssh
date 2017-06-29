package cn.jl.test.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

/**
 * 完成邮件的发送
 */
@Component("messageUtil")
public class MessageUtilImpl implements MessageUtil
{
	/* (non-Javadoc)
	 * @see cn.jl.test.util.MessageUtil#sendEmail(java.lang.String)
	 */
	@Override
	public void sendEmail(String email) {
		// 登录邮件客户端(创建会话Session)
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");
		// 创建Session会话
		Session session = null;
		Message message = null;
		Transport transport = null;

		try {
			session = Session.getDefaultInstance(properties);
			// 设置为Debug模式,方便发送信息
			session.setDebug(true);
			// 创建邮件对象
			message = new MimeMessage(session);
			// 写信
			message.setSubject("CIMC");
			// 正文内容
			message.setContent("内容", "text/html;charset=utf-8");
			// 发件人地址
			message.setFrom(new InternetAddress("soft03_test@sina.com"));
			// 设置收件人地址和链接邮件服务器的认证信息
			transport = session.getTransport();
			transport.connect("smtp.sina.com", "soft03_test", "soft03_test");
			transport.sendMessage(message, new InternetAddress[] { new InternetAddress("arcosin@sina.com") });
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			try {
				transport.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

	}
}
