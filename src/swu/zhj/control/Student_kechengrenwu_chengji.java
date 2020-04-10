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
@WebServlet("/Student_kechengrenwu_chengji")
public class Student_kechengrenwu_chengji extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student_kechengrenwu_chengji() {
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
        Double chengji=Double.parseDouble(request.getParameter("chengji"));
        java.text.SimpleDateFormat formatter=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    java.util.Date currentTime=new java.util.Date();
		String time=formatter.format(currentTime);
	    boolean flag = false;
	    boolean flag1 = false;
	    System.out.println(student_xuehao+renwu_id+time+chengji);
	    flag1=NewsService.Checkkecheng_chengjiExist(student_xuehao,renwu_id);
	    if(flag1) {
	    	NewsService.DelectKecheng_chengjiBystudent_xuehaoandrenwu_id(student_xuehao,renwu_id);
	    }
		flag=NewsService.AddKecheng_chengji(student_xuehao,renwu_id,time,chengji);
		if(flag) {
		  request.setAttribute("student_xuehao",student_xuehao);
		  request.setAttribute("renwu_id",renwu_id);
		//System.out.println(lunbo_list.size());
		  response.sendRedirect("Teacher_work_studentanser?student_xuehao="+student_xuehao+"&renwu_id="+renwu_id);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
