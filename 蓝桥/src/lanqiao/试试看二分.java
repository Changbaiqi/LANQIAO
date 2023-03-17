package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class 试试看二分 {

	public static void main(String[] args) {
		 
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 0; i< T ; ++i) {
			int n = sc.nextInt(); //物品数量
			int k = sc.nextInt(); //
			
			int value[] = new int[n];
			int weight[] = new int[n];
			
			
			
			for(int x= 0 ; x <n ; ++x) {
				weight[x] = sc.nextInt();
				value[x] = sc.nextInt();
			}
			
			
			double l = 0,r=1e11,mid;
			while(r-l>0.00001) {
				mid = (l+r)/2.0;
				if(check(mid,k,value,weight))
					l = mid;
				else
					r =mid;
			}
			System.out.printf("%.2f\n",l);
			
			
			
		}
		
							
		
	}
	
	public static boolean check(double mid,int k,int value[],int weight[]) {
		
		Double c[] = new Double[value.length];
		
		double ss = 0 ;
		for(int i = 0; i < value.length ; ++i) {
			c[i] = value[i]*1.0 - weight[i]*mid;
			//System.out.printf("%f ",c[i]);
		}
		Arrays.sort(c,(x,y)->(int)(y*1000-x*1000));
		//System.out.println(Arrays.toString(c));
		for(int i = 0; i < k ; ++i) {
			ss+=c[i];
		}
		
		if(ss>=0)
			return true;
		
		
		return false;
	}

}
