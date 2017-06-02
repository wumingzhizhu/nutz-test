package com.wumingzhizhu.nutz.module;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.mvc.adaptor.VoidAdaptor;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

@IocBean
public class LoginModule {
	
	@At("/login")
	@Ok("jsp:jsp.login")
	@AdaptBy(type=VoidAdaptor.class)
	public String login(HttpServletRequest request){
		return null;
	}
	
	@At("/checkLogin")
	@Ok("raw")
	@AdaptBy(type=VoidAdaptor.class)
	public String checkLogin(HttpServletRequest request,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		String username = request.getParameter( "username" );
		String pwd = request.getParameter( "pwd" );
		String captch = request.getParameter( "captch" );
		if(username.equals( "admin" ) && pwd.equals( "123456" )){
			String message = (String)session.getAttribute( "nutz_captcha" );
			if(captch.equals( message )){
				map.put( "result", "登录成功!" );
			}
			else{
				map.put( "result", "验证码错误!" );
			}
		}
		else{
			map.put( "result", "用户名或者密码错误" );
		}
		return Json.toJson( map );
	}

}
