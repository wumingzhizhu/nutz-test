package com.wumingzhizhu.nutz.module;

import java.awt.image.BufferedImage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.adaptor.VoidAdaptor;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;
import cn.apiclub.captcha.gimpy.FishEyeGimpyRenderer;

/**
 * 图片验证码
 * @author wumingzhihzu
 *
 */
@IocBean
@At("/captch")
public class CaptchaModule {
	
	@At("/getCaptch")
	@Ok("raw:png")
	@AdaptBy(type=VoidAdaptor.class)
	public BufferedImage getImage(HttpServletRequest request,HttpSession session){
		try {
			Captcha captcha =new Captcha.Builder( 200, 60 )
					.addText().addBackground(new GradiatedBackgroundProducer())
					.gimp(new FishEyeGimpyRenderer())
					.build();
			String text = captcha.getAnswer();
			session.setAttribute( "nutz_captcha", text );
			return captcha.getImage();
		}
		catch( Exception e ) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

}
