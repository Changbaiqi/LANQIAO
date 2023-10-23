package cbq;

import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P1833
 * 
 * @class dp������,��ϱ���
 * @author ������
 *
 */
public class P1833ӣ�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		String ts = sc.next();
		String te = sc.next();

		int tsI = Integer.parseInt(ts.split(":")[0]) * 60 + Integer.parseInt(ts.split(":")[1]);
		int teI = Integer.parseInt(te.split(":")[0]) * 60 + Integer.parseInt(te.split(":")[1]);
		int dif = teI - tsI;

		int n = sc.nextInt();

		int t[] = new int[n];
		int c[] = new int[n];
		int p[] = new int[n];

		for (int i = 0; i < n; ++i) {
			t[i] = sc.nextInt();
			c[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}

		// dp����
		int dp[] = new int[dif + 1];

		for (int i = 0; i < n; ++i) {
			if (p[i] > 0) {
				for(int x = 0 ; x < p[i]; ++x) {
					for (int y = dif; y >= t[i]; --y) {
							dp[y] = Math.max(dp[y], dp[y - t[i]] + c[i]);
					}	
				}
			}else {
				for (int y = t[i]; y <= dif; ++y) {
						dp[y] = Math.max(dp[y], dp[y - t[i]] + c[i]);
				}
			}
		}
		
		System.out.println(dp[dif]);

	}

}
