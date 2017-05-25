package com.wumingzhizhu.nutz.demo;

import com.wumingzhizhu.nutz.entity.demo.User;

import java.util.List;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.adaptor.JsonAdaptor;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

@IocBean
@At("/demo")
public class UserForm {

	/**
	 * 入参是一个对象的情况
	 * @param user
	 * @return
	 */
	@At("/form")
	public String form(@Param("..")User user){
		System.out.println( user );
		return null;
	}
	
	//入参是个List
	@AdaptBy(type=JsonAdaptor.class)
	@At("/listForm")
	public String listForm(@Param("User")List<User> list){
		for(int i=0;i < list.size();i ++){
			System.out.println( list.get( i ) );
		}
		return null;
	}
	
}
