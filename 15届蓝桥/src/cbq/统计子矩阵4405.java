package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acwing.com/problem/content/4408/
 * 
 * @author 长白崎
 * @class ["枚举","前缀和","双指针"]
 */
public class 统计子矩阵4405 {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
		int N = Reader.nextInt();
		int M = Reader.nextInt();
		int K = Reader.nextInt();

		long arr[][] = new long[N + 1][M + 1];

		for (int y = 1; y <= N; ++y) {
			for (int x = 1; x <= M; ++x) {
				int num = Reader.nextInt();
				arr[y][x] = num +arr[y-1][x];
			}
		}

		long ans = 0;
		
		for(int t = 1 ; t <= N ; ++t) {
			for(int d = t; d <=N; ++d) {
				for(int l = 1 , r = 1,sum= 0;r<=M; ++r) {
					sum += arr[d][r]- arr[t-1][r];
					while(sum >K) {
						sum -= arr[d][l]-arr[t-1][l];
						++l;
					}
					ans +=r-l+1;
				}
			}
		}
		System.out.println(ans);

	}
	
	static class Reader{
		static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer tokenizer = new StringTokenizer("");
		
		public static String next() throws IOException {
			while(!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}
		
		public static int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}
}
