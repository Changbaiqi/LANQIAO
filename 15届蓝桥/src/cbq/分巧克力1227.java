package cbq;

import java.util.Scanner;
/**
 * https://www.acwing.com/problem/content/1229/
 * @author 长白崎
 * @class 二分、枚举
 *
 */
public class 分巧克力1227 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // N块巧克力
		int K = sc.nextInt(); // K位小朋友

		int H[] = new int[N];
		int W[] = new int[N];

		for (int i = 0; i < N; ++i) {
			H[i] = sc.nextInt();
			W[i] = sc.nextInt();
		}

		int l = 1, r = 100001, mid = 0;
		//左开右闭模板
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
	 * 二分check函数
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
