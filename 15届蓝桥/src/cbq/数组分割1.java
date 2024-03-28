package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Êý×é·Ö¸î1 {
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	static final long MOD = 1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int T = Reader.nextInt();
		
		for(int i=0;i<T;++i) {
			int N = Reader.nextInt();
			
			int oddAns = 0;
			for(int j= 0 ;j <N;++j) {
				int res = Reader.nextInt();
				if((res&1)!=0) ++oddAns;
			}
			if(oddAns!=0) {
				if((oddAns&1)==1)out.println(0);else out.println(qpow(2,N-1));
			}else out.println(qpow(2,N));
		}
		out.flush();
		out.close();
		
		
	}
	
	static long qpow(long a,int b) {
		long sum =1;
		while(b!=0) {
			if((b&1)!=0) sum=(sum*a)%MOD;
			a=(a*a)%MOD;
			b>>=1;
		}
		return sum;
	}
	
	static class Reader{
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer tk = new StringTokenizer("");
		public static String next() {
			while(!tk.hasMoreTokens()) {
				try {
					tk = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return tk.nextToken();
		}
		public static int nextInt() {
			return Integer.parseInt(next());
		}
		
		public static long nextLong() {
			return Long.parseLong(next());
		}
	}

}
