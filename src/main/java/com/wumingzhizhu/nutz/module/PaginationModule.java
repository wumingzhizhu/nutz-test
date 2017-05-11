package com.wumingzhizhu.nutz.module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.view.HttpServerResponse;

import com.wumingzhizhu.nutz.entity.Employee;

@IocBean  // 声明为Ioc容器中的一个Bean
@At( "/show" )  // 整个模块的路径前缀
@Ok( "raw" )
public class PaginationModule {
	
	@Inject("dao")
	private Dao dao;
	
	@POST
	@At("/pagination")
	public String paginationList(HttpServletRequest request,HttpServerResponse response){
		//页大小
		String pageSize = request.getParameter( "pageSize" );
		//页码
		String pageIndex = request.getParameter( "pageIndex" );
		Pager pager = new Pager();
		pager.setPageSize( Integer.parseInt( pageSize ));
		pager.setPageNumber( Integer.parseInt( pageIndex ) );
		//不分页查询总记录数
		List<Employee> allNum = dao.query( Employee.class, 
			Cnd.wrap( "" ), null );
		pager.setRecordCount( allNum.size() );
		//分页返回数据
		List<Employee> list = dao.query( Employee.class, 
			Cnd.wrap( "" ), pager );
		//构造json返回
		Map<String,Object> map = new HashMap<String, Object>();
		map.put( "list", list );
		map.put( "pageCount", pager.getPageCount() );
		String jsonStr = Json.toJson( map );
		return jsonStr;
	}

}
