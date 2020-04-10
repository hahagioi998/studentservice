package swu.zhj.control;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import swu.zhj.service.NewsService;

/**
 * Servlet implementation class Addbumenuser
 */
@WebServlet("/Addbumenuser")
public class Addbumenmenber extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addbumenmenber() {
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
		int student_id=Integer.parseInt(request.getParameter("student_id"));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=df.format(System.currentTimeMillis()); 
		boolean flag = false;
		boolean flag1 = false;
		String zhiwei="暂无";
		flag=NewsService.AddbumenmenberBySudent_id(student_id,time,zhiwei,id);
		//同时删除报名记录
		flag1=NewsService.DelectbumenbaomingBySudent_id(student_id);
		if(flag) {
			response.sendRedirect("ListBaoming");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
