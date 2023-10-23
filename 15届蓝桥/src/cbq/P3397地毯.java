package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * https://www.luogu.com.cn/problem/P3397
 * @class 二维差分
 * @author 长白崎
 *
 */
public class P3397地毯 {
	
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int n = Reader.nextInt();
		int m = Reader.nextInt();
		
		int map[][] = new int[n+2][n+2];
		for(int i=1 ; i <=m;++i) {
			int y1 = Reader.nextInt();
			int x1 = Reader.nextInt();
			int y2 = Reader.nextInt();
			int x2 = Reader.nextInt();
			
			++map[y1][x1];
			--map[y1][x2+1];
			--map[y2+1][x1];
			++map[y2+1][x2+1];
		}
		
		int[][] data = new int[n+2][n+2];
		
		for(int y =1 ;y <= n; ++y ) {
			for(int x=1; x<=n ; ++x) {
				data[y][x]=map[y][x]+data[y][x-1]+data[y-1][x]-data[y-1][x-1];
				out.print(data[y][x]+" ");
			}
			out.println();
		}
		out.flush();
	}
	
	static class Reader{
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer tokenizer = new StringTokenizer("");
		
		static String next() throws IOException {
			while(!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(br.readLine());
			}
			return tokenizer.nextToken();
		}
		
		static int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
		
	}

}
