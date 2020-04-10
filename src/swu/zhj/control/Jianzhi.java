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

import swu.zhj.model.Jianzhis;
import swu.zhj.model.Lunbo;
import swu.zhj.service.NewsService;
import swu.zhj.service.TiebaService;
import swu.zhj.util.DividePage;

/**
 * Servlet implementation class Jianzhi
 */
@WebServlet("/Jianzhi")
public class Jianzhi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Jianzhi() {
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
	    String biao=request.getParameter("biao");
	    int recordCount;
		if(biao==null) {
			recordCount=NewsService.getItemCount();  //获得总条数
		}else if(biao.equals("zan")){
		   recordCount=NewsService.getItemCount();  //获得总条数
		}else {
			recordCount=NewsService.getItemCount2();  //获得总条数
		}
		
		
        int currentPage=1;   //当前页是第一页
        String pageNum=request.getParameter("pageNum");
      
        System.out.println(biao);
        if(pageNum!=null){
            currentPage=Integer.parseInt(pageNum);
        }
        DividePage pUtil=new DividePage(5,recordCount,currentPage);
        //获取上下限
        int start=pUtil.getFromIndex();
        int end=pUtil.getToIndex();  
		List<Jianzhis> jianzhi_list=new ArrayList<Jianzhis>();
		if(biao==null) {
		    jianzhi_list=TiebaService.getAllJianzhi(start,end);
		}else if(biao.equals("zan")){
			   jianzhi_list=TiebaService.getAllJianzhiByZan(start,end); 
		}else {
			  jianzhi_list=TiebaService.getAllJianzhiByJing(start,end); 
		}
	    request.setAttribute("jianzhi_list",jianzhi_list);
	    request.setAttribute("pUtil",pUtil);
	    request.getRequestDispatcher("home/index2.jsp").forward(request, response);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
