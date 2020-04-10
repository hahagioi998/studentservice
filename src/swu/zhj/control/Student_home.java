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
@WebServlet("/Student_home")
public class Student_home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student_home() {
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
		Studentusers user=(Studentusers)session.getAttribute("user");
		String shen=(String)session.getAttribute("shen");

	       session.setAttribute("user",user);
	       session.setAttribute("shen",shen);
		
		List<Kecheng> kecheng_list=new ArrayList<Kecheng>();
		List<Student_kecheng> student_kecheng_list=new ArrayList<Student_kecheng>();
		List<Tongzhi> tongzhi_list=new ArrayList<Tongzhi>();
		
		kecheng_list=NewsService.getAllKecheng();
		student_kecheng_list=NewsService.getKechengBystudent_xuehao(user.getXuehao());
		tongzhi_list=NewsService.getAllTongzhiBystudent(user.getXuehao());
		request.setAttribute("kecheng_list",kecheng_list);
		//System.out.println(lunbo_list.size());
		
		request.setAttribute("tongzhi_list",tongzhi_list);
		request.setAttribute("student_kecheng_list",student_kecheng_list);
		request.getRequestDispatcher("home/student_home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
