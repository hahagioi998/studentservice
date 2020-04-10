package swu.zhj.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import swu.zhj.dbutil.DbConnect;
import swu.zhj.model.*;


public class UserService {
     
	/*student*/
	public static boolean checkStudentUserExist(String xuehao, String password) {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn=DbConnect.getConnection();
		boolean flag=false;
		String sql="select xuehao,password from student where xuehao=? and password=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,xuehao);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				flag=true;
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return flag;
	}
	 public static Studentusers chauserStudent(String xuehao){
	    	Studentusers chauser=new Studentusers();
	    	String sql="select * from student where xuehao=?";
	    	Connection conn=null;
	    	conn=DbConnect.getConnection();
	    	try {
	    		PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, xuehao);
				/*chauser=UserService.findSimpleResult(sql,name);*/
				ResultSet resultSet=ps.executeQuery();
				while(resultSet.next()) {  
					Studentusers user=new Studentusers();
					user.setId(resultSet.getInt("id"));
					user.setImg(resultSet.getString("img"));
					user.setName(resultSet.getString("name"));
					user.setPhone(resultSet.getString("phone"));
					user.setZhuanye(resultSet.getString("zhuanye"));
					user.setNianji(resultSet.getString("nianji"));
					user.setCla(resultSet.getString("cla"));
					user.setQinshi(resultSet.getString("qinshi"));
					user.setQq(resultSet.getString("qq"));
					user.setXuehao(resultSet.getString("xuehao"));
					chauser=user;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DbConnect.closeConnection(conn);
			}
	    	return chauser;
	    }
	 public static Studentusers chauserStudentById(int id){
		 Studentusers chauser=new Studentusers();
	    	String sql="select * from student where id=?";
	    	Connection conn=null;
	    	conn=DbConnect.getConnection();
	    	try {
	    		PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, id);
				/*chauser=UserService.findSimpleResult(sql,name);*/
				ResultSet resultSet=ps.executeQuery();
				while(resultSet.next()) {  
					Studentusers user=new Studentusers();
					user.setId(resultSet.getInt("id"));
					user.setImg(resultSet.getString("img"));
					user.setName(resultSet.getString("name"));
					user.setPhone(resultSet.getString("phone"));
					user.setZhuanye(resultSet.getString("zhuanye"));
					user.setNianji(resultSet.getString("nianji"));
					user.setCla(resultSet.getString("cla"));
					user.setQinshi(resultSet.getString("qinshi"));
					user.setQq(resultSet.getString("qq"));
					user.setXuehao(resultSet.getString("xuehao"));
					chauser=user;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DbConnect.closeConnection(conn);
			}
	    	return chauser;
	    }
	  
	 /****manager*******/
	public static boolean checkManagerUserExist(String xuehao, String password) {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn=DbConnect.getConnection();
		boolean flag=false;
		String sql="select xuehao,password from admin where xuehao=? and password=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,xuehao);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				flag=true;
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return flag;
	}
	public static Admin chauserManager(String xuehao){
		Admin chauser=new Admin();
    	String sql="select * from admin where xuehao=?";
    	Connection conn=null;
    	conn=DbConnect.getConnection();
    	try {
    		PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, xuehao);
			/*chauser=UserService.findSimpleResult(sql,name);*/
			ResultSet resultSet=ps.executeQuery();
			while(resultSet.next()) {  
				Admin user=new Admin();
				user.setId(resultSet.getInt("id"));
				user.setImg(resultSet.getString("img"));
				user.setPhone(resultSet.getString("phone"));
				user.setQq(resultSet.getString("qq"));
				user.setName(resultSet.getString("name"));
				user.setXuehao(resultSet.getString("xuehao"));
				chauser=user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbConnect.closeConnection(conn);
		}
    	return chauser;
    }
	/******teacher******/
	  public static Teacherusers chauserTeacher(String xuehao){
	    	Teacherusers chauser=new Teacherusers();
	    	String sql="select * from teacher where xuehao=?";
	    	Connection conn=null;
	    	conn=DbConnect.getConnection();
	    	try {
	    		PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, xuehao);
				/*chauser=UserService.findSimpleResult(sql,name);*/
				ResultSet resultSet=ps.executeQuery();
				while(resultSet.next()) {  
					Teacherusers user=new Teacherusers();
					user.setId(resultSet.getInt("id"));
					user.setImg(resultSet.getString("img"));
					user.setPhone(resultSet.getString("phone"));
					user.setQq(resultSet.getString("qq"));
					user.setName(resultSet.getString("name"));
					user.setXuehao(resultSet.getString("xuehao"));
					chauser=user;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DbConnect.closeConnection(conn);
			}
	    	return chauser;
	    }
	  public static Teacherusers chauserTeacherById(int id){
	    	Teacherusers chauser=new Teacherusers();
	    	String sql="select * from teacher where id=?";
	    	Connection conn=null;
	    	conn=DbConnect.getConnection();
	    	try {
	    		PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, id);
				/*chauser=UserService.findSimpleResult(sql,name);*/
				ResultSet resultSet=ps.executeQuery();
				while(resultSet.next()) {  
					Teacherusers user=new Teacherusers();
					user.setXuehao(resultSet.getString("xuehao"));
					user.setImg(resultSet.getString("img"));
					user.setPhone(resultSet.getString("phone"));
					user.setQq(resultSet.getString("qq"));
					user.setName(resultSet.getString("name"));
					chauser=user;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DbConnect.closeConnection(conn);
			}
	    	return chauser;
	    }
	  
	public static boolean checkTeacherUserExist(String xuehao, String password) {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn=DbConnect.getConnection();
		boolean flag=false;
		String sql="select xuehao,password from teacher where xuehao=? and password=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,xuehao);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				flag=true;
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return flag;
	}
	//用户名电话查询数据库里是否存在
	public static boolean find(String name, String phone) {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn=DbConnect.getConnection();
		boolean flag=false;
		String sql="select name,phone from student_user where name=? and phone=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2, phone);
			ResultSet rs=ps.executeQuery();
			//System.out.println(rs);
			
			if(rs.next()){
				flag=true;
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("3");
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return flag;
	}
	public static boolean updateUser(String password,String name){
		Connection conn=null;
		conn=DbConnect.getConnection();
		boolean flag=false;
		String sql="update student_user set password=? where name=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,password);
			ps.setString(2, name);
			int n=ps.executeUpdate();
			if(n>0){
				flag=true;
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return flag;
	}
	//注册，添加信息
	public static boolean addUser(String name,String password,String xuehao,String zhuanye, String cla,String qinshi, String qq,String phone,String nianji,String img){
		Connection conn=null;
		conn=DbConnect.getConnection();
		boolean flag=false;
		String sql="insert into student(name,password,xuehao,zhuanye,cla,qinshi,qq,phone,nianji,cla_id) values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,password);
			ps.setString(3,xuehao);
			ps.setString(4,zhuanye);
			ps.setString(5,cla);
			ps.setString(6,qinshi);
			ps.setString(7,qq);
			ps.setString(8,phone);
			ps.setString(9,nianji);
			int n=ps.executeUpdate();
			if(n>0){
				flag=true;
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return flag;
	}
	public static boolean addTree(String kind,String day,String user){
		Connection conn=null;
		conn=DbConnect.getConnection();
		boolean flag=false;
		String sql="insert into tree(kind,day,user) values(?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,kind);
			ps.setString(2,day);
			ps.setString(3, user);
			//ps.setString(4, img);
			int n=ps.executeUpdate();
			if(n>0){
				flag=true;
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return flag;
	}
	public static boolean addTouo2(String people,String peopled,int number,String date,String people_img){
		Connection conn=null;
		conn=DbConnect.getConnection();
		boolean flag=false;
		String sql="insert into tou(people,peopled,number,date,people_img) values(?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,people);
			ps.setString(2, peopled);
			ps.setInt(3, number);
			ps.setString(4, date);
			ps.setString(5, people_img);
			int n=ps.executeUpdate();
			if(n>0){
				flag=true;
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return flag;
	}
	//根据name查询数据
		public static boolean check(String name) {
			Connection conn=DbConnect.getConnection();
			String sql="select * from student_user where name=?";
			boolean flag=false;
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, name);
				ResultSet n=ps.executeQuery();
				if(n.next()) {
					flag=true;
				}
				n.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("11");
			}
			return flag;
		}
	//根据name删除数据,最好是根据id删除数据
	public static boolean deleteByName(String name) {
		Connection conn=DbConnect.getConnection();
		String sql="delete from student_user where name=?";
		boolean flag=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			int n=ps.executeUpdate();
			if(n>0) {
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
    //查询返回单条记录
	public static Map<String,Object>findSimpleResult(String sql,List<Object> params) throws SQLException{
		Connection conn=null;
		conn=DbConnect.getConnection();
		Map<String,Object> map=new HashMap<String,Object>();
		int index=1;
		PreparedStatement pstmt=conn.prepareStatement(sql);
		if(params!=null&&!params.isEmpty()) {
			for(int i=1;i<params.size();i++) {
				pstmt.setObject(index++, params.get(i));
			}
		}
		ResultSet resultSet=pstmt.executeQuery();   //返回查询结果
		ResultSetMetaData metaData=resultSet.getMetaData();  //获取对象结果集的列的属性和列的名称
		int col_len=metaData.getColumnCount();   //列长
		while(resultSet.next()) {   //两重循环
			for(int i=0;i<col_len;i++) {
				String cols_name=metaData.getColumnName(i+1);  //第一列开始，列名
				Object cols_value=resultSet.getObject(cols_name);   //通过列名，获得结果
				if(cols_value==null) {   //有些值为空
					cols_value="";
				}
				map.put(cols_name, cols_value);
			}
		}
		return map;
	}
		public static boolean updateByPreparedStatement(String sql, List<Object> params) throws SQLException {
			Connection conn=null;
			conn=DbConnect.getConnection();
			boolean flag=false;
			int result=-1;
			PreparedStatement pstmt=conn.prepareStatement(sql);
			int index=1;  //占位符的第一个位置
			if(params!=null&&!params.isEmpty()){
				for(int i=0;i<params.size();i++) {
					pstmt.setObject(index++,params.get(i));
				}
			}
			result=pstmt.executeUpdate();
			flag=result>0?true:false;
			return flag;
		}
		
		public static List<Tongzhi> ByPeoplegetAllTongzhi(String name) {
			// TODO Auto-generated method stub
			Connection conn=null;
			List<Tongzhi> all_tongzhi=new ArrayList<Tongzhi>();
			conn=DbConnect.getConnection();
			String sql="select * from tongzhi where user=?";
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, name);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Tongzhi tongzhi=new Tongzhi();
					tongzhi.setId(rs.getInt("id"));
					tongzhi.setTime(rs.getString("time"));
					tongzhi.setContent(rs.getString("content"));
				
					all_tongzhi.add(tongzhi);
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DbConnect.closeConnection(conn);
			}
			return all_tongzhi;
		}
		public static boolean AdduserimgByName(int id, String img) {
			// TODO Auto-generated method stub
			Connection conn=null;
			conn=DbConnect.getConnection();
			boolean flag=false;
			String sql="update student_user set img=? where id=?";
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1,img);
				ps.setInt(2, id);
				int n=ps.executeUpdate();
				if(n>0){
					flag=true;
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DbConnect.closeConnection(conn);
			}
			return flag;
		}
		public static boolean UpdateuserByName(String phone,String name) {
			// TODO Auto-generated method stub
			Connection conn=null;
			conn=DbConnect.getConnection();
			boolean flag=false;
			String sql="update student_user set phone=? where name=?";
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1,phone);
				
				ps.setString(2,name);
				int n=ps.executeUpdate();
				if(n>0){
					flag=true;
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DbConnect.closeConnection(conn);
			}
			return flag;
		}
		public static List<Studentusers> getAllUsers(){
			Connection conn=null;
			List<Studentusers> all_users=new ArrayList<Studentusers>();
			conn=DbConnect.getConnection();
			String sql="select * from student";
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Studentusers users=new Studentusers();
					users.setId(rs.getInt("id"));
					users.setName(rs.getString("name"));
					users.setPassword(rs.getString("password"));
					users.setPhone(rs.getString("phone"));
					users.setXuehao(rs.getString("xuehao"));
					users.setZhuanye(rs.getString("zhuanye"));
					users.setImg(rs.getString("img"));
					users.setCla(rs.getString("cla"));
					users.setQinshi(rs.getString("qinshi"));
					users.setQq(rs.getString("qq"));
					users.setNianji(rs.getString("nianji"));
					all_users.add(users);
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DbConnect.closeConnection(conn);
			}
			return all_users;
		}
		public static List<Teacherusers> getAllManagerUsers(){
			Connection conn=null;
			List<Teacherusers> all_users=new ArrayList<Teacherusers>();
			conn=DbConnect.getConnection();
			String sql="select * from manager_user";
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Teacherusers users=new Teacherusers();
					users.setId(rs.getInt("id"));
					users.setName(rs.getString("name"));
					users.setPassword(rs.getString("password"));
					users.setPhone(rs.getString("phone"));
					users.setImg(rs.getString("img"));
					users.setQq(rs.getString("qq"));
					users.setHaoma(rs.getString("haoma"));
					all_users.add(users);
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DbConnect.closeConnection(conn);
			}
			return all_users;
		}
		public static List<Teacherusers> getAllTeacherUsers(){
			Connection conn=null;
			List<Teacherusers> all_users=new ArrayList<Teacherusers>();
			conn=DbConnect.getConnection();
			String sql="select * from teacher";
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Teacherusers users=new Teacherusers();
					users.setId(rs.getInt("id"));
					users.setName(rs.getString("name"));
					users.setPassword(rs.getString("password"));
					users.setPhone(rs.getString("phone"));
					users.setImg(rs.getString("img"));
					users.setQq(rs.getString("qq"));
					users.setXuehao(rs.getString("xuehao"));
					all_users.add(users);
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DbConnect.closeConnection(conn);
			}
			return all_users;
		}
		public static boolean deleteUserById(int id){
			boolean flag=false;
			Connection conn=null;
			conn=DbConnect.getConnection();
			String sql="delete from student_user where id=?";
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, id);
				int n=ps.executeUpdate();
				if(n>0){
					flag=true;
				}
		
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DbConnect.closeConnection(conn);
			}
			return flag;
		}
		public static boolean addBumen_baoming(int id, String first, String two, String tiao) {
			// TODO Auto-generated method stub
			Connection conn=null;
			conn=DbConnect.getConnection();
			boolean flag=false;
			String sql="insert into bumen_baoming(student_id,first,two,tiao) values(?,?,?,?)";
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1,id);
				ps.setString(2,first);
				ps.setString(3,two);
				ps.setString(4,tiao);
				int n=ps.executeUpdate();
				if(n>0){
					flag=true;
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DbConnect.closeConnection(conn);
			}
			return flag;
		}
		public static List<Bumen_baoming> getBumen_baomingBystudent_id(int student_id) {
			// TODO Auto-generated method stub
			Connection conn=null;
			List<Bumen_baoming> all_bumen_baoming=new ArrayList<Bumen_baoming>();
			conn=DbConnect.getConnection();
			String sql="select * from bumen_baoming where student_id=?";
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, student_id);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Bumen_baoming bumen_baoming=new Bumen_baoming();
					bumen_baoming.setId(rs.getInt("id"));
					bumen_baoming.setFirst(rs.getString("first"));
					bumen_baoming.setTwo(rs.getString("two"));
					bumen_baoming.setTiao(rs.getString("tiao"));
					all_bumen_baoming.add(bumen_baoming);
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DbConnect.closeConnection(conn);
			}
			return all_bumen_baoming;
		}
		public static List<Shetuan_baoming> getShetuan_baomingBystudent_id(int student_id) {
			// TODO Auto-generated method stub
			Connection conn=null;
			List<Shetuan_baoming> all_shetuan_baoming=new ArrayList<Shetuan_baoming>();
			conn=DbConnect.getConnection();
			String sql="select * from shetuan_baoming where student_id=?";
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, student_id);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Shetuan_baoming shetuan_baoming=new Shetuan_baoming();
					shetuan_baoming.setId(rs.getInt("id"));
					shetuan_baoming.setStudent_id(rs.getInt("student_id"));
					shetuan_baoming.setShetuan_id(rs.getInt("shetuan_id"));
					all_shetuan_baoming.add(shetuan_baoming);
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DbConnect.closeConnection(conn);
			}
			return all_shetuan_baoming;
		}
		public static boolean addShetuan_baoming(int id, int shetuan_id) {
			// TODO Auto-generated method stub
			Connection conn=null;
			conn=DbConnect.getConnection();
			boolean flag=false;
			String sql="insert into shetuan_baoming(student_id,shetuan_id) values(?,?)";
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1,id);
				ps.setInt(2,shetuan_id);
				int n=ps.executeUpdate();
				if(n>0){
					flag=true;
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DbConnect.closeConnection(conn);
			}
			return flag;
		}
		public static boolean UpdateStudentUserPassword(int id, String password) {
			// TODO Auto-generated method stub
			Connection conn=null;
			conn=DbConnect.getConnection();
			boolean flag=false;
			String sql="update student_user set password=? where id=?";
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1,password);
				ps.setInt(2, id);
				int n=ps.executeUpdate();
				if(n>0){
					flag=true;
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DbConnect.closeConnection(conn);
			}
			return flag;
		}
	
		public static boolean UpdateUserById(int id, String name, String xuehao, String zhuanye, String cla,
				String qinshi, String qq, String phone) {
			// TODO Auto-generated method stub
			Connection conn=null;
			conn=DbConnect.getConnection();
			boolean flag=false;
			String sql="update student_user set name=? and xuehao=? and zhuanye=? and cla=? and qinshi=? and qq=? and phone=? where id=?";
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1,name);
				ps.setString(2, xuehao);
				ps.setString(3,zhuanye);
				ps.setString(4,cla);
				ps.setString(5,qinshi);
				ps.setString(6, qq);
				ps.setString(7,phone);
				ps.setInt(8, id);
				int n=ps.executeUpdate();
				if(n>0){
					flag=true;
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DbConnect.closeConnection(conn);
			}
			return flag;
		}
		public static boolean UpdatebumenmenberById(int ids, String zhiwei) {
			// TODO Auto-generated method stub
						Connection conn=null;
						conn=DbConnect.getConnection();
						boolean flag=false;
						String sql="update bumen_menber set zhiwei=? where id=?";
						try {
							PreparedStatement ps=conn.prepareStatement(sql);
							ps.setString(1, zhiwei);
							ps.setInt(2, ids);
							int n=ps.executeUpdate();
							if(n>0){
								flag=true;
							}
							ps.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						finally{
							DbConnect.closeConnection(conn);
						}
						return flag;
		}
		public static boolean deleteJianzhiById(int id) {
			// TODO Auto-generated method stub
			boolean flag=false;
			Connection conn=null;
			conn=DbConnect.getConnection();
			String sql="delete from jianzhi where id=?";
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, id);
				int n=ps.executeUpdate();
				if(n>0){
					flag=true;
				}
		
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DbConnect.closeConnection(conn);
			}
			return flag;
		}
		public static List<Studentusers> getUsersByCla_id(int cla_id) {
			// TODO Auto-generated method stub
			Connection conn=null;
			List<Studentusers> all_users=new ArrayList<Studentusers>();
			conn=DbConnect.getConnection();
			String sql="select * from student_user where cla_id=?";
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1,cla_id);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Studentusers users=new Studentusers();
					users.setId(rs.getInt("id"));
					users.setName(rs.getString("name"));
					users.setPassword(rs.getString("password"));
					users.setPhone(rs.getString("phone"));
					users.setXuehao(rs.getString("xuehao"));
					users.setZhuanye(rs.getString("zhuanye"));
					users.setImg(rs.getString("img"));
					users.setCla(rs.getString("cla"));
					users.setQinshi(rs.getString("qinshi"));
					users.setQq(rs.getString("qq"));
				
					all_users.add(users);
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DbConnect.closeConnection(conn);
			}
			return all_users;
		}
		public static int GetCla_id(String zhuanye, String cla, String nianji) {
			// TODO Auto-generated method stub
			Connection conn=null;
			int cla_id = 0;
			conn=DbConnect.getConnection();
			String sql="select * from classes where zhuanye=? and nianji=?";
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1,zhuanye);
				ps.setString(2,nianji);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					cla_id=rs.getInt("id");
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DbConnect.closeConnection(conn);
			}
			return cla_id;
		}
		public static List<Kecheng_renwu> getKecheng_renwuBykecheng_id(int kecheng_id) {
			// TODO Auto-generated method stub
			Connection conn=null;
			List<Kecheng_renwu> kecheng_renwu_list=new ArrayList<Kecheng_renwu>();
			conn=DbConnect.getConnection();
			String sql="select * from kecheng_renwu where kecheng_id=?";
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, kecheng_id);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Kecheng_renwu kecheng_renwu=new Kecheng_renwu();
					kecheng_renwu.setId(rs.getInt("id"));
					kecheng_renwu.setKecheng_id(rs.getInt("kecheng_id"));
					kecheng_renwu.setTeacher_id(rs.getInt("teacher_id"));
					kecheng_renwu.setTime(rs.getString("time"));
					kecheng_renwu.setName(rs.getString("name"));
					kecheng_renwu.setDu(rs.getInt("du"));
					kecheng_renwu.setContent(rs.getString("content"));
					
					kecheng_renwu_list.add(kecheng_renwu);
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DbConnect.closeConnection(conn);
			}
			return kecheng_renwu_list;
		}
		public static List<Student_kecheng> getStudent_kechengBykecheng_id(int kecheng_id) {
			Connection conn=null;
			List<Student_kecheng> student_kecheng_list=new ArrayList<Student_kecheng>();
			conn=DbConnect.getConnection();
			String sql="select * from student_kecheng where kecheng_id=?";
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, kecheng_id);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Student_kecheng kecheng_renwu=new Student_kecheng();
					kecheng_renwu.setId(rs.getInt("id"));
					kecheng_renwu.setStudent_xuehao(rs.getString("student_xuehao"));
					kecheng_renwu.setKecheng_id(rs.getInt("kecheng_id"));
					student_kecheng_list.add(kecheng_renwu);
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DbConnect.closeConnection(conn);
			}
			return student_kecheng_list;
		}
}
