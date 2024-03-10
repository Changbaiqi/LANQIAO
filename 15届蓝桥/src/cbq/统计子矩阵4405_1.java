package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 统计子矩阵4405_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		int N = Reader.nextInt();
		int M = Reader.nextInt();
		int K = Reader.nextInt();
		
		int arr[][] = new int[N+1][M+1];
		
		for(int y= 1;y<=N;++y) {
			for(int x= 1;x<=M;++x) {
				arr[y][x] = arr[y-1][x]+Reader.nextInt();
			}
		}
		
		long ans = 0;
		for(int t = 1 ; t<=N;++t) { //上边界
			for(int d = t ; d <=N;++d) { //下边界
				for(int l = 1, r = 1,sum = 0; r <=M;++r) { //左右边界
					sum += arr[d][r]-arr[t-1][r];
					while(sum >K) { sum -=arr[d][l]-arr[t-1][l];++l;};
					if(sum<=K) ans+=r-l+1;
				}
			}
		}
		
		System.out.println(ans);
		
		
		
		
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
