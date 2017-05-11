package com.wumingzhizhu.nutz.mvc;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nutz.lang.Stopwatch;
import org.nutz.mvc.ActionContext;
import org.nutz.mvc.impl.processor.AbstractProcessor;

public class LogTimeProcessor extends AbstractProcessor{
	
	private static final Logger log = LogManager.getLogger( LogTimeProcessor.class );
	
	@Override
	public void process( ActionContext ac ) throws Throwable {
		// TODO Auto-generated method stub
		Stopwatch sw = Stopwatch.begin();
		try {
			doNext( ac );
		}
		finally{
			sw.stop();
	        if (log.isDebugEnabled()) {
	            HttpServletRequest req = ac.getRequest();
	            log.debug(req.getMethod() + " " + req.getRequestURI() + " " + sw.getDuration() + "ms");
	        }
		}
	}

}
