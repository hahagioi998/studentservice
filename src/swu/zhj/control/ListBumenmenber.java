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
import swu.zhj.model.Bumen_menber;
import swu.zhj.service.NewsService;

/**
 * Servlet implementation class ListBumenmenber
 */
@WebServlet("/ListBumenmenber")
public class ListBumenmenber extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListBumenmenber() {
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
		List<Bumen_menber> bumen_menber_list=new ArrayList<Bumen_menber>();
		
		bumen_menber_list=NewsService.getAllBumen_menberBybumen_id(bumen_id);
		
		request.setAttribute("bumen_menber_list",bumen_menber_list);
		
		request.getRequestDispatcher("admin/list1.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
