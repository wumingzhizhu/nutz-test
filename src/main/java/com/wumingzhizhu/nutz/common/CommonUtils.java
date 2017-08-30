package com.wumingzhizhu.nutz.common;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 一些基本操作
 * @author 
 *
 */
public class CommonUtils {
	
	/**
     * 取指定month个月的最后一天,比如去前一个月的最后一天
     * @param month  -1:前一个月，1:后一个月
     * @param day
     * @return
     */
    public static Date getLastDateOfMonth(Date date,int month){
    	Calendar c = Calendar.getInstance();  
        c.setTime(date); 
        c.add( Calendar.MONTH, month );
        c.set( Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH) );
        return c.getTime();
    }
    
    /**
     * 取指定month个月的第一天,比如去前一个月的第一天
     * @param month  -1:前一个月，1:后一个月
     * @param day
     * @return
     */
    public static Date getFirstDateOfMonth(Date date,int month){
    	Calendar c = Calendar.getInstance();  
        c.setTime(date); 
        c.add( Calendar.MONTH, month );
        c.set( Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH) );
        return c.getTime();
    }
    
    /**
     * 格式化daouble,防止科学计数法的问题
     * @param d
     * @return
     */
    public static String formatDouble(double d){
    	DecimalFormat df=new DecimalFormat("#.00");
    	try {
	        if(d == 0){
	        	return "0";
	        }
	        else{
	        	return df.format( d );
	        }
        }
        catch( Exception e ) {
	       e.printStackTrace();
	       return "0";
        }
    }

}
