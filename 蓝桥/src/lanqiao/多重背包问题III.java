package lanqiao;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/6/
 * 
 * @author 长白崎
 *
 */
public class 多重背包问题III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub、
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int V = sc.nextInt();

		int w[] = new int[N + 1];
		int v[] = new int[N + 1];
		int s[] = new int[N + 1];

		for (int i = 1; i <= N; ++i) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
			s[i] = sc.nextInt();
		}

		int dp[] = new int[V + 1];

		for (int y = 1; y <= N; ++y) {

			int ans = 1;
			int z = 1;
			for (; ans <= s[y]; ans += (z *= 2)) {
				for (int x = V; x >= w[y] * z; --x) {
					dp[x] = Math.max(dp[x], dp[x - w[y] * z] + v[y] * z);
				}
			}
			z = s[y] - (ans - z);
			if (ans > s[y])
				for (int x = V; x >= w[y] * z; --x) {
					dp[x] = Math.max(dp[x], dp[x - w[y] * z] + v[y] * z);
				}
		}
		System.out.println(dp[V]);

	}

}
