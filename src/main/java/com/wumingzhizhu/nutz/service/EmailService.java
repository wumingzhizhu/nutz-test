package com.wumingzhizhu.nutz.service;

public interface EmailService {

	/**
	 * 发送邮件
	 * @param to  收件人
	 * @param subject  主题
	 * @param html   内容
	 * @return
	 */
	boolean send(String to,String subject,String html);
	
}
