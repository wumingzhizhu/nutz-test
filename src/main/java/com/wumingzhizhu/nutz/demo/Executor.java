package com.wumingzhizhu.nutz.demo;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.AsyncContext;

public class Executor implements Runnable{
	private AsyncContext ctx = null;
	public Executor(AsyncContext ctx) {
		this.ctx = ctx;
	} 

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep( 10000 );
			PrintWriter out = ctx.getResponse().getWriter();
			out.println( "业务处理完毕：" + new Date() );
			out.flush();
			ctx.complete();
		}
		catch( Exception e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
