package swu.zhj.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mysql.cj.jdbc.JdbcConnection;

import swu.zhj.dbutil.DbConnect;
import swu.zhj.model.Bumen_baoming;
import swu.zhj.model.Bumen_menber;
import swu.zhj.model.Classes;
import swu.zhj.model.Home_data;
import swu.zhj.model.Home_nongchang;
import swu.zhj.model.Home_yin;
import swu.zhj.model.Jianzhis;
import swu.zhj.model.Kecheng;
import swu.zhj.model.Kecheng_chengji;
import swu.zhj.model.Kecheng_renwu;
import swu.zhj.model.Lunbo;
import swu.zhj.model.News;
import swu.zhj.model.Newstudent_jiben;
import swu.zhj.model.Renwu_anser;
import swu.zhj.model.Student_kecheng;
import swu.zhj.model.Studentusers;
import swu.zhj.model.Teacher_kecheng;
import swu.zhj.model.Tongzhi;

public class NewsService {
	public static boolean deleteBumenmenberById(int id){
		boolean flag=false;
		Connection conn=null;
		conn=DbConnect.getConnection();
		String sql="delete from bumen_menber where id=?";
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
	public static boolean deleteLunboById(int id){
		boolean flag=false;
		Connection conn=null;
		conn=DbConnect.getConnection();
		String sql="delete from lunbo where id=?";
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
	public static List<News> getAllNews(){
		Connection conn=null;
		List<News> all_news=new ArrayList<News>();
		conn=DbConnect.getConnection();
		String sql="select * from tb_news";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				News news=new News();
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setCategory(rs.getString("category"));
				news.setContent(rs.getString("content"));
				news.setFb_time(rs.getString("fb_time"));
				news.setAuthor(rs.getString("author"));
				news.setHot(rs.getInt("hot"));
				all_news.add(news);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return all_news;
	}
	public static List<Lunbo> getAllLunbo(){
		Connection conn=null;
		List<Lunbo> all_lunbo=new ArrayList<Lunbo>();
		conn=DbConnect.getConnection();
		String sql="select * from lunbo";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Lunbo lunbo=new Lunbo();
				lunbo.setId(rs.getInt("id"));
				lunbo.setTitle(rs.getString("title"));
				lunbo.setContent(rs.getString("content"));
				//Lunbo.setContent(rs.getString("content"));
				lunbo.setFb_time(rs.getString("fb_time"));
				lunbo.setAuthor(rs.getString("author"));
				lunbo.setHot(rs.getInt("hot"));
				lunbo.setImage(rs.getString("image"));
				all_lunbo.add(lunbo);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("dd");
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return all_lunbo;
	}
	public static List<Home_nongchang> getAllHome_nongchang(){
		Connection conn=null;
		List<Home_nongchang> allhome_nongchang=new ArrayList<Home_nongchang>();
		conn=DbConnect.getConnection();
		String sql="select * from home_nongchang";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Home_nongchang home_nongchang=new Home_nongchang();
				home_nongchang.setId(rs.getInt("id"));
				home_nongchang.setImage(rs.getString("image"));
				home_nongchang.setTitle(rs.getString("title"));
				//Lunbo.setContent(rs.getString("content"));
				home_nongchang.setContent(rs.getString("content"));
				home_nongchang.setCla(rs.getString("cla"));
				allhome_nongchang.add(home_nongchang);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ff");
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return allhome_nongchang;
	}
	public static List<Home_data> getAllHome_data(){
		Connection conn=null;
		List<Home_data> allhome_data=new ArrayList<Home_data>();
		conn=DbConnect.getConnection();
		String sql="select * from home_data";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Home_data home_data=new Home_data();
				home_data.setId(rs.getInt("id"));
				home_data.setMax_data(rs.getInt("max_data"));
				home_data.setH5(rs.getString("h5"));
				//Lunbo.setContent(rs.getString("content"));
				allhome_data.add(home_data);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ff");
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return allhome_data;
	}
	public static List<Home_yin> getAllHome_yin(){
		Connection conn=null;
		List<Home_yin> allhome_yin=new ArrayList<Home_yin>();
		conn=DbConnect.getConnection();
		String sql="select * from home_yin";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Home_yin home_yin=new Home_yin();
				home_yin.setId(rs.getInt("id"));
				home_yin.setTitle(rs.getString("title"));
				home_yin.setJian(rs.getString("jian"));
				home_yin.setImage(rs.getString("image"));
				home_yin.setAdr(rs.getString("adr"));
				home_yin.setPhone(rs.getString("phone"));
				//Lunbo.setContent(rs.getString("content"));
				allhome_yin.add(home_yin);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ff");
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return allhome_yin;
	}
	public static boolean addNews(String title,String category,String content,String fb_time,String author){
		boolean flag=false;
		Connection conn=null;
		conn=DbConnect.getConnection();
		String sql="insert into tb_news(title,category,content,fb_time,author) values(?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, category);
			ps.setString(3, content);
			ps.setString(4, fb_time);
			ps.setString(5, author);
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
	public static boolean deleteHome_yinById(int id) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Connection conn=null;
		conn=DbConnect.getConnection();
		String sql="delete from home_yin where id=?";
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
	public static boolean deleteHome_dataById(int id) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Connection conn=null;
		conn=DbConnect.getConnection();
		String sql="delete from home_data where id=?";
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
	public static boolean deleteHome_nongchangById(int id) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Connection conn=null;
		conn=DbConnect.getConnection();
		String sql="delete from home_nongchang where id=?";
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
	public static boolean deleteGameleiById(int id) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Connection conn=null;
		conn=DbConnect.getConnection();
		String sql="delete from home_game where id=?";
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
	public static List<News> getNewsById(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<News> mynews=new ArrayList<News>();
		conn=DbConnect.getConnection();
		String sql="select * from tb_news where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				News news=new News();
			news.setId(rs.getInt("id"));
			news.setTitle(rs.getString("title"));
			news.setCategory(rs.getString("category"));
			news.setContent(rs.getString("content"));
			news.setFb_time(rs.getString("fb_time"));
			news.setAuthor(rs.getString("author"));
			news.setHot(rs.getInt("hot"));
			mynews.add(news);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnect.closeConnection(conn);
		}
		return mynews;
	}
	public static List<Lunbo> getLunboById(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Lunbo> mylunbo=new ArrayList<Lunbo>();
		conn=DbConnect.getConnection();
		String sql="select * from lunbo where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Lunbo lunbo=new Lunbo();
				lunbo.setId(rs.getInt("id"));
				lunbo.setTitle(rs.getString("title"));
				lunbo.setImage(rs.getString("image"));
				lunbo.setContent(rs.getString("content"));
				lunbo.setFb_time(rs.getString("fb_time"));
				lunbo.setAuthor(rs.getString("author"));
				lunbo.setHot(rs.getInt("hot"));
			    mylunbo.add(lunbo);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnect.closeConnection(conn);
		}
		return mylunbo;
	}
	public static List<Home_yin> getHome_yinById(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Home_yin> myhome_yin=new ArrayList<Home_yin>();
		conn=DbConnect.getConnection();
		String sql="select * from home_yin where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Home_yin home_yin=new Home_yin();
				home_yin.setId(rs.getInt("id"));
				home_yin.setTitle(rs.getString("title"));
				home_yin.setJian(rs.getString("jian"));
				home_yin.setImage(rs.getString("image"));
				home_yin.setAdr(rs.getString("adr"));
				home_yin.setPhone(rs.getString("phone"));
				
			myhome_yin.add(home_yin);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnect.closeConnection(conn);
		}
		return myhome_yin;
	}
	public static List<Home_data> getHome_dataById(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Home_data> myhome_data=new ArrayList<Home_data>();
		conn=DbConnect.getConnection();
		String sql="select * from home_data where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Home_data home_data=new Home_data();
				home_data.setId(rs.getInt("id"));
				home_data.setMax_data(rs.getInt("max_data"));
				home_data.setH5(rs.getString("h5"));
			myhome_data.add(home_data);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnect.closeConnection(conn);
		}
		return myhome_data;
	}
	public static List<Home_nongchang> getHome_nongchangById(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Home_nongchang> myhome_nongchang=new ArrayList<Home_nongchang>();
		conn=DbConnect.getConnection();
		String sql="select * from home_nongchang where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Home_nongchang home_nongchang=new Home_nongchang();
				home_nongchang.setId(rs.getInt("id"));
				home_nongchang.setImage(rs.getString("image"));
				home_nongchang.setTitle(rs.getString("title"));
				home_nongchang.setContent(rs.getString("content"));
				home_nongchang.setCla(rs.getString("cla"));
			myhome_nongchang.add(home_nongchang);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnect.closeConnection(conn);
		}
		return myhome_nongchang;
	}
	public static boolean updateNews(int id, String title, String category, String content) {
		// TODO Auto-generated method stub
		Connection conn=null;
		boolean flag=false;
		conn=DbConnect.getConnection();
		String sql="update tb_news set title=?,category=?,content=? where id=?";
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, category);
			ps.setString(3, content);
			ps.setInt(4,id);
			int n=ps.executeUpdate();
			if(n>0){
				flag=true;
			}
			ps.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbConnect.closeConnection(conn);
		}
		return flag;
	}
	public static boolean updateHome_data(int id, int max_data, String content) {
		// TODO Auto-generated method stub
		Connection conn=null;
		boolean flag=false;
		conn=DbConnect.getConnection();
		String sql="update home_data set max_data=?,content=? where id=?";
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, max_data);
			ps.setString(2, content);
			ps.setInt(3,id);
			int n=ps.executeUpdate();
			if(n>0){
				flag=true;
			}
			ps.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbConnect.closeConnection(conn);
		}
		return flag;
	}
	public static boolean updateHome_yin(int id, String title, String jian, String image, String adr, String phone) {
		// TODO Auto-generated method stub
		Connection conn=null;
		boolean flag=false;
		conn=DbConnect.getConnection();
		String sql="update home_yin set title=?,jian=?,image=?,adr=?,phone=? where id=?";
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, jian);
			ps.setString(3, image);
			ps.setString(4,adr);
			ps.setString(5,phone);
			ps.setInt(6,id);
			int n=ps.executeUpdate();
			if(n>0){
				flag=true;
			}
			ps.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbConnect.closeConnection(conn);
		}
		return flag;
	}
	public static boolean updateGamelei(int id,String lei, String name1, String name2, String name3, String name4) {
		// TODO Auto-generated method stub
		Connection conn=null;
		boolean flag=false;
		conn=DbConnect.getConnection();
		String sql="update home_game set lei=?,name1=?,name2=?,name3=?,name4=? where id=?";
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, lei);
			ps.setString(2, name1);
			ps.setString(3, name2);
			ps.setString(4,name3);
			ps.setString(5,name4);
			ps.setInt(6,id);
			int n=ps.executeUpdate();
			if(n>0){
				flag=true;
			}
			ps.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbConnect.closeConnection(conn);
		}
		return flag;
	}
	public static boolean updateHome_nongchang(int id, String title, String image, String content) {
		// TODO Auto-generated method stub
		Connection conn=null;
		boolean flag=false;
		conn=DbConnect.getConnection();
		String sql="update home_nongchang set title=?,image=?,content=? where id=?";
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, image);
			ps.setString(2, title);
			ps.setString(3, content);
			ps.setInt(4,id);
			int n=ps.executeUpdate();
			if(n>0){
				flag=true;
			}
			ps.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbConnect.closeConnection(conn);
		}
		return flag;
	}
	public static boolean updateLunbo(int id, String title, String image, String content) {
		// TODO Auto-generated method stub
		Connection conn=null;
		boolean flag=false;
		conn=DbConnect.getConnection();
		String sql="update lunbo set title=?,image=?,content=? where id=?";
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, image);
			ps.setString(3, content);
			ps.setInt(4,id);
			int n=ps.executeUpdate();
			if(n>0){
				flag=true;
			}
			ps.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbConnect.closeConnection(conn);
		}
		return flag;
	}
	public static List<Newstudent_jiben> getxinxiBySearch(String search) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Newstudent_jiben> myxinxi=new ArrayList<Newstudent_jiben>();
		conn=DbConnect.getConnection();
		String sql="select * from newstudent_jiben where idcard=?";
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,search);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			Newstudent_jiben xinxi=new Newstudent_jiben();
			xinxi.setId(rs.getInt("id"));
			
			xinxi.setSex(rs.getString("sex"));
			xinxi.setIdcard(rs.getString("idcard"));
			xinxi.setName(rs.getString("name"));
			xinxi.setXuehao(rs.getString("xuehao"));
			xinxi.setZhuanye(rs.getString("zhuanye"));
			xinxi.setCla(rs.getString("cla"));
			xinxi.setQinshi(rs.getString("qinshi"));
			xinxi.setNianji(rs.getString("nianji"));
			myxinxi.add(xinxi);
			}
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbConnect.closeConnection(conn);
		}
		return myxinxi;
	}
	public static List<Tongzhi> getXiaoxiBySearch(int bumenid) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Tongzhi> mylunbo=new ArrayList<Tongzhi>();
		conn=DbConnect.getConnection();
		String sql="select * from tongzhi where bumen_id=?";
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,bumenid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Tongzhi lunbo=new Tongzhi();
				lunbo.setId(rs.getInt("id"));
				lunbo.setBumen_id(rs.getInt("bumen_id"));
				lunbo.setStudent_id(rs.getInt("student_id"));
				lunbo.setContent(rs.getString("content"));
				lunbo.setTime(rs.getString("time"));
			    mylunbo.add(lunbo);
			}
			System.out.println(mylunbo.size());
			ps.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbConnect.closeConnection(conn);
		}
		return mylunbo;
	}
	public static List<Home_yin> getHome_yinBySearch(String search) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Home_yin> myhome_yin=new ArrayList<Home_yin>();
		conn=DbConnect.getConnection();
		String sql="select * from home_yin where title like ? or jian like ? or adr like ?";
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+search+"%");
			ps.setString(2, "%"+search+"%");
			ps.setString(3, "%"+search+"%");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Home_yin home_yin=new Home_yin();
				home_yin.setId(rs.getInt("id"));
				home_yin.setTitle(rs.getString("title"));
				home_yin.setJian(rs.getString("jian"));
				home_yin.setImage(rs.getString("image"));
				home_yin.setAdr(rs.getString("adr"));
				home_yin.setPhone(rs.getString("phone"));
				//Lunbo.setContent(rs.getString("content"));
				myhome_yin.add(home_yin);
			}
			ps.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbConnect.closeConnection(conn);
		}
		return myhome_yin;
	}
	public static List<Home_data> getHome_dataBySearch(String search) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Home_data> myhome_data=new ArrayList<Home_data>();
		conn=DbConnect.getConnection();
		String sql="select * from tb_news where h5 like ? or max_data like ?";
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+search+"%");
			ps.setString(2, "%"+search+"%");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Home_data home_data=new Home_data();
				home_data.setId(rs.getInt("id"));
				home_data.setMax_data(rs.getInt("max_data"));
				home_data.setH5(rs.getString("h5"));
				//Lunbo.setContent(rs.getString("content"));
				myhome_data.add(home_data);
			}
			ps.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbConnect.closeConnection(conn);
		}
		return myhome_data;
	}
	public static List<Jianzhis> getJianzhiBySearch(String search) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Jianzhis> mygamelei=new ArrayList<Jianzhis>();
		conn=DbConnect.getConnection();
		String sql="select * from jianzhi where title like ? or content like ? or time like ?";
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+search+"%");
			ps.setString(2, "%"+search+"%");
			ps.setString(3, "%"+search+"%");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Jianzhis gamelei=new Jianzhis();
				gamelei.setId(rs.getInt("id"));
				gamelei.setTitle(rs.getString("title"));
				gamelei.setContent(rs.getString("content"));
				gamelei.setTime(rs.getString("time"));
				gamelei.setZan(rs.getInt("zan"));
				gamelei.setImg(rs.getString("img"));
				gamelei.setJing(rs.getInt("jing"));
			    mygamelei.add(gamelei);
			}
			System.out.println(mygamelei.size());
			ps.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbConnect.closeConnection(conn);
		}
		return mygamelei;
	}
	public static List<Home_nongchang> getHome_nongchangBySearch(String search) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Home_nongchang> myhome_nongchang=new ArrayList<Home_nongchang>();
		conn=DbConnect.getConnection();
		String sql="select * from Home_nongchang where title like ? or content like ?";
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+search+"%");
			ps.setString(2, "%"+search+"%");		
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Home_nongchang home_nongchang=new Home_nongchang();
				home_nongchang.setId(rs.getInt("id"));
				home_nongchang.setImage(rs.getString("image"));
				home_nongchang.setTitle(rs.getString("title"));
				home_nongchang.setContent(rs.getString("content"));
				home_nongchang.setCla(rs.getString("cla"));
			    myhome_nongchang.add(home_nongchang);
			}
			ps.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbConnect.closeConnection(conn);
		}
		return myhome_nongchang;
	}
	public static int getItemCount() {
		int result=0;
		Connection conn=null;
		conn=DbConnect.getConnection();
		Map<String,Object> map=null;
		String sql="select count(*) mycount from jianzhi";
		try {
			map=UserService.findSimpleResult(sql, null);
			result=Integer.parseInt(map.get("mycount").toString());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
	        DbConnect.closeConnection(conn);
		}
		return result;	
	}
	public static int getItemCount2() {
		int result=0;
		Connection conn=null;
		conn=DbConnect.getConnection();
		Map<String,Object> map=null;
		String sql="select count(*) mycount from jianzhi where jing=1";
		try {
			map=UserService.findSimpleResult(sql, null);
			result=Integer.parseInt(map.get("mycount").toString());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
	        DbConnect.closeConnection(conn);
		}
		return result;	
	}
	
	public static boolean AdminSendstudent(String sender,String sendered, String content, String time,String title) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Connection conn=null;
		conn=DbConnect.getConnection();
		String sql="insert into tongzhi(sender,sendered,content,time,title) values(?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, sender);
			ps.setString(2, sendered);
			ps.setString(3, content);
			ps.setString(4, time);
			ps.setString(5, title);
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

	public static List<Bumen_baoming> getAllBumen_baoming() {
		Connection conn=null;
		List<Bumen_baoming> allbumen_baoming=new ArrayList<Bumen_baoming>();
		conn=DbConnect.getConnection();
		String sql="select * from bumen_baoming";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Bumen_baoming bumen_baoming=new Bumen_baoming();
				bumen_baoming.setId(rs.getInt("id"));
				bumen_baoming.setStudent_id(rs.getInt("student_id"));
				bumen_baoming.setFirst(rs.getString("first"));
				bumen_baoming.setTwo(rs.getString("two"));
				bumen_baoming.setTiao(rs.getString("tiao"));
				allbumen_baoming.add(bumen_baoming);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ff");
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return allbumen_baoming;
	}
	public static boolean AddbumenmenberBySudent_id(int student_id,String time, String zhiwei, int id) {
		Connection conn=null;
		conn=DbConnect.getConnection();
		boolean flag=false;
		String sql="insert into bumen_menber(student_id,join_time,zhiwei,bumen_id) values(?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,student_id);
			ps.setString(2,time);
			ps.setString(3,zhiwei);
			ps.setInt(4,id);
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
	public static List<Bumen_baoming> ChazhaoByFirst1(String first, String two, String tiao) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Bumen_baoming> result_list=new ArrayList<Bumen_baoming>();
		conn=DbConnect.getConnection();
		String sql="select * from bumen_baoming where first=? and two=? and tiao=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, first);
			ps.setString(2, two);
			ps.setString(3, tiao);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Bumen_baoming tou=new Bumen_baoming();
				tou.setId(rs.getInt("id"));
				tou.setStudent_id(rs.getInt("student_id"));
				tou.setFirst(rs.getString("first"));
				tou.setTwo(rs.getString("two"));
				tou.setTiao(rs.getString("tiao"));
				result_list.add(tou);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return result_list;
	}
	public static List<Bumen_baoming> ChazhaoByFirst2(String first, String two) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Bumen_baoming> result_list=new ArrayList<Bumen_baoming>();
		conn=DbConnect.getConnection();
		String sql="select * from bumen_baoming where first=? and two=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, first);
			ps.setString(2, two);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Bumen_baoming tou=new Bumen_baoming();
				tou.setId(rs.getInt("id"));
				tou.setStudent_id(rs.getInt("student_id"));
				tou.setFirst(rs.getString("first"));
				tou.setTwo(rs.getString("two"));
				tou.setTiao(rs.getString("tiao"));
				result_list.add(tou);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return result_list;
	}
	public static List<Bumen_baoming> ChazhaoByFirst3(String first, String tiao) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Bumen_baoming> result_list=new ArrayList<Bumen_baoming>();
		conn=DbConnect.getConnection();
		String sql="select * from bumen_baoming where first=? and tiao=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, first);
			ps.setString(2, tiao);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Bumen_baoming tou=new Bumen_baoming();
				tou.setId(rs.getInt("id"));
				tou.setStudent_id(rs.getInt("student_id"));
				tou.setFirst(rs.getString("first"));
				tou.setTwo(rs.getString("two"));
				tou.setTiao(rs.getString("tiao"));
				result_list.add(tou);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return result_list;
	}
	public static List<Bumen_baoming> ChazhaoByFirst4(String first) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Bumen_baoming> result_list=new ArrayList<Bumen_baoming>();
		conn=DbConnect.getConnection();
		String sql="select * from bumen_baoming where first=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, first);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Bumen_baoming tou=new Bumen_baoming();
				tou.setId(rs.getInt("id"));
				tou.setStudent_id(rs.getInt("student_id"));
				tou.setFirst(rs.getString("first"));
				tou.setTwo(rs.getString("two"));
				tou.setTiao(rs.getString("tiao"));
				result_list.add(tou);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return result_list;
	}
	public static List<Bumen_baoming> ChazhaoByFirst5(String two, String tiao) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Bumen_baoming> result_list=new ArrayList<Bumen_baoming>();
		conn=DbConnect.getConnection();
		String sql="select * from bumen_baoming where two=? and tiao=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, two);
			ps.setString(1, tiao);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Bumen_baoming tou=new Bumen_baoming();
				tou.setId(rs.getInt("id"));
				tou.setStudent_id(rs.getInt("student_id"));
				tou.setFirst(rs.getString("first"));
				tou.setTwo(rs.getString("two"));
				tou.setTiao(rs.getString("tiao"));
				result_list.add(tou);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return result_list;
	}
	public static List<Bumen_baoming> ChazhaoByFirst6(String two) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Bumen_baoming> result_list=new ArrayList<Bumen_baoming>();
		conn=DbConnect.getConnection();
		String sql="select * from bumen_baoming where two=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, two);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Bumen_baoming tou=new Bumen_baoming();
				tou.setId(rs.getInt("id"));
				tou.setStudent_id(rs.getInt("student_id"));
				tou.setFirst(rs.getString("first"));
				tou.setTwo(rs.getString("two"));
				tou.setTiao(rs.getString("tiao"));
				result_list.add(tou);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return result_list;
	}
	public static List<Bumen_baoming> ChazhaoByFirst7(String tiao) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Bumen_baoming> result_list=new ArrayList<Bumen_baoming>();
		conn=DbConnect.getConnection();
		String sql="select * from bumen_baoming where tiao=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, tiao);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Bumen_baoming tou=new Bumen_baoming();
				tou.setId(rs.getInt("id"));
				tou.setStudent_id(rs.getInt("student_id"));
				tou.setFirst(rs.getString("first"));
				tou.setTwo(rs.getString("two"));
				tou.setTiao(rs.getString("tiao"));
				result_list.add(tou);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return result_list;
	}
	public static List<Bumen_baoming> getBumen_baomingBySearch(String search) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Bumen_baoming> mybumen_baoming=new ArrayList<Bumen_baoming>();
		conn=DbConnect.getConnection();
		String sql="select * from bumen_baoming where first like ? or two like ? or tiao like ?";
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+search+"%");
			ps.setString(2, "%"+search+"%");	
			ps.setString(3, "%"+search+"%");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Bumen_baoming tou=new Bumen_baoming();
				tou.setId(rs.getInt("id"));
				tou.setStudent_id(rs.getInt("student_id"));
				tou.setFirst(rs.getString("first"));
				tou.setTwo(rs.getString("two"));
				tou.setTiao(rs.getString("tiao"));
				System.out.println(rs.getString("tiao"));
				mybumen_baoming.add(tou);
			}
			ps.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbConnect.closeConnection(conn);
		}
		return mybumen_baoming;
	}
	public static List<Bumen_menber> getAllBumen_menberBybumen_id(int bumen_id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Bumen_menber> result_list=new ArrayList<Bumen_menber>();
		conn=DbConnect.getConnection();
		String sql="select * from bumen_menber where bumen_id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, bumen_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Bumen_menber tou=new Bumen_menber();
				tou.setId(rs.getInt("id"));
				tou.setStudent_id(rs.getInt("student_id"));
				tou.setZhiwei(rs.getString("zhiwei"));
				tou.setJoin_time(rs.getString("join_time"));
				tou.setBumen_id(rs.getInt("bumen_id"));
				result_list.add(tou);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return result_list;
	}
	public static List<Jianzhis> getJianzhiById(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Jianzhis> list1=new ArrayList<Jianzhis>();
		conn=DbConnect.getConnection();
		String sql="select * from jianzhi where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
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
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnect.closeConnection(conn);
		}
		return list1;
	}
	public static boolean updateJianzhi(int id, String title, String href, String content, String pic_url) {
		// TODO Auto-generated method stub
		Connection conn=null;
		boolean flag=false;
		conn=DbConnect.getConnection();
		String sql="update jianzhi set title=?,href=?,content=?,img=? where id=?";
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, href);
			ps.setString(3, content);
			ps.setString(4,pic_url);
			ps.setInt(5,id);
			int n=ps.executeUpdate();
			if(n>0){
				flag=true;
			}
			ps.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbConnect.closeConnection(conn);
		}
		return flag;
	}
	public static boolean deleteStudentById(int jianzhi_id) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Connection conn=null;
		conn=DbConnect.getConnection();
		String sql="delete from student_user where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, jianzhi_id);
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
	public static boolean DelectbumenbaomingBySudent_id(int student_id) {
		// TODO Auto-generated method stub
				boolean flag=false;
				Connection conn=null;
				conn=DbConnect.getConnection();
				String sql="delete from bumen_baoming where student_id=?";
				try {
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setInt(1, student_id);
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
	public static List<Classes> getAllClaByFudao_id(int teacher_id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Classes> result_list=new ArrayList<Classes>();
		conn=DbConnect.getConnection();
		String sql="select * from classes where fudao=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, teacher_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Classes tou=new Classes();
				tou.setId(rs.getInt("id"));
				tou.setFudao(rs.getInt("fudao"));
				tou.setZhuanye(rs.getString("zhuanye"));
				tou.setCla(rs.getString("cla"));
				tou.setTeacher(rs.getString("teacher"));
				tou.setNianji(rs.getString("nianji"));
				result_list.add(tou);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return result_list;
	}
	public static List<Classes> getClaBySearch(String search) {
		Connection conn=null;
		List<Classes> myhome_yin=new ArrayList<Classes>();
		conn=DbConnect.getConnection();
		String sql="select * from classes where zhuanye like ? or teacher like ? or nianji like ?";
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+search+"%");
			ps.setString(2, "%"+search+"%");
			ps.setString(3, "%"+search+"%");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Classes tou=new Classes();
				tou.setId(rs.getInt("id"));
				tou.setFudao(rs.getInt("fudao"));
				tou.setZhuanye(rs.getString("zhuanye"));
				tou.setCla(rs.getString("cla"));
				tou.setTeacher(rs.getString("teacher"));
				tou.setNianji(rs.getString("nianji"));
				myhome_yin.add(tou);
			}
			ps.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbConnect.closeConnection(conn);
		}
		return myhome_yin;
	}
	public static boolean TeacherSendstudent(int teacher_id, int student_id, String content, String time) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Connection conn=null;
		conn=DbConnect.getConnection();
		String sql="insert into teacher_tongzhi(teacher_id,student_id,content,time) values(?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, teacher_id);
			ps.setInt(2, student_id);
			ps.setString(3, content);
			ps.setString(4, time);
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
	public static boolean AddYijian(String name, String nianji, String qq, String content, String fb_time) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Connection conn=null;
		conn=DbConnect.getConnection();
		String sql="insert into yijian(name,nianji,qq,content,time) values(?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, nianji);
			ps.setString(3, qq);
			ps.setString(4, content);
			ps.setString(5, fb_time);
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
	public static boolean deleteYijianById(int jianzhi_id) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Connection conn=null;
		conn=DbConnect.getConnection();
		String sql="delete from yijian where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, jianzhi_id);
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
	/*******¿Î³Ì**/
	public static List<Kecheng> getAllKecheng() {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Kecheng> allkecheng=new ArrayList<Kecheng>();
		conn=DbConnect.getConnection();
		String sql="select * from kecheng";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Kecheng kecheng=new Kecheng();
				kecheng.setId(rs.getInt("id"));
				kecheng.setKe_name(rs.getString("ke_name"));
				kecheng.setTime(rs.getString("time"));
				kecheng.setImg(rs.getString("img"));
				kecheng.setTime(rs.getString("time"));
				allkecheng.add(kecheng);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ff");
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return allkecheng;
	}
	public static List<Teacher_kecheng> getAllKechengByTeacher_xuehao(String teacher_xuehao) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Teacher_kecheng> allkecheng=new ArrayList<Teacher_kecheng>();
		conn=DbConnect.getConnection();
		String sql="select * from teacher_kecheng where teacher_xuehao=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, teacher_xuehao);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Teacher_kecheng kecheng=new Teacher_kecheng();
				kecheng.setId(rs.getInt("id"));
				kecheng.setKecheng_id(rs.getInt("kecheng_id"));
				kecheng.setTime(rs.getString("time"));
				kecheng.setTeacher_xuehao(rs.getString("teacher_xuehao"));
				allkecheng.add(kecheng);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return allkecheng;
	}
	
	public static boolean Addkecheng(String ke_name, String pic_url, String time, int teacher_id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn=DbConnect.getConnection();
		boolean flag=false;
		String sql="insert into kecheng(ke_name,img,time,teacher_id) values(?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,ke_name);
			ps.setString(2,pic_url);
			ps.setString(3,time);
			ps.setInt(4,teacher_id);
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
	public static boolean AddKecheng_renwu1(int kecheng_id, String time, String name, int id, int du, String content) {
				Connection conn=null;
				conn=DbConnect.getConnection();
				boolean flag=false;
				String sql="insert into kecheng_renwu(kecheng_id,time,name,teacher_id,du,content) values(?,?,?,?,?,?)";
				try {
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setInt(1,kecheng_id);
					ps.setString(2,time);
					ps.setString(3,name);
					ps.setInt(4,id);
					ps.setInt(5,du);
					ps.setString(6,content);
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
	public static Teacher_kecheng getTeacher_kechengByKecheng_id(int kecheng_id){
		Teacher_kecheng chauser=new Teacher_kecheng();
    	String sql="select * from teacher_kecheng where kecheng_id=?";
    	Connection conn=null;
    	conn=DbConnect.getConnection();
    	try {
    		PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, kecheng_id);
			/*chauser=UserService.findSimpleResult(sql,name);*/
			ResultSet resultSet=ps.executeQuery();
			while(resultSet.next()) {  
				Teacher_kecheng user=new Teacher_kecheng();
				user.setId(resultSet.getInt("id"));
				user.setTeacher_xuehao(resultSet.getString("teacher_xuehao"));
				user.setKecheng_id(resultSet.getInt("kecheng_id"));
				user.setTime(resultSet.getString("time"));
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
	public static List<Student_kecheng> getKechengBystudent_xuehao(String student_xuehao) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Student_kecheng> allkecheng=new ArrayList<Student_kecheng>();
		conn=DbConnect.getConnection();
		String sql="select * from student_kecheng where student_xuehao=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, student_xuehao);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Student_kecheng kecheng=new Student_kecheng();
				kecheng.setId(rs.getInt("id"));
				kecheng.setStudent_xuehao(rs.getString("student_xuehao"));
				kecheng.setKecheng_id(rs.getInt("kecheng_id"));
				allkecheng.add(kecheng);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return allkecheng;
	}
	public static Kecheng getKechengBykecheng_id(int id){
		Kecheng chauser=new Kecheng();
    	String sql="select * from kecheng where id=?";
    	Connection conn=null;
    	conn=DbConnect.getConnection();
    	try {
    		PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			/*chauser=UserService.findSimpleResult(sql,name);*/
			ResultSet resultSet=ps.executeQuery();
			while(resultSet.next()) {  
				Kecheng user=new Kecheng();
				user.setId(resultSet.getInt("id"));
				user.setImg(resultSet.getString("img"));
				user.setKe_name(resultSet.getString("ke_name"));
				user.setTime(resultSet.getString("time"));
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
	public static Kecheng_renwu getKechengrenwuByid(int renwu_id) {
		// TODO Auto-generated method stub
		Kecheng_renwu chauser=new Kecheng_renwu();
    	String sql="select * from kecheng_renwu where id=?";
    	Connection conn=null;
    	conn=DbConnect.getConnection();
    	try {
    		PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, renwu_id);
			/*chauser=UserService.findSimpleResult(sql,name);*/
			ResultSet resultSet=ps.executeQuery();
			while(resultSet.next()) {  
				Kecheng_renwu user=new Kecheng_renwu();
				user.setId(resultSet.getInt("id"));
				user.setKecheng_id(resultSet.getInt("kecheng_id"));
				user.setName(resultSet.getString("name"));
				user.setTime(resultSet.getString("time"));
				user.setTeacher_id(resultSet.getInt("teacher_id"));
				user.setDu(resultSet.getInt("du"));
				user.setContent(resultSet.getString("content"));
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
	public static boolean InsertRenwuAnser(int renwu_id, String anser, String time, int flag) {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn=DbConnect.getConnection();
		boolean flag1=false;
		String sql="insert into renwu_anser(renwu_id,anser,time,flag) values(?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,renwu_id);
			ps.setString(2,anser);
			ps.setString(3,time);
			ps.setInt(4,flag);
			int n=ps.executeUpdate();
			if(n>0){
				flag1=true;
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return flag1;
	}
	public static Renwu_anser getAnserByRenwu_id(String student_xuehao, int renwu_id) {
		// TODO Auto-generated method stub
		Renwu_anser chauser=new Renwu_anser();
    	String sql="select * from renwu_anser where student_xuehao=? and renwu_id=?";
    	Connection conn=null;
    	conn=DbConnect.getConnection();
    	try {
    		PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, student_xuehao);
			ps.setInt(2, renwu_id);
			/*chauser=UserService.findSimpleResult(sql,name);*/
			ResultSet resultSet=ps.executeQuery();
			while(resultSet.next()) {  
				Renwu_anser user=new Renwu_anser();
				user.setId(resultSet.getInt("id"));
				user.setRenwu_id(resultSet.getInt("renwu_id"));
				user.setAnser(resultSet.getString("anser"));
				user.setTime(resultSet.getString("time"));
				user.setFlag(resultSet.getInt("flag"));
				user.setStudent_xuehao(resultSet.getString("student_xuehao"));
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
	
	public static boolean checkAnser(String student_xuehao,int renwu_id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn=DbConnect.getConnection();
		boolean flag=false;
		String sql="select student_xuehao,renwu_id from renwu_anser where student_xuehao=? and renwu_id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,student_xuehao);
			ps.setInt(2, renwu_id);
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
	public static List<Renwu_anser> getAnserByRenwu_id1(int renwu_id) {
		// TODO Auto-generated method stub
				Connection conn=null;
				List<Renwu_anser> allanser=new ArrayList<Renwu_anser>();
				conn=DbConnect.getConnection();
				String sql="select * from renwu_anser where renwu_id=?";
				try {
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setInt(1, renwu_id);
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						Renwu_anser anser=new Renwu_anser();
						anser.setId(rs.getInt("id"));
						anser.setRenwu_id(rs.getInt("renwu_id"));
						anser.setAnser(rs.getString("anser"));
						anser.setTime(rs.getString("time"));
						anser.setFlag(rs.getInt("flag"));
						anser.setStudent_xuehao(rs.getString("student_xuehao"));
						
						allanser.add(anser);
					}
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					DbConnect.closeConnection(conn);
				}
				return allanser;
	}
	public static List<Tongzhi> getAllTongzhiBystudent(String xuehao) {
		// TODO Auto-generated method stub  order by id desc
		Connection conn=null;
		List<Tongzhi> allanser=new ArrayList<Tongzhi>();
		conn=DbConnect.getConnection();
		String sql="select * from tongzhi where sendered=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, xuehao);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Tongzhi anser=new Tongzhi();
				anser.setId(rs.getInt("id"));
				anser.setSender(rs.getString("sender"));
				anser.setContent(rs.getString("content"));
				anser.setTime(rs.getString("time"));
				anser.setFlag(rs.getInt("flag"));
				anser.setSendered(rs.getString("sendered"));
				anser.setTitle(rs.getString("title"));
				allanser.add(anser);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return allanser;
	}
	public static Tongzhi getTongzhiById(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Tongzhi tongzhi=new Tongzhi();
		conn=DbConnect.getConnection();
		String sql="select * from tongzhi where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Tongzhi anser=new Tongzhi();
				anser.setId(rs.getInt("id"));
				anser.setSender(rs.getString("sender"));
				anser.setTitle(rs.getString("title"));
				anser.setTime(rs.getString("time"));
				anser.setContent(rs.getString("content"));
				anser.setFlag(rs.getInt("flag"));
				anser.setSendered(rs.getString("sendered"));
				tongzhi=anser;
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return tongzhi;
	}
	public static boolean updateTongzhiById(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn=DbConnect.getConnection();
		boolean flag=false;
		String sql="update tongzhi set flag=1 where id=?";
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			int n=ps.executeUpdate();
			if(n>0){
				flag=true;
			}
			ps.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbConnect.closeConnection(conn);
		}
		return flag;
	}
	public static boolean addkechengstudent(String xuehao, int kecheng_id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn=DbConnect.getConnection();
		boolean flag1=false;
		String sql="insert into student_kecheng(student_xuehao,kecheng_id) values(?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1,xuehao);
			ps.setInt(2,kecheng_id);
			int n=ps.executeUpdate();
			if(n>0){
				flag1=true;
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return flag1;
	}
	public static boolean checkkechengstudent(String xuehao, int kecheng_id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn=DbConnect.getConnection();
		boolean flag=false;
		String sql="select student_xuehao,kecheng_id from student_kecheng where student_xuehao=? and kecheng_id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,xuehao);
			ps.setInt(2, kecheng_id);
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
	public static boolean AddKecheng_chengji(String student_xuehao, int renwu_id, String time, Double chengji) {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn=DbConnect.getConnection();
		boolean flag1=false;
		String sql="insert into kecheng_chengji(student_xuehao,renwu_id,time,chengji) values(?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1,student_xuehao);
			ps.setInt(2,renwu_id);
			ps.setString(3,time);
			ps.setDouble(4,chengji);
			int n=ps.executeUpdate();
			if(n>0){
				flag1=true;
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return flag1;
	}
	public static Kecheng_chengji getKecheng_chengjiByStudent_xuehaoandrenwu_id(String student_xuehao, int renwu_id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Kecheng_chengji chauser=new Kecheng_chengji();
		    	String sql="select * from kecheng_chengji where student_xuehao=? and renwu_id=?";
		    	Connection conn=null;
		    	conn=DbConnect.getConnection();
		    	try {
		    		PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1, student_xuehao);
					ps.setInt(2, renwu_id);
					/*chauser=UserService.findSimpleResult(sql,name);*/
					ResultSet resultSet=ps.executeQuery();
					while(resultSet.next()) {  
						Kecheng_chengji user=new Kecheng_chengji();
						user.setId(resultSet.getInt("id"));
						user.setStudent_xuehao(resultSet.getString("student_xuehao"));
						user.setRenwu_id(resultSet.getInt("renwu_id"));
						user.setChengji(resultSet.getDouble("chengji"));
						user.setTime(resultSet.getString("time"));
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
	public static boolean Checkkecheng_chengjiExist(String student_xuehao, int renwu_id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn=DbConnect.getConnection();
		boolean flag=false;
		String sql="select student_xuehao,renwu_id from kecheng_chengji where student_xuehao=? and renwu_id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,student_xuehao);
			ps.setInt(2, renwu_id);
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
	public static boolean DelectKecheng_chengjiBystudent_xuehaoandrenwu_id(String student_xuehao, int renwu_id) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Connection conn=null;
		conn=DbConnect.getConnection();
		String sql="delete from kecheng_chengji where student_xuehao=? and renwu_id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, student_xuehao);
			ps.setInt(2, renwu_id);
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
	public static List<Student_kecheng> getStudent_kechengBykecheng_id(int kecheng_id) {
		Connection conn=null;
		List<Student_kecheng> allanser=new ArrayList<Student_kecheng>();
		conn=DbConnect.getConnection();
		String sql="select * from student_kecheng where kecheng_id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, kecheng_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Student_kecheng anser=new Student_kecheng();
				anser.setId(rs.getInt("id"));
				anser.setStudent_xuehao(rs.getString("student_xuehao"));
				anser.setKecheng_id(rs.getInt("kecheng_id"));
				allanser.add(anser);
					}
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					DbConnect.closeConnection(conn);
				}
				return allanser;
	}
	public static List<Kecheng_chengji> getAllKecheng_chengjiByrenwu_id(int renwu_id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Kecheng_chengji> allkecheng=new ArrayList<Kecheng_chengji>();
		conn=DbConnect.getConnection();
		String sql="select * from kecheng_chengji where renwu_id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, renwu_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Kecheng_chengji kecheng=new Kecheng_chengji();
				kecheng.setId(rs.getInt("id"));
				kecheng.setStudent_xuehao(rs.getString("student_xuehao"));
				kecheng.setRenwu_id(rs.getInt("renwu_id"));
				kecheng.setChengji(rs.getDouble("chengji"));
				kecheng.setTime(rs.getString("time"));
				
				allkecheng.add(kecheng);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbConnect.closeConnection(conn);
		}
		return allkecheng;
	}
}
