package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * https://www.acwing.com/problem/content/5399/
 * @author 长白崎
 * @class ["快读快输","二维差分","二维前缀和"]
 */
public class 棋盘 {
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		
		int n= Reader.nextInt();
		int m= Reader.nextInt();
		
		int arr[][] = new int[n+2][n+2];
		int diff[][] = new int[n+2][n+2];
		
		for(int i =1;i<=m;++i) {
			int x1 = Reader.nextInt();
			int y1 = Reader.nextInt();
			int x2 = Reader.nextInt();
			int y2 = Reader.nextInt();
			diff[x1][y1] +=1;
			diff[x1][y2+1] -=1;
			diff[x2+1][y1] -=1;
			diff[x2+1][y2+1] +=1;
		}
		
		for(int i = 1;i<=n;++i) {
			for(int j = 1;j<=n;++j) {
				arr[i][j] = diff[i][j]+arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
				out.print((arr[i][j]%2));
			}
			out.println();
		}
		out.flush();
		out.close();
	}
	
	static class Reader{
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer tokenizer = new StringTokenizer("");
		
		public static String next() throws IOException {
			while(!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(br.readLine());
			}
			
			return tokenizer.nextToken();
		}
		public static int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}

}
