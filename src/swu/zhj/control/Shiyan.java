package swu.zhj.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.core.ApplicationPart;

import swu.zhj.dbutil.DbConnect;

/**
 * Servlet implementation class Shiyan
 */
@WebServlet("/Shiyan")
@MultipartConfig()     //必须要有这个
public class Shiyan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Shiyan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String path = this.getServletContext().getRealPath("/");	//获取服务器地址
		Part p = request.getPart("uploadImg");//获取用户选择的上传文件
		String fname2="";
		if (p.getContentType().contains("image")) {					// 仅处理上传的图像文件
			ApplicationPart ap = (ApplicationPart) p;
			//获取上传文件名
			String fname1 = ap.getSubmittedFileName();
			//以下代码取得文件的后缀名
			int dot=fname1.lastIndexOf(".");
			String extentname=fname1.substring(dot+1);
			//以下代码取得当前日期
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");//可以方便地修改日期格式
			String firstname = dateFormat.format( now ); 
			//产生随机数
			Random rd=new Random();
			String xxxx="";
			for(int i=1;i<=4;i++){
				xxxx=xxxx+(rd.nextInt(10)+1);
			}
			//拼接文件名
			firstname=firstname+xxxx;
			fname2=firstname+"."+extentname;
			// 写入 web 项目根路径下的upload文件夹中
			p.write(path + "/upload/" + fname2);
			System.out.print(path + "/upload/" + fname2);
			out.write("数据保存成功！");
			
		}
		else{
			  out.write("请选择图片文件！！！");
		}
		//信息写入数据库
		request.setCharacterEncoding("utf-8");
		String title="1";
		String category="1";
		String demo="1";
		String pic_url="/upload/" + fname2;
		String sql="insert into pictures(title,category,demo,pic_url) values(?,?,?,?)";
		Connection conn=DbConnect.getConnection();
		try {
			PreparedStatement pstm=conn.prepareStatement(sql);
			pstm.setString(1, title);
			pstm.setString(2, category);
			pstm.setString(3, demo);
			pstm.setString(4, pic_url);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
