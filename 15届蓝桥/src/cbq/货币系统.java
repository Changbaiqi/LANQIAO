package cbq;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/1373/
 * @author 长白崎
 * @class["DP","背包问题"]
 */
public class 货币系统 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();

		int n = sc.nextInt();

		int arr[] = new int[v + 1];
		for (int i = 1; i <= v; ++i) {
			arr[i] = sc.nextInt();
		}

		long dp[] = new long[n + 1];
		dp[0] = 1;
		for (int j = 1; j <= v; ++j) {
			for (int i = arr[j]; i <= n; ++i) {
				dp[i] = Math.max(dp[i]+dp[i-arr[j]], dp[i]);
			}
		}
		System.out.println(dp[n]);
	}

}
