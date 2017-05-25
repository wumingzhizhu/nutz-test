package com.wumingzhizhu.nutz;

import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

public class MainSetup implements Setup{
	

	@Override
	public void init( NutConfig nc ) {
		// TODO Auto-generated method stub
		System.out.println( "初始化" );
	}

	@Override
	public void destroy( NutConfig nc ) {
		// TODO Auto-generated method stub
		System.out.println( "结束" );
	}

}
