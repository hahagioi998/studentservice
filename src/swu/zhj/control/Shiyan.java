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
@MultipartConfig()     //����Ҫ�����
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
		String path = this.getServletContext().getRealPath("/");	//��ȡ��������ַ
		Part p = request.getPart("uploadImg");//��ȡ�û�ѡ����ϴ��ļ�
		String fname2="";
		if (p.getContentType().contains("image")) {					// �������ϴ���ͼ���ļ�
			ApplicationPart ap = (ApplicationPart) p;
			//��ȡ�ϴ��ļ���
			String fname1 = ap.getSubmittedFileName();
			//���´���ȡ���ļ��ĺ�׺��
			int dot=fname1.lastIndexOf(".");
			String extentname=fname1.substring(dot+1);
			//���´���ȡ�õ�ǰ����
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");//���Է�����޸����ڸ�ʽ
			String firstname = dateFormat.format( now ); 
			//���������
			Random rd=new Random();
			String xxxx="";
			for(int i=1;i<=4;i++){
				xxxx=xxxx+(rd.nextInt(10)+1);
			}
			//ƴ���ļ���
			firstname=firstname+xxxx;
			fname2=firstname+"."+extentname;
			// д�� web ��Ŀ��·���µ�upload�ļ�����
			p.write(path + "/upload/" + fname2);
			System.out.print(path + "/upload/" + fname2);
			out.write("���ݱ���ɹ���");
			
		}
		else{
			  out.write("��ѡ��ͼƬ�ļ�������");
		}
		//��Ϣд�����ݿ�
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
