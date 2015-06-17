package com.lyt.webtemp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnUtil {


	//mysql数据信息
	
	//mac 电脑127.0.0.1不能改写成localhost
	 private static String url = "jdbc:mysql://127.0.0.1:3306/julyedu"; 
	 private static String username = "root";
	 private static String password = "123456";
	 private static Connection conn = null;
	 //静态块加载驱动（反射）
	 static{
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 
	 }
	 //连接数据库
	 public static Connection getConn(){
		 try {
			conn = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	 }
	 //关闭数据库
	 public static void closeConn(ResultSet rs,Statement stmt,PreparedStatement pstmt,Connection conn){
		 
		 try {
			 if(null != rs){
			 rs.close();
			 }
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
					try {
						if(null != stmt)
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}finally{
						try {
							if(null !=pstmt){
								pstmt.close();
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}finally{
								try {
									if(null != conn){
										conn.close();
										}
									} catch (SQLException e) {
										e.printStackTrace();
									}
							}
					}
			}
	 }
}
			
		 
	 
	

