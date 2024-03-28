package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.lanqiao.cn/problems/17035/learning/?contest_id=177
 * @author 长白崎
 * @class["字典序","字符串"]
 */
public class 二进制国王 {
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Reader.nextInt();

		String arr[] = new String[n];
		
		for(int i =0;i<n;++i) {
			arr[i] = Reader.next();
		}
		
		Arrays.sort(arr, (a, b) -> (a+b).compareTo(b+a));

		for (int i = 0; i < n; ++i) {
			out.print(arr[i]);
		}
		out.flush();
		out.close();
	}

	
	static class Reader{
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer st = new StringTokenizer("");
		
		public static String next() {
			while(!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		public static int nextInt() {
			return Integer.parseInt(next());
		}
		public static long nextLong() {
			return Long.parseLong(next());
		}
	}
}
