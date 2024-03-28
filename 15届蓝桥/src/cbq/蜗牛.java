package cbq;

import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/4985/learning/
 * @author 长白崎
 * @class ["dp"]
 */
public class 蜗牛 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] =  new int[n+1];
		int start[] = new int[n];
		int end[] = new int[n];
		for(int i =1;i<=n;++i) {
			arr[i] = sc.nextInt();
		}
		
		for(int i= 1;i<=n-1;++i) {
			start[i] = sc.nextInt();
			end[i] = sc.nextInt();
		}
		
	    double dp[][] = new double[n+1][3]; //1为倒en1点，2为倒底部
	    
		for(int i = 1;i<=n;++i) {
			
			double en1_st1_en2 = i-2>=0?(end[i-2]>start[i-1]?(end[i-2]-start[i-1])/1.3 : (start[i-1]-end[i-2])/0.7):(arr[i]-arr[i-1]+end[i-1]/0.7);
			double en1_i1_i2 = (i-2>=0?end[i-2]/1.3:0)+(arr[i]-arr[i-1]);
			double i1_st1_en2 = i-1!=0?start[i-1]/0.7:arr[i]-arr[i-1];
			double i1_st1_en2_i2 = i-1!=0?start[i-1]/0.7 + (end[i-1]/1.3):arr[i]-arr[i-1];
			double i1_i2 = arr[i]-arr[i-1];
			dp[i][1] = Math.min(en1_st1_en2, i1_st1_en2)+dp[i-1][1];
			dp[i][2] = Math.min(Math.min(en1_i1_i2, i1_st1_en2_i2), i1_i2)+dp[i-1][2];
			
		}
		System.out.printf("%.2f",dp[n][2]);
	}

}
