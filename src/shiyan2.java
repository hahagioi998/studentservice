import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class shiyan2 {
	public static int time = 60 * 60 * 60;
    public static Calendar c;
	public static long endTime;
	public static Date date;
	public static long startTime;
	public static long midTime;
	public static void main(String[] args) {
		   c = Calendar.getInstance();
		   c.set(2019, 3,22, 19, 0, 0);// ע���·ݵ����ã�0-11��ʾ1-12��
		    endTime = c.getTimeInMillis();
		    date = new Date();
		    startTime = date.getTime();
		    midTime = (endTime - startTime) / 1000;
		    //time1();//��ʽһ
		     //time2();// ��ʽ��
		      time3();//��ʽ��
		 }
	   /**
		   * ��ʽ���� ʹ��java.util.Timer����е���ʱ
		    */
		  private static void time3() {
		   Timer timer = new Timer();
		    timer.schedule(new TimerTask() {
		      public void run() {
		         midTime--;
		        long hh = midTime / 60 / 60 % 60;
		        long mm = midTime / 60 % 60;
		        long ss = midTime % 60;
		         System.out.println("��ʣ" + hh + "Сʱ" + mm + "����" + ss + "��");
		     }
		    }, 0, 1000);
	  }
	    /**
		    * ��ʽ���� �趨ʱ���������ʱ
	     */
		   private static void time2() {
	    while (midTime > 0) {
		         midTime--;
		         long hh = midTime / 60 / 60 % 60;
	       long mm = midTime / 60 % 60;
		       long ss = midTime % 60;
		       System.out.println("��ʣ" + hh + "Сʱ" + mm + "����" + ss + "��");
		        try {
		          Thread.sleep(1000);
		      } catch (InterruptedException e) {
		            e.printStackTrace();
		       }
		      }
	  }
	
	   /**
		   * ��ʽһ�� ����ʱ������ʱ
	      */
	   private static void time1() {
	       while (time > 0) {
		         time--;
		        try {
		          Thread.sleep(1000);
		          int hh = time / 60 / 60 % 60;
		          int mm = time / 60 % 60;
		          int ss = time % 60;
		       System.out.println("��ʣ" + hh + "Сʱ" + mm + "����" + ss + "��");
		     } catch (InterruptedException e) {
		         e.printStackTrace();
		     }
		    }
	   }
}
