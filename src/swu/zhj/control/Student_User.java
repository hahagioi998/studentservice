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

import swu.zhj.model.Bumen_menber;
import swu.zhj.model.Studentusers;
import swu.zhj.model.Tongzhi;
import swu.zhj.service.TiebaService;
import swu.zhj.service.UserService;

/**
 * Servlet implementation class Student_User
 */
@WebServlet("/Student_User")
public class Student_User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student_User() {
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
		session.setAttribute("id",id);
        List<Tongzhi> tongzhi_list=new ArrayList<Tongzhi>();
		
        tongzhi_list=TiebaService.getTongzhiById(id);
        
		Bumen_menber bumen_menber=TiebaService.chausermenberById(id);
		Studentusers studentuser=TiebaService.chauserStudentById(id);
		
		request.setAttribute("tongzhi_list",tongzhi_list);
		request.setAttribute("studentuser",studentuser);
		request.setAttribute("bumen_menber",bumen_menber);
		
		request.getRequestDispatcher("home/student_user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
