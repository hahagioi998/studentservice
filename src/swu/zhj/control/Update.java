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

import swu.zhj.model.Home_data;
import swu.zhj.model.Home_nongchang;
import swu.zhj.model.Home_yin;
import swu.zhj.model.Jianzhis;
import swu.zhj.model.Lunbo;
import swu.zhj.model.News;
import swu.zhj.service.NewsService;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		int id=(Integer)session.getAttribute("id");
		session.setAttribute("id",id);
		int jianzhi_id=Integer.parseInt(request.getParameter("jianzhi_id"));
		String action=request.getParameter("action");
		if(action.equals("news")) {
			List<News> news=new ArrayList<News>();
			news=NewsService.getNewsById(jianzhi_id);
			session.setAttribute("news", news);
			System.out.println("a");
		}
		else if(action.equals("lunbo")) {
			List<Lunbo> lunbo=new ArrayList<Lunbo>();
			lunbo=NewsService.getLunboById(jianzhi_id);
			session.setAttribute("lunbo", lunbo);
			System.out.println("b");
		}
		else if(action.equals("home_yin")) {
			
			List<Home_yin> home_yin=new ArrayList<Home_yin>();
			home_yin=NewsService.getHome_yinById(jianzhi_id);
			session.setAttribute("home_yin", home_yin);	
		}
		else if(action.equals("home_data")) {
			List<Home_data> home_data=new ArrayList<Home_data>();
			home_data=NewsService.getHome_dataById(jianzhi_id);
			session.setAttribute("home_data", home_data);
		}
		else if(action.equals("home_nongchang")) {
			List<Home_nongchang> home_nongchang=new ArrayList<Home_nongchang>();
			home_nongchang=NewsService.getHome_nongchangById(jianzhi_id);
			session.setAttribute("home_nongchang", home_nongchang);	
		}
		else if(action.equals("jianzhi")) {
			List<Jianzhis> jianzhi=new ArrayList<Jianzhis>();
			jianzhi=NewsService.getJianzhiById(jianzhi_id);
			session.setAttribute("action",action);
			session.setAttribute("jianzhi_id",jianzhi_id);
			session.setAttribute("jianzhi", jianzhi);
		}
		session.setAttribute("action",action);
		session.setAttribute("jianzhi_id",jianzhi_id);
		response.sendRedirect("admin/update.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
