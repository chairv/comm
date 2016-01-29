package mail;

/**
 * Created by tancw on 2016/1/23.
 */

import org.apache.commons.collections.CollectionUtils;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;

public class EmailUtil {
	public static final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

	public static void sendEmail(EmailHost sHost, Email email) throws Exception {
		// 先配置邮件服务器
		mailSender.setHost(sHost.getSmtpHost());
		mailSender.setUsername(sHost.getUser());
		mailSender.setPassword(sHost.getPwd());
		// 设置邮件的属性
		MimeMessage mime = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mime, true, "utf-8");
		// 设置发件人
		helper.setFrom(sHost.getFrom());
		// 设置恢复到的账号
		helper.setReplyTo(sHost.getReplyTo());
		List<String> recAddrs = email.getAddress();
		if (CollectionUtils.isEmpty(recAddrs)) {
			throw new IllegalAccessError();
		}
		String[] addrs = (String[]) recAddrs.toArray(new String[recAddrs.size()]);
		helper.setTo(addrs);// 收件人
		List<String> ccList = email.getCc();
		if (CollectionUtils.isNotEmpty(ccList)) {
			String[] cc = new String[ccList.size()];
			for (int i = 0; i < ccList.size(); i++) {
				cc[i] = ccList.get(i);
			}
			helper.setCc(cc);// 抄送
		}
		helper.setSubject(email.getSubject());// 邮件主题
		helper.setText(email.getContent(), true);// true表示设定html格式
		mailSender.send(mime);
	}

	public static void main(String[] args) throws Exception {
		Email email = new Email();
		List<String> rec = new ArrayList<String>();
		rec.add("tanchangwei-shenzhen@xyb100.com");
		email.setAddress(rec);
		email.setSubject("主题");
		email.setContent("<div style='color:red'>测试内容2</div>");

		EmailHost emailHost = new EmailHost();
		emailHost.setSmtpHost("smtp.126.com");
		emailHost.setFrom("changwei114@126.com");
		emailHost.setUser("changwei114@126.com");
		emailHost.setPwd("dongbi0314");
		emailHost.setReplyTo("changwei114@126.com");
		sendEmail(emailHost, email);
	}
}
