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
@MultipartConfig()     //����Ҫ�����
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
		String path = this.getServletContext().getRealPath("/");	//��ȡ��������ַ
		Part p = request.getPart("file1");//��ȡ�û�ѡ����ϴ��ļ�
		String fname2="";
			ApplicationPart ap = (ApplicationPart) p;
			//��ȡ�ϴ��ļ���
			String fname1 = ap.getSubmittedFileName();
			//���´���ȡ���ļ��ĺ�׺��
			int dot=fname1.lastIndexOf(".");
			String extentname=fname1.substring(dot+1);
			
			String firstname = "emp1"; 

			fname2=firstname+"."+extentname;
			// д�� web ��Ŀ��·���µ�upload�ļ�����
			p.write(path + fname2);
			
			//д�����ݿ�
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
			    //����nianji��zhuanye��cla�õ�cla_id
			    /*int cla_id=UserService.GetCla_id(zhuanye,cla,nianji);*/
				res = UserService.addUser(name, password, xuehao, zhuanye, cla, qinshi, qq, phone, nianji,img);
			}	
			if(res){
				response.sendRedirect("ListStudentUser");
				}
	}

}
