package cbq;

import java.util.Scanner;
/**
 * https://www.acwing.com/problem/content/2/
 * @author 长白崎
 * @class ["01背包"]
 *
 */
public class 背包问题01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int V= sc.nextInt();
		
		int v[] = new int[N+1];
		int w[] = new int[N+1];
		
		for(int i = 1;i<=N;++i) {v[i]=sc.nextInt();w[i] = sc.nextInt();}
		
		
		int dp[] = new int[V+1];
		
		for(int i = 1;i<=N;++i) {
			for(int j=V;j>=v[i];--j) {
				dp[j] = Math.max(dp[j], dp[j-v[i]]+w[i]);
			}
		}
		System.out.println(dp[V]);
		
	}

}
