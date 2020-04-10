package swu.zhj.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import swu.zhj.model.News;
import swu.zhj.service.NewsService;

/**
 * Servlet implementation class AddNews
 */
@WebServlet("/AddNews")
public class AddNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNews() {
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
		request.setCharacterEncoding("utf-8");
		String title=request.getParameter("title");
		String category=request.getParameter("parenttitle");
		String content=request.getParameter("content");
		java.text.SimpleDateFormat formatter=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date currentTime=new java.util.Date();
		String fb_time=formatter.format(currentTime);
		String author="admin";
		boolean flag=NewsService.addNews(title,category,content,fb_time,author);
		if(flag){
			News news=new News();
			news.setTitle(title);
			news.setAuthor(author);
			news.setCategory(category);
			news.setContent(content);
			news.setFb_time(fb_time);
			
			HttpSession session=request.getSession();
			session.setAttribute("news", news);
			                                                                                                                                                                                                   
			response.sendRedirect("admin/view.jsp");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
		}
		else{
			response.sendRedirect("admin/addnews.jsp");
		}
	}

}
