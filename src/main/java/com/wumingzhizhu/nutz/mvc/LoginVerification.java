package com.wumingzhizhu.nutz.mvc;

import org.nutz.mvc.ActionContext;
import org.nutz.mvc.impl.processor.AbstractProcessor;

public class LoginVerification extends AbstractProcessor{

	@Override
	public void process( ActionContext ac ) throws Throwable {
		// TODO Auto-generated method stub
		try{
			System.out.println( "这是登录" );
			doNext( ac );
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
