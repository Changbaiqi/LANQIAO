package lanqiao;

import java.util.Scanner;

public class �����ȫ�������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // ��������
		int N = sc.nextInt(); // ��Ʒ����

		int w[] = new int[N + 1];
		int v[] = new int[N + 1];
		int s[] = new int[N + 1];

		for (int i = 1; i <= N; ++i) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}

		int dp[] = new int[T + 1];
		for (int y = 1; y <= N; ++y) {
			for (int x = w[y]; x <= T; ++x) {
					dp[x] = Math.max(dp[x], dp[x - w[y]] + v[y]);
			}
		}
		System.out.println(dp[T]);

	}

}
