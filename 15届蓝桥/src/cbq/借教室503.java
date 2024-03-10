package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acwing.com/problem/content/505/
 * 
 * @author 长白崎
 * @class 差分、二分、快读
 *
 */
public class 借教室503 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		int n = Reader.nextInt();
		int m = Reader.nextInt();

		long data[] = new long[n + 2];

		long d[] = new long[m + 2]; // 借用个数
		int s[] = new int[m + 2]; // 开始天数
		int t[] = new int[m + 2]; // 结束天数
		// 差分数组计算
		for (int i = 1; i <= n; ++i) {
			data[i] = Reader.nextLong();
		}

		for (int i = 1; i <= m; ++i) {
			d[i] = Reader.nextLong();
			s[i] = Reader.nextInt();
			t[i] = Reader.nextInt();
		}

		int l = 1, r = m, mid = 0;
		while (l < r) {
			mid = (l + r + 1) >> 1;
			if (check(data, d, s, t, mid)) {
				l = mid;
			} else {
				r = mid - 1;
			}
		}
		if (r == m) {
			System.out.println(0);
			return;
		}
		
		for (int i = r; i < m; ++i) {
			if (!check(data, d, s, t, i+1)) {
				System.out.println(-1);
				System.out.println(i + 1);
				return;
			}
		}
	}

	static boolean check(long data[], long d[], int s[], int t[], int mid) {
		long sum = 0;
		long res[] = new long[data.length];

		// 直接差分寄存
		for (int i = 1; i <= mid; ++i) {
			res[s[i]] += d[i];
			res[t[i] + 1] -= d[i];
		}
		for (int i = 0; i < data.length; ++i) {
			sum += res[i];
			if (sum > data[i])
				return false;
		}
		return true;
	}

	static class Reader {
		static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer tokenizer = new StringTokenizer("");

		public static String next() throws IOException {
			while (!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		public static int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		public static long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}

}
