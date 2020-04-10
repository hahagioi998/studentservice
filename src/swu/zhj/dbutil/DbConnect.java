package swu.zhj.dbutil;

import java.sql.*;

public class DbConnect {
   public static Connection getConnection(){
	   Connection conn= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url ="jdbc:mysql://localhost:3306/ourdb?user=root&password=123456&useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC";
			conn = DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 关闭数据库连接
	 * @param conn Connection对象
	 */
	public static void closeConnection(Connection conn){
		// 判断conn是否为空
		if(conn != null){
			try {
				conn.close();	// 关闭数据库连接
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

   }
}
