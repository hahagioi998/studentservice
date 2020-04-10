package swu.zhj.control;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.catalina.core.ApplicationPart;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import swu.zhj.model.Home_data;
import swu.zhj.model.News;
import swu.zhj.service.NewsService;
import swu.zhj.service.UserService;

/**
 * Servlet implementation class UpdateNews
 */
@WebServlet("/UpdateNews")
public class UpdateNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNews() {
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
		String action=request.getParameter("action");
		HttpSession session=request.getSession();
		int id=(Integer)session.getAttribute("id");
		session.setAttribute("id",id);
		int jianzhi_id=(Integer)session.getAttribute("jianzhi_id");
		if(action.equals("news")) {
			String title=request.getParameter("title");
			String category=request.getParameter("parenttitle");
			String content=request.getParameter("content");
			boolean flag=NewsService.updateNews(jianzhi_id,title,category,content);
		    if(flag){
				response.sendRedirect("ListJianzhi");
		    }
		    else{
		    	response.sendRedirect("admin/err.jsp");
		    }
		}
		else if(action.equals("lunbo")) {
			String title=request.getParameter("title");
			String image=request.getParameter("image");
			String content=request.getParameter("content");
			boolean flag=NewsService.updateLunbo(jianzhi_id,title,image,content);
		    if(flag){
				response.sendRedirect("admin/mian.jsp");
		    }
		    else{
		    	response.sendRedirect("admin/err.jsp");
		    }	
		}
		else if(action.equals("home_yin")) {
			String title=request.getParameter("title");
			String jian=request.getParameter("jian");
			String image=request.getParameter("image");
			String adr=request.getParameter("adr");
			String phone=request.getParameter("phone");
			boolean flag=NewsService.updateHome_yin(jianzhi_id,title,jian,image,adr,phone);
		    if(flag){
				response.sendRedirect("admin/mian.jsp");
		    }
		    else{
		    	response.sendRedirect("admin/err.jsp");
		    }
		}
		else if(action.equals("home_data")) {
			int max_data=Integer.parseInt(request.getParameter("max_data"));
			String content=request.getParameter("content");
			boolean flag=NewsService.updateHome_data(jianzhi_id,max_data,content);
		    if(flag){
				response.sendRedirect("admin/mian.jsp");
		    }
		    else{
		    	response.sendRedirect("admin/err.jsp");
		    }
		}
		else if(action.equals("home_nongchang")) {
			String title=request.getParameter("title");
			String image=request.getParameter("image");
			String content=request.getParameter("content");
			boolean flag=NewsService.updateHome_nongchang(jianzhi_id,title,image,content);
		    if(flag){
				response.sendRedirect("admin/mian.jsp");
		    }
		    else{
		    	response.sendRedirect("admin/err.jsp");
		    }	
		}
		else if(action.equals("gamelei")) {
			String lei=request.getParameter("lei");
			String name1=request.getParameter("name1");
			String name2=request.getParameter("name2");
			String name3=request.getParameter("name3");
			String name4=request.getParameter("name4");
			
			boolean flag=NewsService.updateGamelei(jianzhi_id,lei,name1,name2,name3,name4);
		    if(flag){
				response.sendRedirect("admin/mian.jsp");
		    }
		    else{
		    	response.sendRedirect("admin/err.jsp");
		    }
		}	
		else if(action.equals("jianzhi")) {
			String image=null;
			String title = null;
			String href=null;
			String content=null;
		    String path = request.getContextPath();
            DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
		      //构建一个文件上传类
		    ServletFileUpload servletFileUpload=new ServletFileUpload(diskFileItemFactory);
		    //设置上传文件的大小
		    servletFileUpload.setFileSizeMax(3*1024*1024);
		    servletFileUpload.setSizeMax(6*1024*1024);//文件总大小6mb
		    List<FileItem> list=null;   //所有的input提交，所有返回的是一个li
		    try {
		        //解析request请求
		        list=servletFileUpload.parseRequest(request);
		        //取出所有表单的值,判断非文本字段和文本字段
		        for(FileItem fileItem:list){
		          if(fileItem.isFormField()){
		            if(fileItem.getFieldName().equals("title")){
		            	title=fileItem.getString("utf-8");
		            	System.out.println("1"+title);
		             }  //判断
		            else if(fileItem.getFieldName().equals("href")){
		        	   href=fileItem.getString("utf-8");
		        	   System.out.println("2"+href);
		            }
		            else if(fileItem.getFieldName().equals("content")){
		        	   content=fileItem.getString("utf-8");
		        	   System.out.println("3"+content);
		           }
		         }else{ //不是文本表单
		              try {//真实名称
		                 image=fileItem.getName();   //获得文件名称
		                 //服务器端路径
		                 String upload_path=request.getRealPath("/upload");
		                 System.out.println("--->"+upload_path);
		                  //加起来就是引用文件,实现文件上传到upload，而数据库里是路径
		                  File real_path=new File(upload_path+"/"+image);
		                 fileItem.write(real_path);
		                System.out.println(upload_path+"/"+image+"mm");
		                System.out.println(title+href+content+"xx");
		           
		                } catch (Exception e) {
		                   e.printStackTrace();
		                }
		              }
		            }
		        boolean flag=NewsService.updateJianzhi(jianzhi_id,title,href,content,"upload/"+image);
	             if(flag){
	               	response.sendRedirect("admin/mian.jsp");
	             }
	            	 else{
	            		response.sendRedirect("admin/err.jsp");
	            	  }
		        } catch (FileUploadException e) {
		            e.printStackTrace();
		        }
			
		}	
	}

}
