package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.lanqiao.cn/problems/193/learning/?page=1&first_category_id=1&name=%E5%90%8E%E7%BC%80
 * @author 长白崎
 * @class["第八届蓝桥杯JavaB组省赛","前缀和"]
 */
public class 后缀表达式 {
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) {	
		// TODO Auto-generated method stub
		
		
		int N = Reader.nextInt();
		int M= Reader.nextInt();
		Long arr[]= new Long[N+M+2];
		
		for(int i=1;i<=N+M+1;++i) {
			arr[i] = Reader.nextLong();
		}
		
		
		Arrays.sort(arr,1,N+M+2,(a,b)->b.compareTo(a));
		
		
		long sum =0;
		if(M==0) {
			for(int i=1 ;i<=N+M+1;++i) {
				sum+=arr[i];
			}
		}else {
			sum+=arr[1]-arr[N+M+1];
			for(int i=2;i<=N+M;++i) {
				sum+=Math.abs(arr[i]);
			}	
		}
		
		
		
		out.print(sum);
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
