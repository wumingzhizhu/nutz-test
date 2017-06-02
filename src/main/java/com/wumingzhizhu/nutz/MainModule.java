	package com.wumingzhizhu.nutz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.ChainBy;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.SetupBy;

@SetupBy(value=MainSetup.class)
@Modules(scanPackage = true)
@IocBy(args={"*js", "ioc/",
        "*anno", "com.wumingzhizhu.nutz",
        "*async",
        "*tx"
        })
@ChainBy(args="mvc/mvc-chain.js")
@Ok("json:full")
@Fail("jsp:jsp.500")
public class MainModule {
	private static final Logger Logger = LogManager.getLogger( MainModule.class );
	
	@At("/hello")
	@Ok("jsp:jsp.hello")
	public String demo(){
		Logger.info( "hello" );
		return "hello nutz";
	}

}
