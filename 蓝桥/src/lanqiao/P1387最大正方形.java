package lanqiao;

import java.util.Scanner;

public class P1387最大正方形 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int map[][] =  new int[n+1][m+1];
		
		int dp[][] = new int[n+1][m+1];
		
		int max = 0;
		for(int y=1 ; y <= n ; ++y) {
			for(int x = 1 ;x <= m ; ++x) {
				map[y][x] = sc.nextInt();
				if(map[y][x]==1) dp[y][x] = Math.min(Math.min(dp[y][x-1], dp[y-1][x]), dp[y-1][x-1])+1;
				max = Math.max(max, dp[y][x]);
			}
		}
		System.out.println(max);
		
	}

}
