package cbq;

import java.util.Scanner;
/**
 * https://www.acwing.com/problem/content/1229/
 * @author ������
 * @class ���֡�ö��
 *
 */
public class ���ɿ���1227 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // N���ɿ���
		int K = sc.nextInt(); // KλС����

		int H[] = new int[N];
		int W[] = new int[N];

		for (int i = 0; i < N; ++i) {
			H[i] = sc.nextInt();
			W[i] = sc.nextInt();
		}

		int l = 1, r = 100001, mid = 0;
		//���ұ�ģ��
		while (l < r) {
			mid = (l + r+1) >> 1;
			if (check(H, W, N, K, mid)) {
				l = mid;
			} else {
				r = mid - 1;
			}
		}
		System.out.println(r);
	}

	/**
	 * ����check����
	 * @param H
	 * @param W
	 * @param N
	 * @param K
	 * @param mid
	 * @return
	 */
	static boolean check(int H[], int W[], int N, int K, int mid) {
		int ans = 0;
		for (int i = 0; i < N; ++i) {
			ans += (W[i]/mid)*(H[i]/mid);
		}
		if (ans < K) {
			return false;
		}
		return true;
	}

}
