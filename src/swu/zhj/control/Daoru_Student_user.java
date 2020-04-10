package swu.zhj.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.core.ApplicationPart;

import swu.zhj.model.Studentusers;
import swu.zhj.service.UserService;
import swu.zhj.util.ExcelOperationUtil;
import swu.zhj.util.Md5Encrypt;

/**
 * Servlet implementation class Daoru_Student_user
 */
@WebServlet("/Daoru_Student_user")
@MultipartConfig()     //必须要有这个
public class Daoru_Student_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Daoru_Student_user() {
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
		Part p = request.getPart("file1");//获取用户选择的上传文件
		String fname2="";
			ApplicationPart ap = (ApplicationPart) p;
			//获取上传文件名
			String fname1 = ap.getSubmittedFileName();
			//以下代码取得文件的后缀名
			int dot=fname1.lastIndexOf(".");
			String extentname=fname1.substring(dot+1);
			
			String firstname = "emp1"; 

			fname2=firstname+"."+extentname;
			// 写入 web 项目根路径下的upload文件夹中
			p.write(path + fname2);
			
			//写入数据库
			request.setCharacterEncoding("utf-8");
			String filePath =request.getRealPath(fname2);
			System.out.println(filePath);
			ExcelOperationUtil excelUtil = new ExcelOperationUtil();  
			List<Studentusers> list = excelUtil.readExcelFileToDB(filePath); 
			boolean res=false;
			for(Studentusers emp:list){
			    String name=emp.getName();
			    String password=emp.getPassword();
			    /*Md5Encrypt md5encrypt=new Md5Encrypt();
				password=md5encrypt.Encrypt(password);*/
			    String xuehao=emp.getXuehao();
			    String zhuanye=emp.getZhuanye();
			    String cla=emp.getCla();
			    String qinshi=emp.getQinshi();
			    String qq=emp.getQq();
			    String phone=emp.getPhone();
			    String img=emp.getImg();
			    String nianji=emp.getNianji();
			    //根据nianji和zhuanye和cla得到cla_id
			    /*int cla_id=UserService.GetCla_id(zhuanye,cla,nianji);*/
				res = UserService.addUser(name, password, xuehao, zhuanye, cla, qinshi, qq, phone, nianji,img);
			}	
			if(res){
				response.sendRedirect("ListStudentUser");
				}
	}

}
