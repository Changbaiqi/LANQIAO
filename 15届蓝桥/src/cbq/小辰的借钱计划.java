package cbq;

import java.util.Scanner;

/**
 * @class ���ۡ�����
 * @author ������
 *
 */
public class С���Ľ�Ǯ�ƻ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; ++i) {
			int m = sc.nextInt();
			int a = sc.nextInt();

			int ans = 0, sum = 0;
			for (int x = 1; x <= m - a; ++x) {
				if (x % a == 0 || a % x == 0) {
					sum += x;
					++ans;
				}
			}
			if (sum > a * ans)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
