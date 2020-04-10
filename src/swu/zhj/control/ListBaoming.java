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

import swu.zhj.model.Bumen_baoming;
import swu.zhj.model.Home_yin;
import swu.zhj.service.NewsService;

/**
 * Servlet implementation class ListBaoming
 */
@WebServlet("/ListBaoming")
public class ListBaoming extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListBaoming() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		int bumen_id=(Integer)session.getAttribute("id");
		session.setAttribute("id",bumen_id);
		List<Bumen_baoming> bumen_baoming_list=new ArrayList<Bumen_baoming>();
		
		bumen_baoming_list=NewsService.getAllBumen_baoming();
		
		request.setAttribute("bumen_baoming_list",bumen_baoming_list);
		
		request.getRequestDispatcher("admin/list2.jsp").forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
