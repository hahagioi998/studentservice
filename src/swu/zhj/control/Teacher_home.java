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


/**
 * Servlet implementation class Home
 */
@WebServlet("/Teacher_home")
public class Teacher_home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacher_home() {
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
		
		List<Teacher_kecheng> kecheng_list=new ArrayList<Teacher_kecheng>();
		List<Tongzhi> tongzhi_list=new ArrayList<Tongzhi>();
		System.out.println(teacher.getXuehao());
		kecheng_list=NewsService.getAllKechengByTeacher_xuehao(teacher.getXuehao());
		tongzhi_list=NewsService.getAllTongzhiBystudent(teacher.getXuehao());
		
		request.setAttribute("kecheng_list",kecheng_list);
		System.out.println(kecheng_list.size()+"...");
		request.setAttribute("tongzhi_list",tongzhi_list);
		request.getRequestDispatcher("home/teacher_home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
