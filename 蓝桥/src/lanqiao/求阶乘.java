package lanqiao;

import java.util.Scanner;

public class 求阶乘 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Long.MAX_VALUE);
		Scanner sc = new Scanner(System.in);
		
		//calc(sc.nextInt());
		
		System.out.println(calc_1(100000000));
	}
	
	   
	
	public static long calc_1(int N) {
		
		
		
		//二分法
		
		long l = 1;
		long r = Long.MAX_VALUE-5;
		                                                                                                           
		
		while(l<r) {
			
			long mid = (l+r)/2;
			
			if(calc_2( mid ) >=N)
				r= mid;
			else {
				l = mid+1;
			}
			                   
			
		}
		
		  if(calc_2(l)!=N)
			  return  -1;
		  else
			  return l;
	}
	
	
	//用来统计有多少个0
	public static long calc_2(long num) {
		
		//计算有多少个5
		long sun = 0;
		
 		while(num!=0) {
			sun +=( num/=5);
		}
		return sun;
	}
	
	
   
}
 