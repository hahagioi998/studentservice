package swu.zhj.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.catalina.core.ApplicationPart;

import swu.zhj.model.Studentusers;
import swu.zhj.model.Teacherusers;
import swu.zhj.service.NewsService;
import swu.zhj.service.UserService;

/**
 * Servlet implementation class Tou
 */
@WebServlet("/Addkecheng_renwu")
@MultipartConfig()     //必须要有这个
public class Addkecheng_renwu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addkecheng_renwu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//根据name，插入img
				response.setContentType("text/html;charset=utf-8");
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				HttpSession session=request.getSession();
				
				Teacherusers teacher=(Teacherusers)session.getAttribute("teacher");
				String shen=(String)session.getAttribute("shen");

			       session.setAttribute("teacher",teacher);
			       session.setAttribute("shen",shen);
			    int kecheng_id=Integer.parseInt(request.getParameter("kecheng_id"));
			    String name=request.getParameter("name");
			    String content=request.getParameter("content");
			    int du=0;
				java.text.SimpleDateFormat formatter=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    	java.util.Date currentTime=new java.util.Date();
		        String time=formatter.format(currentTime);
				boolean flag=NewsService.AddKecheng_renwu1(kecheng_id,time,name,teacher.getId(),du,content);
                if(flag) {
                	response.sendRedirect("Teacher_mykecheng_xiangqin?kecheng_id="+kecheng_id);
				}else {
					System.out.println("失败");
				}
				
	}

}
