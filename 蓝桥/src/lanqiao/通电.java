package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class ͨ?? {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int x[] = new int[n+1];
		int y[] = new int[n+1];
		int h[] = new int[n+1];
		
		for(int i = 1 ; i <= n ; ++i) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
			h[i] = sc.nextInt();
		}
		
		System.out.printf("%.2f",prim(x,y,h));
		
		
	}
	
	
	
	public static double prim(int x[],int y[],int h[]) {
		
		boolean select[] = new boolean[x.length];
		double mindist[] = new double[x.length];
		int parent[] = new int[x.length];
		
		select[1] = true;
		
		//??ʼ??
		Arrays.fill(mindist, Float.MAX_VALUE);
		
		
		//int latePoint = 1;
		for(int i = 1 ,point=1; i < x.length ; ++i) {
			int minpoint=0;
			double min = Double.MAX_VALUE;	
			for(int z = 1 ;z < x.length ; ++z){
				if(select[z])
					continue;
				double resDis =money(x[point],y[point],h[point],x[z],y[z],h[z]);
				if(mindist[z] > resDis) {
					mindist[z] = resDis;
					parent[z] = point;
				}
				if(min> mindist[z]) {
					minpoint = z;
					min = mindist[z];
				}
			}
			
			if(point!=0) {
				select[minpoint] = true;
				int res = point;
				point = minpoint;
				parent[minpoint]=res;
				
			}
		}
		
		double ans = 0;
		for(int i = 2; i < x.length ; ++i) {
			ans+=mindist[i];
		}
		return ans;
	}
	
	
	public static double money(int x_1,int y_1,int h_1,int x_2,int y_2,int h_2) {
		return (Math.sqrt(Math.pow(x_1-x_2, 2)+Math.pow(y_1-y_2, 2))+Math.pow(h_1-h_2, 2));
	}

}
