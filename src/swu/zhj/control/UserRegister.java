package swu.zhj.control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import swu.zhj.service.UserService;
import swu.zhj.util.Md5Encrypt;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegister")
//@MultipartConfig()     //必须要有这个
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
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
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		String xuehao=request.getParameter("xuehao");
		String zhuanye=request.getParameter("zhuanye");
		String cla=request.getParameter("cla");
		String nianji=request.getParameter("nianji");
		String qinshi=request.getParameter("qinshi");
		String qq=request.getParameter("qq");
		String phone=request.getParameter("phone");
		String img=null;
		Md5Encrypt md5encrypt=new Md5Encrypt();
		password=md5encrypt.Encrypt(password);
		//由cla，zhuanye,nianji 在表classes中得到cla_id，
		int cla_id=UserService.GetCla_id(zhuanye,cla,nianji);
		
		boolean flag=UserService.addUser(name, password, xuehao, zhuanye, cla, qinshi, qq, phone, nianji,img,cla_id);
		if(flag){
			response.sendRedirect(request.getContextPath()+"/mylogin/login.jsp");
		}
		else{
			response.sendRedirect(request.getContextPath()+"/home/register.jsp");
        }
		out.flush();
        out.close();
	}

}
