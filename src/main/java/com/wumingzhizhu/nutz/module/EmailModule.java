package com.wumingzhizhu.nutz.module;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.mvc.adaptor.VoidAdaptor;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;

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
	@Ok("raw")
	public String sendMail(HttpServletRequest request){
		String mail = request.getParameter( "mail" );
		String title = request.getParameter( "title" );
		String message = request.getParameter( "message" );
		boolean flag = emailService.send( mail, title, message );
		if(flag == true){
			return "邮件发送成功";
		}
		else{
			return "邮件发送失败";
		}
	}
	
	@At("/upload")
    @AdaptBy(type = UploadAdaptor.class, args = { "ioc:myUpload" })
	@Ok("raw:json")
    public String upload(@Param("uploads")TempFile tf,@Param("answerId")String answerId){
    	Map<String, Object> map = new HashMap<>();
    	if(tf == null || "".equals( tf ) || answerId == null || "".equals( answerId )){
    		map.put( "result", "上传失败!" );
    		return Json.toJson( map );
    	}
    	try {
	        System.out.println(tf.getSubmittedFileName());
	        System.out.println(tf.getSize());
	        String[] postfix = tf.getSubmittedFileName().split("\\.");
	        String path = "D:\\data\\temp\\";
	        File temp = new File( path );
	        if(!temp.exists()){
	        	temp.mkdirs();
	        }
	        tf.write( temp.getPath() + "\\" + answerId + "." + postfix[postfix.length - 1] );
	        tf.delete();
	        map.put( "result", "上传成功!" );
        }
        catch( Exception e ) {
	        e.printStackTrace();
	        map.put( "result", "上传失败!" );
        }
    	return Json.toJson( map );
	}
}
