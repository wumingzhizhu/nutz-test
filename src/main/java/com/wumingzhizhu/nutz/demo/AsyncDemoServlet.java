package com.wumingzhizhu.nutz.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 所有异步经过的servlet都要使用异步，这里因为结合了nutz，nutz默认的filter
 * 没有使用异步，所以会报错,所以要在web.xml把nutz的filer也配置好异步
 * @author wumingzhizhu
 *
 */
@WebServlet(urlPatterns = "/demo",asyncSupported = true)
public class AsyncDemoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException{
		resp.setContentType( "text/html;charset=UTF-8" );
		PrintWriter printWriter = resp.getWriter();
		printWriter.println( "进入servlet时间：" + new Date() );
		printWriter.flush();
		//在子线程处理耗时业务
		AsyncContext context = req.startAsync();
		new Thread( new Executor( context ) ).start();
		
		printWriter.write( "servlet结束时间：" + new Date() );
		printWriter.flush();
    }
}
