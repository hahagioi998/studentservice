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
 * Servlet implementation class Updatebumenmenber
 */
@WebServlet("/Updatebumenmenber")
public class Updatebumenmenber extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatebumenmenber() {
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
		String zhiwei=request.getParameter("zhiwei");
		int ids=Integer.parseInt(request.getParameter("ids"));
		System.out.println(ids+zhiwei);
		boolean flag=UserService.UpdatebumenmenberById(ids,zhiwei);
		if(flag) {
			request.getRequestDispatcher("ListBumenmenber").forward(request, response);
		}
	}

}
