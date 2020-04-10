
public class Shiyan {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0,n=1,q=0,r=100;double a=0;double top=600;double left;double tem=48;
   for(int m=0;m<=15;m++) {	  
  	  i++;
  	  if(a<=Math.PI/2.0) {top=600-Math.sin(a)*r;}
  	  else if(a>Math.PI/2.0&&a<=Math.PI) {top=600-r+(r-Math.sin(a)*r);}
  	  else if(a>Math.PI){a=0;q=0;n++;tem=tem-n*2;r=r*n;}

  	  left=tem+q*n;
  	  q=q+2;
  	  a=a+(Math.PI/6.0);
  	  System.out.println("("+top+","+left+")"+"--a:"+Math.sin(a)+"--n:"+n+"--");
   	}
  }
}
