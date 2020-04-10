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
	 * �ر����ݿ�����
	 * @param conn Connection����
	 */
	public static void closeConnection(Connection conn){
		// �ж�conn�Ƿ�Ϊ��
		if(conn != null){
			try {
				conn.close();	// �ر����ݿ�����
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

   }
}
