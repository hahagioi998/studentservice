package swu.zhj.control;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import swu.zhj.model.Admin;
import swu.zhj.model.Kecheng;
import swu.zhj.model.Kecheng_renwu;
import swu.zhj.model.Studentusers;
import swu.zhj.model.Teacherusers;
import swu.zhj.service.NewsService;
import swu.zhj.service.TiebaService;
import swu.zhj.service.UserService;
import swu.zhj.util.SendqqMail;

/**
 * Servlet implementation class Send
 */
@WebServlet("/Send")
public class Send extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Send() {
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
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		
		String action=request.getParameter("action");
		String method=request.getParameter("method");
        if(action.equals("fudao")) {
        	Admin admin=(Admin)session.getAttribute("admin");
    		String shen=(String)session.getAttribute("shen");

    	       session.setAttribute("admin",admin);
    	       session.setAttribute("shen",shen);
        	//得到cla_id[]，循环取出id,在
        	String cla_ids[] = request.getParameterValues("tongzhi");
     
    		int teacher_id=(Integer)session.getAttribute("id");
    		String teacher_name=TiebaService.chauserTeacherById(teacher_id).getName();
   
    		String content=request.getParameter("content");
    	    java.text.SimpleDateFormat formatter=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	    java.util.Date currentTime=new java.util.Date();
    		String fb_time=formatter.format(currentTime);
    	    boolean flag = false;
    		for(int i=0;i<cla_ids.length;i++) {
    			System.out.println(cla_ids[i]+"sss");
    			if(method.equals("zhannei")) {
    			  flag=NewsService.TeacherSendstudent(teacher_id,Integer.parseInt(cla_ids[i]),content,fb_time);
    			}else {
    			     //qq邮件方式，两个的qq
    				int student_ids[]=TiebaService.getAllstudent_idBycla_id(Integer.parseInt(cla_ids[i]));
    				for(int j=0;j<student_ids.length;j++) {		
    			  	   String student_qq=TiebaService.chauserStudentById(student_ids[j]).getQq();
    				   student_qq=student_qq+"@qq.com";
    				   String title=teacher_name+"发来通知:";
    				   try {
    					  SendqqMail.send(student_qq,content,title);
    				   } catch (MessagingException | GeneralSecurityException e) {
    					// TODO Auto-generated catch block
    					  e.printStackTrace();
    			       }
    				}
    		      }
    			}
    		response.sendRedirect("ListCla");
        }else if(action.equals("student")) {
        	Admin admin=(Admin)session.getAttribute("admin");
    		String shen=(String)session.getAttribute("shen");

    	       session.setAttribute("admin",admin);
    	       session.setAttribute("shen",shen);
		String xuehaos[] = request.getParameterValues("tongzhi");
		String sender=admin.getXuehao();
		
		//int student_id=Integer.parseInt(request.getParameter("student_id"));
       // System.out.println(bumen_id+"--"+student_id);
        String content=request.getParameter("content");
        String title=request.getParameter("title");
        java.text.SimpleDateFormat formatter=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date currentTime=new java.util.Date();
		String fb_time=formatter.format(currentTime);
		boolean flag = false;
		for(int i=0;i<xuehaos.length;i++) {
			System.out.println(xuehaos[i]);
			if(method.equals("zhannei")) {
				   flag=NewsService.AdminSendstudent(sender,xuehaos[i],content,fb_time,title);
				}else {
					//qq邮件方式，两个的qq
					String student_qq=UserService.chauserStudent(xuehaos[i]).getQq();
				    String manager_name=admin.getName();
					student_qq=student_qq+"@qq.com";
				    title=manager_name+"发来通知:";
					 try {
					     SendqqMail.send(student_qq,content,title);
						} catch (MessagingException | GeneralSecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				 }
	     	}
		response.sendRedirect("ListStudentUser");
        }
		else if(action.equals("teacher")) {
			Admin admin=(Admin)session.getAttribute("admin");
			String shen=(String)session.getAttribute("shen");

		       session.setAttribute("admin",admin);
		       session.setAttribute("shen",shen);
			String xuehaos[] = request.getParameterValues("tongzhi");
			String sender=admin.getXuehao();
			
			//int student_id=Integer.parseInt(request.getParameter("student_id"));
	       // System.out.println(bumen_id+"--"+student_id);
	        String content=request.getParameter("content");
	        String title=request.getParameter("title");
	        java.text.SimpleDateFormat formatter=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date currentTime=new java.util.Date();
			String fb_time=formatter.format(currentTime);
			boolean flag = false;
			for(int i=0;i<xuehaos.length;i++) {
				System.out.println(xuehaos[i]);
				if(method.equals("zhannei")) {
					   flag=NewsService.AdminSendstudent(sender,xuehaos[i],content,fb_time,title);
					}else {
						//qq邮件方式，两个的qq
						String teacher_qq=UserService.chauserTeacher(xuehaos[i]).getQq();
					    String manager_name=admin.getName();
					    teacher_qq=teacher_qq+"@qq.com";
						title=manager_name+"发来通知:";
						 try {
						     SendqqMail.send(teacher_qq,content,title);
							} catch (MessagingException | GeneralSecurityException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					 }
			}
			response.sendRedirect("ListTeacherUser");
		}else if(action.equals("teachersendstudent")) {
			Teacherusers teacher=(Teacherusers)session.getAttribute("teacher");
			String shen=(String)session.getAttribute("shen");

			session.setAttribute("teacher",teacher);
		    session.setAttribute("shen",shen);
		    int renwu_id=Integer.parseInt(request.getParameter("renwu_id"));
	        int kecheng_id=Integer.parseInt(request.getParameter("kecheng_id"));
	        Kecheng_renwu kecheng_renwu=NewsService.getKechengrenwuByid(renwu_id);
	        Kecheng kecheng=NewsService.getKechengBykecheng_id(kecheng_id);
			String xuehaos[] = request.getParameterValues("tongzhi");
			String sender=teacher.getXuehao();
	        String content=teacher.getName()+"提醒你完成"+kecheng.getKe_name()+"的"+kecheng_renwu.getName()+"作业";
	        String title="作业提醒";
	        java.text.SimpleDateFormat formatter=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date currentTime=new java.util.Date();
			String fb_time=formatter.format(currentTime);
			boolean flag = false;
			for(int i=0;i<xuehaos.length;i++) {
				System.out.println(xuehaos[i]);
				if(method.equals("zhannei")) {
					   flag=NewsService.AdminSendstudent(sender,xuehaos[i],content,fb_time,title);
					}else {
						//qq邮件方式，两个的qq
						String student_qq=UserService.chauserStudent(xuehaos[i]).getQq();
					    String teacher_name=teacher.getName();
					    student_qq=student_qq+"@qq.com";
						title=teacher_name+"发来通知:";
						 try {
						     SendqqMail.send(student_qq,content,title);
							} catch (MessagingException | GeneralSecurityException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					 }
			}
			response.sendRedirect("Weiwanchengstudent?renwu_id="+renwu_id+"&kecheng_id="+kecheng_id);
		}
	}

}
