package swu.zhj.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import swu.zhj.service.UserService;

/**
 * Servlet implementation class Update_xinxi
 */
@WebServlet("/Update_xinxi")
public class Update_xinxi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_xinxi() {
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
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		int id=(Integer)session.getAttribute("id");
		session.setAttribute("id",id);
		String xuehao=request.getParameter("xuehao");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String qq=request.getParameter("qq");
		String zhuanye=request.getParameter("zhuanye");
		String cla=request.getParameter("cla");
		String qinshi=request.getParameter("qinshi");
		boolean flag=UserService.UpdateUserById(id,name,xuehao,zhuanye,cla,qinshi,qq,phone);
		if(flag){
			response.sendRedirect(request.getContextPath()+"/mylogin/login.jsp");
		}
		else{
			response.sendRedirect(request.getContextPath()+"/home/register.jsp");
        }
		
	}

}
