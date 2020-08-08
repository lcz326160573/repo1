package com.itheima;



import java.sql.*;

public class JdbcDemo01 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy01","root","root");
        //3.获取操作数据库的预处理对象
        PreparedStatement ps=conn.prepareStatement("select *from account");
        //4.执行SQL，得到结果
        ResultSet rs=ps.executeQuery();
        //5.遍历结果集
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        ps.close();
        conn.close();
    }
}
