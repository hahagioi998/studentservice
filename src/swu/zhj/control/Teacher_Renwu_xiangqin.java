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
@WebServlet("/Teacher_Renwu_xiangqin")
public class Teacher_Renwu_xiangqin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacher_Renwu_xiangqin() {
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
		Kecheng_renwu kecheng_renwu=NewsService.getKechengrenwuByid(renwu_id);
		
		List<Renwu_anser> renwu_anser_list=new ArrayList<Renwu_anser>();
		renwu_anser_list=NewsService.getAnserByRenwu_id1(renwu_id);
		
		request.setAttribute("renwu_anser_list",renwu_anser_list);
		request.setAttribute("kecheng_renwu",kecheng_renwu);
		//System.out.println(lunbo_list.size());
		request.getRequestDispatcher("home/teacher_home_work.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
