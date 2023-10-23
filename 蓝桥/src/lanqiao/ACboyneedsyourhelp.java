package lanqiao;

import java.util.Scanner;

public class ACboyneedsyourhelp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//while()
		int N = sc.nextInt(); //可选N门课
		int M = sc.nextInt(); //只想学M天
		
		int A[][] = new int[N+1][M+1]; //第i门课学习a天能得的分数
		for(int i =1; i <=N ; ++i) {
			
			int a = sc.nextInt(); //学习a天
			int b = sc.nextInt();//学习a天所能得到的分数
			A[i][a] = b; 
		}
		
		//开始DP
		
		int dp[]= new int[M+1];
		
		for(int y = 1 ; y <=N ; ++y) {
			for(int x=M ; x>=1 ; --x) {
				for(int i = 1 ; i<=M ; ++i) {
					if(x>=i)
						dp[x] = Math.max(dp[x], dp[x-i]+A[y][i]);
				}
			}
		}
		
		
		
		
	}

}
