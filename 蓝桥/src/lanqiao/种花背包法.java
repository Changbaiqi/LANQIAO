package lanqiao;

import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P1077
 * 采用01背包优化
 * @author 长白崎
 *
 */
public class 种花背包法 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //种类
		int m = sc.nextInt(); //数量
		
		int data[] = new int[n+1];
		for(int i= 1 ; i<=n ; ++i) {
			data[i] = sc.nextInt();
		}
		
		
		int dp[] = new int[m+1];
		dp[0] =1;
		int mod = 1000007;
		for(int y = 1; y<=n ; ++y ) {
			for(int x=m; x>=0;--x) {
				for(int i= 1;i<=Math.min(x, data[y]);++i) {
					int res =dp[x]; 
					dp[x] = (res+dp[x-i])%mod;
				}
					
			}
		}
		
		System.out.println(dp[m]);
		
	}

}
