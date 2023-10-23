package cbq;

import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P1077
 * @class dp，混合背包dp，线性dp
 * @author 长白崎
 *
 */
public class P1077NOIP2012普及组摆花 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int data[] = new int[n];

		for (int i = 0; i < n; ++i) {
			data[i] = sc.nextInt();
		}

		int dp[] = new int[m + 1];

		dp[0] = 1;
		for (int x = 0; x < n; ++x) {
			for (int i = m; i >= 1; --i) {
				for(int y=1; y<= Math.min(i, data[x]);++y) {
					dp[i] = (dp[i]+dp[i-y])%((int)1e6+7);
				}
			}
		}
		
		System.out.println(dp[m]);
	}

}
