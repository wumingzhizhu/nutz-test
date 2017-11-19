<!DOCTYPE html>
<html>
<%@page import="com.alibaba.fastjson.JSONObject"%>
<%@page import="java.util.*"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.sql.*,java.io.*" %>
<%@ page import="javax.sql.DataSource" %>
<body>
<%!
public class HomeMessage {
    
    private String name;// 姓名
    private String email; //邮箱
    private String mobile;//手机号码
    private String home;
    
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getMobile() {
        return mobile;
    }
    public String getHome() {
        return home;
    }
    public void setName( String name ) {
        this.name = name;
    }
    public void setEmail( String email ) {
        this.email = email;
    }
    public void setMobile( String mobile ) {
        this.mobile = mobile;
    }
    public void setHome( String home ) {
        this.home = home;
    }
}
%>

    <%
        //注册SQL Server 2008驱动
        Class.forName("com.mysql.jdbc.Driver");
        //SQL Server 2008的URL
        String url="jdbc:mysql://localhost:3306/city";
        String user="root";
        String password="root";
        Connection conn = DriverManager.getConnection(url,user,password);
        Statement stmt = conn.createStatement();
        String pageSize = request.getParameter("pageSize");
        String pageIndex = request.getParameter("pageIndex");
        String sql = "SELECT * FROM home_message limit " + (Integer.parseInt( pageIndex ) - 1) * 3 + ",3";  
        String allNumSql = "SELECT count(*) FROM home_message";
        ResultSet rs = stmt.executeQuery(sql);
        //查询条数
        List<HomeMessage> list = new ArrayList<HomeMessage>();
        while(rs.next()){
        	HomeMessage change = new HomeMessage();
        	change.setName( rs.getString("name") );
        	change.setHome( rs.getString("home") );
        	change.setEmail( rs.getString("email") );
        	change.setMobile( rs.getString("mobile"));
        	list.add(change);
        }
        //总记录数
        Statement allNumStmt = conn.createStatement();
        ResultSet allNumSet = allNumStmt.executeQuery( allNumSql );
        int allNumCount = 0;
        while(allNumSet.next()){
        	allNumCount = allNumSet.getInt(1);
        }
        //构造json
        Map<String,Object> map = new HashMap<String, Object>();
        map.put( "list", list );
        map.put( "pageCount", allNumCount / Integer.parseInt( pageSize ) );
        String jsonStr = JSONObject.toJSONString( map );
        response.setContentType( "text/json" );
        PrintWriter writer = response.getWriter();
        writer.write( jsonStr );
        writer.flush();
        writer.close();
        //关闭
        conn.close();
        stmt.close();
        allNumStmt.close();
        rs.close();
        allNumSet.close();
    %>
</body>
</html>