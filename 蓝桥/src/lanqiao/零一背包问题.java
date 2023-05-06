package lanqiao;

import java.util.Scanner;

public class 零一背包问题 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		
		//N件物品
		int N = sc.nextInt();
		//V容量
		int V = sc.nextInt();
		
		
		//物品重量
		int w[] = new int[N+1];
		//物品价值
		int v[] = new int[N+1];
		
		for(int i = 1 ; i <=N ; ++i) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		
		//dp函数
		int dp[][] = new int[N+1][V+1];
		
		//容量
		for(int i= 1 ; i <= V ; ++i) {
			//物品
			for(int j = 1 ; j <= N ; ++j) {
				if(w[j]>i)
					dp[j][i] = dp[j-1][i];
				else {
					dp[j][i] = Math.max(v[j]+ dp[j-1][i-w[j]],dp[j-1][i]);
				}
			}
		}
		System.out.println(dp[N][V]);
		
		
	}

}
