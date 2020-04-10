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

import swu.zhj.model.Bumen_baoming;
import swu.zhj.model.Home_data;
import swu.zhj.model.Home_nongchang;
import swu.zhj.model.Home_yin;
import swu.zhj.model.Lunbo;
import swu.zhj.model.Shetuan_baoming;
import swu.zhj.service.NewsService;
import swu.zhj.service.UserService;

/**
 * Servlet implementation class Xiaonei
 */
@WebServlet("/Xiaonei")
public class Xiaonei extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Xiaonei() {
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
		int id=(Integer)session.getAttribute("id");
		session.setAttribute("id",id);
		
		List<Lunbo> lunbo_list=new ArrayList<Lunbo>();
		List<Bumen_baoming> bumen_baoming_list=new ArrayList<Bumen_baoming>();
		List<Shetuan_baoming> shetuan_baoming_list=new ArrayList<Shetuan_baoming>();
		List<Home_nongchang> home_nongchang_list=new ArrayList<Home_nongchang>();
		List<Home_data> home_data_list=new ArrayList<Home_data>();
		List<Home_yin> home_yin_list=new ArrayList<Home_yin>();
		bumen_baoming_list=UserService.getBumen_baomingBystudent_id(id);
		shetuan_baoming_list=UserService.getShetuan_baomingBystudent_id(id);
		lunbo_list=NewsService.getAllLunbo();
		home_nongchang_list=NewsService.getAllHome_nongchang();
		home_data_list=NewsService.getAllHome_data();
		home_yin_list=NewsService.getAllHome_yin();
		request.setAttribute("lunbo_list",lunbo_list);
		request.setAttribute("home_nongchang_list",home_nongchang_list);
		request.setAttribute("home_data_list",home_data_list);
		request.setAttribute("home_yin_list",home_yin_list);
		request.setAttribute("bumen_baoming_list",bumen_baoming_list);
		request.setAttribute("shetuan_baoming_list",shetuan_baoming_list);
		//System.out.println(lunbo_list.size());
		
		request.getRequestDispatcher("home/xiaonei.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
