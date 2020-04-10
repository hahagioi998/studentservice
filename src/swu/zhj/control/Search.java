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
import swu.zhj.model.Bumen_menber;
import swu.zhj.model.Classes;
import swu.zhj.model.Home_data;
import swu.zhj.model.Home_nongchang;
import swu.zhj.model.Home_yin;
import swu.zhj.model.Jianzhis;

import swu.zhj.model.Studentusers;
import swu.zhj.model.Teacherusers;
import swu.zhj.model.Tongzhi;
import swu.zhj.service.NewsService;
import swu.zhj.service.TiebaService;
import swu.zhj.util.DividePage;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
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
		String search=request.getParameter("search");
		String action=request.getParameter("action");
		HttpSession session=request.getSession();
		int id=(Integer)session.getAttribute("id");
		session.setAttribute("id",id);
		String href=null;
		if(action.equals("bumen_baoming")) {
			List<Bumen_baoming> bumen_baoming_list=new ArrayList<Bumen_baoming>();
			bumen_baoming_list=NewsService.getBumen_baomingBySearch(search);
			request.setAttribute("bumen_baoming_list", bumen_baoming_list);
			System.out.println("a");
			href="admin/list2.jsp";
		}
		else if(action.equals("xiaoxi")) {
			List<Tongzhi> tongzhi_list=new ArrayList<Tongzhi>();
			//根据秘书处（name）查询id，赋值给search
			Teacherusers manager=TiebaService.chauserManagerByName(search);
			int bumenid=manager.getId();
			System.out.println(bumenid+"ss");
			tongzhi_list=NewsService.getXiaoxiBySearch(bumenid);
			Bumen_menber bumen_menber=TiebaService.chausermenberById(id);
			Studentusers studentuser=TiebaService.chauserStudentById(id);
			
			request.setAttribute("tongzhi_list",tongzhi_list);
			request.setAttribute("studentuser",studentuser);
			request.setAttribute("bumen_menber",bumen_menber);
			href="home/student_user.jsp";
		}
		else if(action.equals("home_yin")) {
			List<Home_yin> list_home_yin=new ArrayList<Home_yin>();
			list_home_yin=NewsService.getHome_yinBySearch(search);
			request.setAttribute("home_yin_list", list_home_yin);
			href="admin/list2.jsp";
		}
		else if(action.equals("home_data")) {
			List<Home_data> list_home_data=new ArrayList<Home_data>();
			list_home_data=NewsService.getHome_dataBySearch(search);
			request.setAttribute("home_data_list",list_home_data);
			href="admin/list2.jsp";
		}
		else if(action.equals("home_nongchang")) {
			List<Home_nongchang> list_home_nongchang=new ArrayList<Home_nongchang>();
			list_home_nongchang=NewsService.getHome_nongchangBySearch(search);
			request.setAttribute("home_nongchang_list", list_home_nongchang);
			href="admin/list2.jsp";
		}
		else if(action.equals("fudao")) {
			List<Classes> cla_list=new ArrayList<Classes>();
			cla_list=NewsService.getClaBySearch(search);
			request.setAttribute("cla_list", cla_list);
			href="admin/list7.jsp";
		}else if(action.equals("jianzhi")) {
			List<Jianzhis> jianzhi_list=new ArrayList<Jianzhis>();
			jianzhi_list=NewsService.getJianzhiBySearch(search);
			int recordCount=jianzhi_list.size();
			System.out.println("bb"+recordCount);
			int currentPage=1;   //当前页是第一页
		   DividePage pUtil=new DividePage(5,recordCount,currentPage);
		     //获取上下限
		     int start=pUtil.getFromIndex();
		     int end=pUtil.getToIndex();  
		      List<Jianzhis> jianzhi_list1=new ArrayList<Jianzhis>();
		      jianzhi_list1=TiebaService.getAllJianzhiBySearch(search,start,end);
		      request.setAttribute("jianzhi_list", jianzhi_list1);
		      request.setAttribute("pUtil",pUtil);
		      href="home/index2.jsp";
		}
		System.out.println(href);
		  request.getRequestDispatcher(href).forward(request, response);
	}

}