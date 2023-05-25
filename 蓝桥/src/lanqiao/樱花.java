package lanqiao;

import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P1833
 * @author ������
 *
 */
public class ӣ�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int tts = 0;
		int tte = 0;
		int dis = 0;

		String Ts = sc.next();
		tts = Integer.parseInt(Ts.split(":")[0]) * 60 + Integer.parseInt(Ts.split(":")[1]);
		String Te = sc.next();
		tte = Integer.parseInt(Te.split(":")[0]) * 60 + Integer.parseInt(Te.split(":")[1]);
		dis = tte - tts;
		int n = sc.nextInt();

		int w[] = new int[n + 1];
		int v[] = new int[n + 1];
		int s[] = new int[n + 1];
		for (int i = 1; i <= n; ++i) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
			s[i] = sc.nextInt();
		}

		int dp[] = new int[dis + 1];

		for (int y = 1; y <= n; ++y) {
			if (s[y] > 0) {
				int i = 1;
				int res = 1;
				for (; i <= s[y]; i += (res *= 2)) {
					for (int x = dis; x >= 1; --x) {
						if (x - (w[y] * res) >= 0)
							dp[x] = Math.max(dp[x], dp[x - (w[y] * res)] + (res * v[y]));
					}
				}
				if (i - s[y] > 0) {
					res = s[y] - (i - res);
					for (int x = dis; x >= 1; --x) {
						if (x - (w[y] * res) >= 0)
							dp[x] = Math.max(dp[x], dp[x - (w[y] * res)] + (res * v[y]));
					}
				}
			} else {
				for (int x = 1; x <= dis; ++x) {
					if (x - w[y] >= 0)
						dp[x] = Math.max(dp[x], dp[x - w[y]] + v[y]);
				}
			}
		}
		System.out.println(dp[dis]);

	}

}
