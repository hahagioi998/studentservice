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
import swu.zhj.model.*;
import swu.zhj.service.NewsService;
import swu.zhj.service.UserService;


/**
 * Servlet implementation class Home
 */
@WebServlet("/Teacher_work_studentanser")
public class Teacher_work_studentanser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacher_work_studentanser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//从起始页跳转到Home页，从数据库加载数据显示在index.jsp
		HttpSession session=request.getSession();
		Teacherusers teacher=(Teacherusers)session.getAttribute("teacher");
		String shen=(String)session.getAttribute("shen");

		  session.setAttribute("teacher",teacher);
	       session.setAttribute("shen",shen);
        String student_xuehao=request.getParameter("student_xuehao");
        int renwu_id=Integer.parseInt(request.getParameter("renwu_id"));
		Renwu_anser renwu_anser=NewsService.getAnserByRenwu_id(student_xuehao,renwu_id);
		Kecheng_chengji kecheng_chengji=NewsService.getKecheng_chengjiByStudent_xuehaoandrenwu_id(student_xuehao,renwu_id);
		
		request.setAttribute("student_xuehao",student_xuehao);
		request.setAttribute("kecheng_chengji",kecheng_chengji);
		request.setAttribute("renwu_id",renwu_id);
		request.setAttribute("renwu_anser",renwu_anser);
		//System.out.println(lunbo_list.size());
		request.getRequestDispatcher("home/teacher_work_studentanser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
