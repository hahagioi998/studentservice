package swu.zhj.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import swu.zhj.model.Newstudent_jiben;
import swu.zhj.service.NewsService;

/**
 * Servlet implementation class NewstudentSearch
 */
@WebServlet("/NewstudentSearch")
public class NewstudentSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewstudentSearch() {
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
		request.setCharacterEncoding("utf-8");
		String search=request.getParameter("search");
		System.out.println(search);
		List<Newstudent_jiben> list_newstudent_jiben=new ArrayList<Newstudent_jiben>();
		list_newstudent_jiben=NewsService.getxinxiBySearch(search);
		request.setAttribute("list_newstudent_jiben", list_newstudent_jiben);
		request.getRequestDispatcher("home/NewFile.jsp").forward(request, response);
	}

}
