package com.wumingzhizhu.nutz.module;

import javax.servlet.http.HttpServletRequest;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.adaptor.VoidAdaptor;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

import com.wumingzhizhu.nutz.service.EmailService;

@IocBean
@At("/mail")
public class EmailModule {
	
	@Inject
	private EmailService emailService;
	
	@At("/mailPage")
	@Ok("jsp:jsp.email")
	public String mailPage(HttpServletRequest request){
		System.out.println( request.getContextPath() );
		return null;
	}
	
	@At("/send")
	@AdaptBy(type=VoidAdaptor.class)
	public void sendMail(HttpServletRequest request){
		String mail = request.getParameter( "mail" );
		String title = request.getParameter( "title" );
		String message = request.getParameter( "message" );
		emailService.send( mail, title, message );
	}
	
}
