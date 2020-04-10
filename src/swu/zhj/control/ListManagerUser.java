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
import swu.zhj.model.Teacherusers;
import swu.zhj.service.UserService;

/**
 * Servlet implementation class ListManagerUser
 */
@WebServlet("/ListManagerUser")
public class ListManagerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListManagerUser() {
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
		//System.out.println(id+"shi");
		session.setAttribute("id",id);
		List<Teacherusers> manager_user_list=new ArrayList<Teacherusers>();
		
		manager_user_list=UserService.getAllManagerUsers();
		
		request.setAttribute("teacher_user_list",manager_user_list);
		System.out.println(manager_user_list.size());
		request.getRequestDispatcher("admin/list4.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
