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
@WebServlet("/Student_xiaoxi")
public class Student_xiaoxi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student_xiaoxi() {
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
		
		List<Tongzhi> tongzhi_list=new ArrayList<Tongzhi>();
		
		tongzhi_list=NewsService.getAllTongzhiBystudent(user.getXuehao());
		
		request.setAttribute("tongzhi_list",tongzhi_list);
		System.out.println(tongzhi_list.size());
		request.getRequestDispatcher("home/student_xiaoxi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
