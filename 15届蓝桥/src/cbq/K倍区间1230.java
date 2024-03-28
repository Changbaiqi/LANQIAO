package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * https://www.acwing.com/problem/content/description/1232/
 * @author 长白崎
 * @class 前缀和、思维题
 *
 */
public class K倍区间1230 {
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		int N = Reader.nextInt(); //数列长度
		int K = Reader.nextInt(); //K倍区间
		
		long arr[] = new long[N+1]; //前缀和
		
		long cnt[]= new long[100000001];cnt[0]=1;
		for(int i=1 ;i<=N;++i) {
			int num = Reader.nextInt();
			arr[i] = arr[i-1]+num;
		}
		
		
		long ans = 0;
		for(int i=1;i<=N;++i) {
			ans+=cnt[(int)arr[i]%K];
			++cnt[(int)arr[i]%K];
		}
		
		out.println(ans);
		out.flush();
		out.close();
		
		
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
