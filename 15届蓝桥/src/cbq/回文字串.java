package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * https://www.luogu.com.cn/problem/P1435#submit
 * @author 长白崎
 * @class["回文串","dp"]
 *
 */
public class 回文字串 {
	static PrintWriter out  = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		char c1[] = Reader.next().toCharArray();
		char c2[] = new char[c1.length];
		for(int i = 0;i<c1.length;++i){c2[i]=c1[c1.length-i-1];}
		
		int dp[][]= new int[c1.length+1][c1.length+1];
		
		for(int i=1;i<=c1.length;++i) {
			for(int j = 1;j<=c2.length;++j) {
				if(c1[i-1]==c2[j-1]) dp[i][j] = dp[i-1][j-1]+1;else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		System.out.println(c1.length-dp[c1.length][c1.length]);
		out.flush();
		out.close();
	}

	
	
	static class Reader{
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer st = new StringTokenizer("");
		
		static String next() throws IOException {
			while(!st.hasMoreTokens()){
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}
		
		static int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
		
		static long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}

}
