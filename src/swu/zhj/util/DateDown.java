package swu.zhj.util;

import java.util.Calendar;
import java.util.Date;

public class DateDown {
    //倒计时，返回剩余时间
	static int time = 60 * 60 * 60;
    static Calendar c;
    static long endTime;
    static Date date;
    static long startTime;
    static long midTime;
	  private static void time1() {
		    c = Calendar.getInstance();
		    c.set(2019, 3,22, 19, 0, 0);// 注意月份的设置，0-11表示1-12月
		    endTime = c.getTimeInMillis();
		    date = new Date();
		    startTime = date.getTime();
		    midTime = (endTime - startTime) / 1000;
	        while (time > 0) {
		         time--;
		        try {
		          Thread.sleep(1000);
		          int hh = time / 60 / 60 % 60;
		          int mm = time / 60 % 60;
		          int ss = time % 60;
		       System.out.println("还剩" + hh + "小时" + mm + "分钟" + ss + "秒");
		     } catch (InterruptedException e) {
		         e.printStackTrace();
		     }
	    }
	  }
}
