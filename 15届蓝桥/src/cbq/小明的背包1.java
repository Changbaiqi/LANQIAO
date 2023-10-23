package cbq;

import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/1174/learning/
 * @class DP,01背包,背包DP模板
 * @author 长白崎
 *
 */
public class 小明的背包1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int V = sc.nextInt();

		int w[] = new int[N];
		int v[] = new int[N];

		for (int i = 0; i < N; ++i) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}

		int dp[] = new int[V + 1];

		for (int x = 0; x < N; ++x) {
			for (int y = V; y >= w[x]; --y) {
				dp[y] = Math.max(dp[y], dp[y - w[x]] + v[x]);
			}
		}
		
		System.out.println(dp[V]);

	}

}
