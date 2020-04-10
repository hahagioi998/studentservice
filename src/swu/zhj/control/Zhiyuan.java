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
 * Servlet implementation class Zhiyuan
 */
@WebServlet("/Zhiyuan")
public class Zhiyuan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Zhiyuan() {
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
		 /*String []values=request.getParameterValues("checkbox1");*/
		HttpSession session=request.getSession();
		String first=request.getParameter("first");
		String two=request.getParameter("two");
		String tiao=request.getParameter("tiao");
		int id=(Integer)session.getAttribute("id");
		System.out.println(first+two+tiao+id);
		//在表bumen_baoming中添加数据
		boolean flag=UserService.addBumen_baoming(id,first,two,tiao);
		if(flag) {
			response.sendRedirect("Xiaonei");
		}else {
			System.out.println("失败");
		}
	}

}
