package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * https://www.acwing.com/problem/content/5401/
 * @author 长白崎
 * @class["快速幂","思维题","第十四届蓝桥杯省赛Java B组"]
 *
 */
public class 数组分割 {

	static PrintWriter bw = new PrintWriter(new OutputStreamWriter(System.out));
	
	static final int mod = 1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int T = Reader.nextInt();
		
		
		for(int i= 1;i<=T;++i) {
			int N = Reader.nextInt();
			int oddAns =0; //奇数偶数统计	
			for(int j =1;j<=N;++j) {
				long A = Reader.nextLong();
				if(A%2!=0) ++oddAns;
			}
			
			if(oddAns%2!=0) bw.println(0);else {
				if(oddAns==0) bw.println(qpow(2,N));else bw.println(qpow(2, N-1));
			} 
			
		}
		bw.flush();
		bw.close();
	}
	
	static long qpow(long a,int n) {
		long ans = 1;
		while(n>0) {
			if((n&1)>0)
				ans=ans*a%mod;
			a=a*a%mod;
			n>>=1;
		}
		return ans;
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
