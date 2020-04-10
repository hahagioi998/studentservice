package swu.zhj.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shiyan.AddressUtils;
import swu.zhj.service.NewsService;
import swu.zhj.service.TiebaService;
import swu.zhj.service.UserService;
import swu.zhj.util.IPUtil;
import swu.zhj.util.Md5Encrypt;

import swu.zhj.model.*;

/**
 * Servlet implementation class Userlogin
 */
@WebServlet("/Anser")
public class Anser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Anser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Studentusers user=(Studentusers)session.getAttribute("user");
		String shen=(String)session.getAttribute("shen");

	       session.setAttribute("user",user);
	       session.setAttribute("shen",shen);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String anser=request.getParameter("anser");
		int renwu_id=Integer.parseInt(request.getParameter("renwu_id"));
		java.text.SimpleDateFormat formatter=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	java.util.Date currentTime=new java.util.Date();
        String time=formatter.format(currentTime);
        int flag=0;
		boolean flag1=NewsService.InsertRenwuAnser(renwu_id,anser,time,flag,user.getId());
		if(flag1) {
		response.sendRedirect("Student_home_work?renwu_id="+renwu_id);
		}
	   }
}