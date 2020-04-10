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
import swu.zhj.model.Studentusers;
import swu.zhj.model.Teacherusers;
import swu.zhj.model.Tongzhi;
import swu.zhj.service.NewsService;
import swu.zhj.service.UserService;

/**
 * Servlet implementation class ListStudentUser
 */
@WebServlet("/Student_xiaoxi_xiangqin")
public class Student_xiaoxi_xiangqin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student_xiaoxi_xiangqin() {
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
		
	       int xiaoxi_id=Integer.parseInt(request.getParameter("xiaoxi_id"));
	       NewsService.updateTongzhiById(xiaoxi_id);
		Tongzhi tongzhi=NewsService.getTongzhiById(xiaoxi_id);
		
		request.setAttribute("tongzhi",tongzhi);
		request.getRequestDispatcher("home/student_xiaoxi_xiangqin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
