package cbq;

import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/5130/learning/?contest_id=144
 * @class DP,��ȫ����
 * @author ������
 *
 */
public class �����㷨�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// ����
		int m = sc.nextInt();// m������ƻ�
		int q = sc.nextInt();// q����������

		// ����
		int dayDis[] = new int[q + 2];

		// ���ռ�õ���һ��
		for (int i = 1; i <= q; ++i)
			dayDis[i] = sc.nextInt();
		
		//������һ��
		dayDis[q + 1] = n + 1;

		int w[] = new int[m];
		int v[] = new int[m];

		// �����Ӧ��ֵ
		for (int i = 0; i < m; ++i) {
			w[i] = (int) Math.pow(2, sc.nextInt());
			v[i] = sc.nextInt();
		}

		long ans = 0;

		for (int i = 1; i <= q + 1; ++i) {
			int dis = dayDis[i] - dayDis[i - 1] - 1;
			ans += slove(dis, w, v);
		}
		System.out.println(ans);

	}

	/**
	 * dp��װ����
	 * 
	 * @param dayDis
	 * @return ������ε�����ֵ
	 */
	static long slove(int dayDis, int w[], int v[]) {
		if(dayDis==0)
			return 0;
		
		long dp[] = new long[dayDis+1];

		for (int y = 0; y < w.length; ++y) {
			for (int i = w[y]; i <= dayDis; ++i) {
				dp[i] = Math.max(dp[i], dp[i - w[y]] + v[y]);
			}
		}
		
		return dp[dayDis];
	}

}
