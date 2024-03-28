package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class 最大开支 {
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args)throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		int N = Reader.nextInt();
		int M = Reader.nextInt();
		
		
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
		static long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}

}
