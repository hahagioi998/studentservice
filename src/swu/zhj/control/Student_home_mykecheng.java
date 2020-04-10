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

import swu.zhj.model.Kecheng;
import swu.zhj.model.Kecheng_renwu;
import swu.zhj.model.News;
import swu.zhj.model.Student_kecheng;
import swu.zhj.model.Studentusers;
import swu.zhj.model.Teacherusers;
import swu.zhj.model.Tongzhi;
import swu.zhj.service.NewsService;
import swu.zhj.service.UserService;

/**
 * Servlet implementation class ListStudentUser
 */
@WebServlet("/Student_home_mykecheng")
public class Student_home_mykecheng extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student_home_mykecheng() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Studentusers user=(Studentusers)session.getAttribute("user");
		String shen=(String)session.getAttribute("shen");

	       session.setAttribute("user",user);
	       session.setAttribute("shen",shen);
	       
	       List<Kecheng> kecheng_list=new ArrayList<Kecheng>();
			List<Student_kecheng> student_kecheng_list=new ArrayList<Student_kecheng>();
			
			kecheng_list=NewsService.getAllKecheng();
			student_kecheng_list=NewsService.getKechengBystudent_xuehao(user.getXuehao());
		    System.out.println(kecheng_list.size()+student_kecheng_list.size());
			request.setAttribute("kecheng_list",kecheng_list);
			request.setAttribute("student_kecheng_list",student_kecheng_list);
		request.getRequestDispatcher("home/student_home_mykecheng.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
