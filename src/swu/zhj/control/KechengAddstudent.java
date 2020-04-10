package swu.zhj.control;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/KechengAddstudent")
public class KechengAddstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KechengAddstudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		
		Teacherusers teacher=(Teacherusers)session.getAttribute("teacher");
		String shen=(String)session.getAttribute("shen");

	       session.setAttribute("teacher",teacher);
	       session.setAttribute("shen",shen);
	       int kecheng_id=Integer.parseInt(request.getParameter("kecheng_id"));
	    String xuehao=request.getParameter("xuehao");
	    Studentusers studentusers=UserService.chauserStudent(xuehao);
	    if(studentusers.getId()!=0) {
	    	boolean flag=NewsService.checkkechengstudent(xuehao,kecheng_id);
	    	if(flag) {  //改学生已经在课程里
	    		out.println("<html>");
				out.println("<head>");
			    out.println("<title>添加失败</title>");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('该学生已经在课程里!');");
				out.println("</script>");
				out.println("</head>");
				out.println("<body>");
				 out.println("<center><a href='Teacher_mykecheng_xiangqin?kecheng_id="+kecheng_id+"'>点击返回到课程页面</a></center>");
				out.println("</body>");
				out.println("</html>");
	    	}else {
	    		boolean flag1=NewsService.addkechengstudent(xuehao,kecheng_id);
	    		if(flag1) { 
	    			 response.sendRedirect("Teacher_mykecheng_xiangqin?kecheng_id="+kecheng_id);
		    	}else {
		    		out.println("<html>");
					out.println("<head>");
				    out.println("<title>添加失败</title>");
					out.println("<script type=\"text/javascript\">");
					out.println("alert('添加失败!');");
					out.println("</script>");
					out.println("</head>");
					out.println("<body>");
					 out.println("<center><a href='Teacher_mykecheng_xiangqin?kecheng_id="+kecheng_id+"'>点击返回到课程页面</a></center>");
					out.println("</body>");
					out.println("</html>");
		    	}
	    	}
	    }else {
	    	out.println("<html>");
			out.println("<head>");
		    out.println("<title>添加失败</title>");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('没有找到该学生!');");
			out.println("</script>");
			out.println("</head>");
			out.println("<body>");
		    out.println("<center><a href='Teacher_mykecheng_xiangqin?kecheng_id="+kecheng_id+"'>点击返回到课程页面</a></center>");
			out.println("</body>");
			out.println("</html>");
	    }
	}

}
