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
import swu.zhj.model.Classes;
import swu.zhj.service.NewsService;

/**
 * Servlet implementation class ListCla
 */
@WebServlet("/ListCla")
public class ListCla extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCla() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		int teacher_id=(Integer)session.getAttribute("id");
		session.setAttribute("id",teacher_id);
		List<Classes> cla_list=new ArrayList<Classes>();
		
		cla_list=NewsService.getAllClaByFudao_id(teacher_id);
		
		request.setAttribute("cla_list",cla_list);
		
		request.getRequestDispatcher("admin/list7.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
