package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ÓïÎÄ³É¼¨ {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		int n = Reader.nextInt();
		int m = Reader.nextInt();
		int arr[] = new int[n+2];
		int diff[] = new int[n+2];
		
		for(int i= 1;i<=n;++i) {
			arr[i] = Reader.nextInt();
			diff[i]  = arr[i]-arr[i-1];
		}
		for(int i = 1;i<=m;++i) {
			int x = Reader.nextInt();
			int y = Reader.nextInt();
			int z = Reader.nextInt();
			diff[x]+=z;diff[y+1] -=z;
		}
		
		int min = Integer.MAX_VALUE;
		for(int i= 1;i<=n;++i) {
			diff[i]+=diff[i-1];
			min = Math.min(diff[i], min);
		}
		System.out.println(min);
		
	
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
