package swu.zhj.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import swu.zhj.model.Studentusers;
import swu.zhj.service.UserService;

/**
 * Servlet implementation class ListClastudent
 */
@WebServlet("/ListClastudent")
public class ListClastudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListClastudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		int id=(Integer)session.getAttribute("id");
		System.out.println(id+"shi");
		session.setAttribute("id",id);
		int cla_id=Integer.parseInt(request.getParameter("cla_id"));
		List<Studentusers> student_user_list=new ArrayList<Studentusers>();
		
		student_user_list=UserService.getUsersByCla_id(cla_id);
		
		request.setAttribute("student_user_list",student_user_list);
		request.getRequestDispatcher("admin/list3.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
