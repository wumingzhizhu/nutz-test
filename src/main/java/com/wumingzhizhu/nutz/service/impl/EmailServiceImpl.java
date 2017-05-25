package com.wumingzhizhu.nutz.service.impl;

import org.apache.commons.mail.HtmlEmail;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.wumingzhizhu.nutz.service.EmailService;

@IocBean
public class EmailServiceImpl implements EmailService{
	
	@Inject("refer:$ioc")
	private Ioc ioc;

	@Override
	public boolean send( String to, String subject, String html ) {
		// TODO Auto-generated method stub
		try{
			HtmlEmail email = ioc.get( HtmlEmail.class );
			email.setSubject( subject );
			email.setHtmlMsg( html );
			email.addTo( to );
			email.buildMimeMessage();
			email.sendMimeMessage();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

}
