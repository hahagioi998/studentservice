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

import swu.zhj.model.Jianzhis;
import swu.zhj.model.Yijian;
import swu.zhj.service.TiebaService;

/**
 * Servlet implementation class ListYijian
 */
@WebServlet("/ListYijian")
public class ListYijian extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListYijian() {
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
		List<Yijian> yijian_list=new ArrayList<Yijian>();
		
		yijian_list=TiebaService.getAllYijian();
		
		request.setAttribute("yijian_list",yijian_list);
	
		request.getRequestDispatcher("admin/list8.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
