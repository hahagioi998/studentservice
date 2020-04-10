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
@WebServlet("/Weiwanchengstudent")
public class Weiwanchengstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Weiwanchengstudent() {
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
	       
        int renwu_id=Integer.parseInt(request.getParameter("renwu_id"));
        int kecheng_id=Integer.parseInt(request.getParameter("kecheng_id"));
        
		List<Renwu_anser> renwu_anser_list=new ArrayList<Renwu_anser>();
		renwu_anser_list=NewsService.getAnserByRenwu_id1(renwu_id);
		
		List<Student_kecheng> student_kecheng_list=new ArrayList<Student_kecheng>();
		student_kecheng_list=NewsService.getStudent_kechengBykecheng_id(kecheng_id);
		
		request.setAttribute("student_kecheng_list",student_kecheng_list);
		request.setAttribute("renwu_anser_list",renwu_anser_list);
		request.setAttribute("renwu_id",renwu_id);
		request.setAttribute("kecheng_id",kecheng_id);
		
		//System.out.println(lunbo_list.size());
		request.getRequestDispatcher("home/weiwanchengstudent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
