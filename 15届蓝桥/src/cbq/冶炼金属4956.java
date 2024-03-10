package cbq;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/4959/
 * @author 长白崎
 * @class ["二分"]
 *
 */
public class 冶炼金属4956 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int A[] = new int[N + 1];
		int B[] = new int[N + 1];

		for (int i = 1; i <= N; ++i) {
			A[i] = sc.nextInt();
			B[i] = sc.nextInt();
		}


		int lmin = 1, rmin = 1000000001;

		while (lmin < rmin) {
			int mid = (lmin + rmin) >> 1;
			if (check(A, B, N, mid,false))
				lmin = mid+1;
			else
				rmin = mid;
		}
		
		
		int lmax = 1, rmax = 1000000001;

		while (lmax < rmax) {
			int mid = (lmax + rmax + 1) >> 1;
			if (check(A, B, N, mid,true))
				lmax = mid;
			else
				rmax = mid - 1;
		}
		
		System.out.print(lmin+" "+rmax);
		

	}

	/**
	 * 二分check函数
	 * @param A
	 * @param B
	 * @param N
	 * @param mid
	 * @param sw
	 * @return
	 */
	static boolean check(int A[], int B[], int N, int mid, boolean sw) {
		for (int i = 1; i <= N; ++i) {
			int sum = A[i] / mid;
			if (sw) {
				if (sum < B[i])
					return false;
			} else {
				if (sum > B[i])
					return true;
			}
		}
		if (sw)
			return true;
		else
			return false;
	}

}
