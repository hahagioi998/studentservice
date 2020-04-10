package swu.zhj.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import swu.zhj.dbutil.DbConnect;
import swu.zhj.model.Bumen_menber;
import swu.zhj.model.Jianzhis;
import swu.zhj.model.Yijian;
import swu.zhj.model.Studentusers;
import swu.zhj.model.Teacherusers;
import swu.zhj.model.Tongzhi;

public class TiebaService {
   
 //提取信息
   
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
				user.setXuehao(resultSet.getString("xuehao"));
				user.setName(resultSet.getString("name"));
				user.setPhone(resultSet.getString("phone"));
				user.setZhuanye(resultSet.getString("zhuanye"));
				user.setNianji(resultSet.getString("nianji"));
				user.setCla(resultSet.getString("cla"));
				user.setQinshi(resultSet.getString("qinshi"));
				user.setQq(resultSet.getString("qq"));
			
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
    public static Teacherusers chauserManagerById(int id){
    	Teacherusers chauser=new Teacherusers();
    	String sql="select * from admin where id=?";
    	Connection conn=null;
    	conn=DbConnect.getConnection();
    	try {
    		PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet resultSet=ps.executeQuery();
			while(resultSet.next()) {  
				Teacherusers user=new Teacherusers();
				user.setId(resultSet.getInt("id"));
				user.setImg(resultSet.getString("img"));
				user.setXuehao(resultSet.getString("xuehao"));
				user.setName(resultSet.getString("name"));
				user.setPhone(resultSet.getString("phone"));
				user.setQq(resultSet.getString("qq"));
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
  
    
    public static Teacherusers chauserManagerByName(String name){
    	Teacherusers chauser=new Teacherusers();
    	String sql="select * from manager_user where name=?";
    	Connection conn=null;
    	conn=DbConnect.getConnection();
    	try {
    		PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			/*chauser=UserService.findSimpleResult(sql,name);*/
			ResultSet resultSet=ps.executeQuery();
			while(resultSet.next()) {  
				Teacherusers user=new Teacherusers();
				user.setId(resultSet.getInt("id"));
				user.setImg(resultSet.getString("img"));
				user.setPhone(resultSet.getString("phone"));
				user.setQq(resultSet.getString("qq"));
				user.setName(resultSet.getString("name"));
				user.setHaoma(resultSet.getString("haoma"));
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
    public static boolean UpdatezanById(int zan,int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn=DbConnect.getConnection();
		boolean flag=false;
		String sql="update jianzhi set zan=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,zan);
			ps.setInt(2,id);
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
	public static Bumen_menber chausermenberById(int id) {
		// TODO Auto-generated method stub
		Bumen_menber chauser=new Bumen_menber();
    	String sql="select * from bumen_menber where student_id=?";
    	Connection conn=null;
    	conn=DbConnect.getConnection();
    	try {
    		PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet resultSet=ps.executeQuery();
			while(resultSet.next()) {  
				Bumen_menber user=new Bumen_menber();
				user.setId(resultSet.getInt("id"));
				user.setZhiwei(resultSet.getString("zhiwei"));
				user.setJoin_time(resultSet.getString("join_time"));
				user.setBumen_id(resultSet.getInt("bumen_id"));
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
	public static Teacherusers chauserbumenByBumen_id(int id) {
		// TODO Auto-generated method stub
		Teacherusers chauser=new Teacherusers();
    	String sql="select * from manager_user where id=?";
    	Connection conn=null;
    	conn=DbConnect.getConnection();
    	try {
    		PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet resultSet=ps.executeQuery();
			while(resultSet.next()) {  
				Teacherusers user=new Teacherusers();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setImg(resultSet.getString("img"));
				user.setQq(resultSet.getString("qq"));
				user.setPhone(resultSet.getString("phone"));
				user.setHaoma(resultSet.getString("haoma"));
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
	public static List<Tongzhi> getTongzhiById(int id) {
		// TODO Auto-generated method stub
		List<Tongzhi> chauser=new ArrayList<Tongzhi>();
    	String sql="select * from tongzhi where student_id=? order by id desc";
    	Connection conn=null;
    	conn=DbConnect.getConnection();
    	try {
    		PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet resultSet=ps.executeQuery();
			while(resultSet.next()) {  
				Tongzhi user=new Tongzhi();
				user.setId(resultSet.getInt("id"));
				user.setBumen_id(resultSet.getInt("bumen_id"));
				user.setStudent_id(resultSet.getInt("student_id"));
				user.setContent(resultSet.getString("content"));
				user.setTime(resultSet.getString("time"));
				chauser.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbConnect.closeConnection(conn);
		}
    	return chauser;
	}
	public static List<Jianzhis> getAllJianzhi(int start, int end) {
		// TODO Auto-generated method stub
		List<Jianzhis> list1=new ArrayList<Jianzhis>();
    	String sql="select * from jianzhi order by id desc limit ?,?";
    	Connection conn=null;
		conn=DbConnect.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Jianzhis huifu=new Jianzhis();
			   huifu.setId(rs.getInt("id"));
			   huifu.setTitle(rs.getString("title"));
			   huifu.setContent(rs.getString("content"));
			   huifu.setTime(rs.getString("time"));
			   huifu.setZan(rs.getInt("zan"));
			   huifu.setImg(rs.getString("img"));
			   huifu.setHref(rs.getString("href"));
			   list1.add(huifu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("bb");
		}finally {
			DbConnect.closeConnection(conn);
		}
    	return list1;
	}
	public static List<Jianzhis> getAllJianzhiByZan(int start, int end) {
		// TODO Auto-generated method stub
		List<Jianzhis> list1=new ArrayList<Jianzhis>();
    	String sql="select * from jianzhi order by zan desc limit ?,?";
    	Connection conn=null;
		conn=DbConnect.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Jianzhis huifu=new Jianzhis();
			   huifu.setId(rs.getInt("id"));
			   huifu.setTitle(rs.getString("title"));
			   huifu.setContent(rs.getString("content"));
			   huifu.setTime(rs.getString("time"));
			   huifu.setZan(rs.getInt("zan"));
			   huifu.setImg(rs.getString("img"));
			   huifu.setHref(rs.getString("href"));
			   list1.add(huifu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("bb");
		}finally {
			DbConnect.closeConnection(conn);
		}
    	return list1;
	}
	public static List<Jianzhis> getAllJianzhiBySearch(String search,int start, int end) {
		// TODO Auto-generated method stub
		List<Jianzhis> list1=new ArrayList<Jianzhis>();
    	String sql="select * from jianzhi where title like ? or content like ? or time like ? order by zan desc limit ?,?";
    	Connection conn=null;
		conn=DbConnect.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+search+"%");
			ps.setString(2, "%"+search+"%");
			ps.setString(3, "%"+search+"%");
			ps.setInt(4, start);
			ps.setInt(5, end);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Jianzhis huifu=new Jianzhis();
			   huifu.setId(rs.getInt("id"));
			   huifu.setTitle(rs.getString("title"));
			   huifu.setContent(rs.getString("content"));
			   huifu.setTime(rs.getString("time"));
			   huifu.setZan(rs.getInt("zan"));
			   huifu.setImg(rs.getString("img"));
			   huifu.setHref(rs.getString("href"));
			   list1.add(huifu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("bb");
		}finally {
			DbConnect.closeConnection(conn);
		}
    	return list1;
	}
	public static List<Jianzhis> getAllJianzhiByJing(int start, int end) {
		// TODO Auto-generated method stub
		List<Jianzhis> list1=new ArrayList<Jianzhis>();
    	String sql="select * from jianzhi where jing=1 order by id desc limit ?,?";
    	Connection conn=null;
		conn=DbConnect.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Jianzhis huifu=new Jianzhis();
			   huifu.setId(rs.getInt("id"));
			   huifu.setTitle(rs.getString("title"));
			   huifu.setContent(rs.getString("content"));
			   huifu.setTime(rs.getString("time"));
			   huifu.setZan(rs.getInt("zan"));
			   huifu.setImg(rs.getString("img"));
			   huifu.setHref(rs.getString("href"));
			   list1.add(huifu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("bb");
		}finally {
			DbConnect.closeConnection(conn);
		}
    	return list1;
	}
	public static List<Jianzhis> getAllJianzhi() {
		// TODO Auto-generated method stub
		List<Jianzhis> list1=new ArrayList<Jianzhis>();
    	String sql="select * from jianzhi order by id";
    	Connection conn=null;
		conn=DbConnect.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			Jianzhis huifu=new Jianzhis();
			   huifu.setId(rs.getInt("id"));
			   huifu.setTitle(rs.getString("title"));
			   huifu.setContent(rs.getString("content"));
			   huifu.setTime(rs.getString("time"));
			   huifu.setZan(rs.getInt("zan"));
			   huifu.setImg(rs.getString("img"));
			   huifu.setHref(rs.getString("href"));
			   list1.add(huifu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("bb");
		}finally {
			DbConnect.closeConnection(conn);
		}
    	return list1;
	}
	public static int[] getAllstudent_idBycla_id(int cla_id) {
		// TODO Auto-generated method stub
	//	int student_ids[] = null;
		ArrayList<Integer> list=new ArrayList<Integer>();
		String sql="select * from student_user where cla_id=?";
		Connection conn=null;
		conn=DbConnect.getConnection();
		 try {
		    PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, cla_id);
			ResultSet resultSet=ps.executeQuery();
			while(resultSet.next()) {
			    list.add(resultSet.getInt("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbConnect.closeConnection(conn);
		}
		int[] student_ids=new int[list.size()];
		for(int i=0;i<list.size();i++) {
			student_ids[i]=list.get(i);
			System.out.println(student_ids[i]);
		}
		return student_ids;
	}
	public static Teacherusers chauserTeacherById(int teacher_id) {
		// TODO Auto-generated method stub
		Teacherusers chauser=new Teacherusers();
    	String sql="select * from teacher where id=?";
    	Connection conn=null;
    	conn=DbConnect.getConnection();
    	try {
    		PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, teacher_id);
			ResultSet resultSet=ps.executeQuery();
			while(resultSet.next()) {  
				Teacherusers user=new Teacherusers();
				user.setId(resultSet.getInt("id"));
				user.setImg(resultSet.getString("img"));
				user.setXuehao(resultSet.getString("xuehao"));
				user.setName(resultSet.getString("name"));
				user.setPhone(resultSet.getString("phone"));
				user.setQq(resultSet.getString("qq"));
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
	public static boolean CheckzanBystudent_id(int id, int jianzhi_id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn=DbConnect.getConnection();
		boolean flag=false;
		String sql="select user_id,jianzhi_id from zan where user_id=? and jianzhi_id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.setInt(2, jianzhi_id);
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
	public static List<Yijian> getAllYijian() {
		// TODO Auto-generated method stub
		List<Yijian> list1=new ArrayList<Yijian>();
    	String sql="select * from yijian order by id";
    	Connection conn=null;
		conn=DbConnect.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Yijian huifu=new Yijian();
			   huifu.setId(rs.getInt("id"));
			   huifu.setName(rs.getString("name"));
			   huifu.setContent(rs.getString("content"));
			   huifu.setTime(rs.getString("time"));
			   huifu.setNianji(rs.getString("nianji"));
			   huifu.setQq(rs.getString("qq"));
			   list1.add(huifu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("bb");
		}finally {
			DbConnect.closeConnection(conn);
		}
    	return list1;
	}
}
