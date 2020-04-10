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

import swu.zhj.model.Kecheng_renwu;
import swu.zhj.model.News;
import swu.zhj.model.Student_kecheng;
import swu.zhj.model.Studentusers;
import swu.zhj.model.Teacherusers;
import swu.zhj.service.NewsService;
import swu.zhj.service.UserService;

/**
 * Servlet implementation class ListStudentUser
 */
@WebServlet("/Teacher_mykecheng_xiangqin")
public class Teacher_mykecheng_xiangqin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacher_mykecheng_xiangqin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Teacherusers teacher=(Teacherusers)session.getAttribute("teacher");
		String shen=(String)session.getAttribute("shen");

	       session.setAttribute("teacher",teacher);
	       session.setAttribute("shen",shen);
	       int kecheng_id=Integer.parseInt(request.getParameter("kecheng_id"));
	       session.setAttribute("kecheng_id",kecheng_id);
		List<Kecheng_renwu> kecheng_renwu_list=new ArrayList<Kecheng_renwu>();
		List<Student_kecheng> student_kecheng_list=new ArrayList<Student_kecheng>();
		
		kecheng_renwu_list=UserService.getKecheng_renwuBykecheng_id(kecheng_id);
		student_kecheng_list=UserService.getStudent_kechengBykecheng_id(kecheng_id);
		
		request.setAttribute("kecheng_renwu_list",kecheng_renwu_list);
		request.setAttribute("student_kecheng_list",student_kecheng_list);
		request.getRequestDispatcher("home/teacher_home_mykecheng_kuang.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
