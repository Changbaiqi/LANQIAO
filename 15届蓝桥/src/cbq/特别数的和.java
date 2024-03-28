package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * https://www.lanqiao.cn/problems/191/learning/?page=1&first_category_id=1&name=%E7%89%B9%E5%88%AB%E6%95%B0
 * @author 长白崎
 * @class["第八届省赛JavaB组"]
 */
public class 特别数的和 {
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Reader.nextInt();
		
		long sum =0;
		for( int i=1;i<=n;++i) {
			if(check(i)) 
				sum+=i;
		}
		System.out.println(sum);
		
	}
	
	static boolean check(int n) {
		while(n!=0) {
			if( n%10==2 || n%10==0||n%10==1||n%10==9) return true;
			n/=10;
		}
		return false;
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
