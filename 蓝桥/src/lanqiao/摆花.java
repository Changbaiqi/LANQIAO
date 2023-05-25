package lanqiao;

import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P1077
 * @author 长白崎
 *
 */
public class 摆花 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //花的种类
		int m = sc.nextInt(); //一共需要摆放多少盆花
		
		int data[] = new int[n+1];
		for(int i=1 ; i <=n ; ++i) {
			data[i] = sc.nextInt();
		}
		
		
		int dp[][] = new int[n+1][m+1];
		dp[0][0] = 1;
		
		int mod = 1000007;
		for(int y =1 ;y<=n ; ++y ) {
			for(int x= 0; x<=m;++x) {
				for(int i=0; i<=Math.min(x, data[y]);++i)
					dp[y][x] =(dp[y][x]+dp[y-1][x-i])%mod;
			}
		}
		
		System.out.println(dp[n][m]);
		
	}

}
