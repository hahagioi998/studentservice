package swu.zhj.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shiyan.AddressUtils;
import swu.zhj.service.TiebaService;
import swu.zhj.service.UserService;
import swu.zhj.util.IPUtil;
import swu.zhj.util.Md5Encrypt;

import swu.zhj.model.*;

/**
 * Servlet implementation class Userlogin
 */
@WebServlet("/Userlogin")
public class Userlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String xuehao=request.getParameter("xuehao");
		String password=request.getParameter("password");
		String shen=request.getParameter("shen");
		/*Md5Encrypt md5encrypt=new Md5Encrypt();
		password=md5encrypt.Encrypt(password);*/
		System.out.println(xuehao+password+shen);
		boolean flag = false;
		if(shen.equals("student")) {
		    flag=UserService.checkStudentUserExist(xuehao,password);
		    if(flag) {
		       Studentusers user=UserService.chauserStudent(xuehao);
		       HttpSession session=request.getSession();
		       session.setAttribute("user", user);
		       session.setAttribute("shen",shen);
			   response.sendRedirect("Student_home");
		    }
		}else if(shen.equals("teacher")){
			flag=UserService.checkTeacherUserExist(xuehao,password);
			if(flag) {
			       Teacherusers teacher=UserService.chauserTeacher(xuehao);
			       HttpSession session=request.getSession();
			       session.setAttribute("teacher", teacher);
			       session.setAttribute("shen",shen);
				   response.sendRedirect("Teacher_home");
			    }
		}else if(shen.equals("admin")){
			flag=UserService.checkManagerUserExist(xuehao,password);
			 if(flag) {
			       Admin admin=UserService.chauserManager(xuehao);
			       HttpSession session=request.getSession();
			       session.setAttribute("admin",admin);
			       session.setAttribute("shen",shen);
				   response.sendRedirect("admin/mian.jsp");
			      }
	          }
		if(flag==false) {
				out.println("<html>");
				out.println("<head>");
			    out.println("<title>µÇÂ¼Ê§°Ü</title>");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('ÕËºÅ»òÕßÃÜÂë´íÎó!');");
				out.println("</script>");
				out.println("</head>");
				out.println("<body>");
			    out.println("<center><a href='mylogin/login.jsp'>µã»÷·µ»Øµ½µÇÂ¼Ò³Ãæ</a></center>");
				out.println("</body>");
				out.println("</html>");
				}
	   }
}