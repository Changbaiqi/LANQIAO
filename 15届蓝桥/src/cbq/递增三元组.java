package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acwing.com/problem/content/1238/
 * @author 长白崎
 * @class ["二分","前缀和","双指针"]
 */
public class 递增三元组 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		int N = Reader.nextInt();
		
		
		int A[] = new int[N+1];
		long Av[] = new long[N+1];
		int B[] = new int[N+1];
		long Bv[] = new long[N+1];
		int C[] = new int[N+1];
		
		for(int i= 1 ;i <=N;++i) A[i] = Reader.nextInt();
		for(int i= 1 ;i <=N;++i) B[i] = Reader.nextInt();
		for(int i= 1 ;i <=N;++i) C[i] = Reader.nextInt();
		
		
		Arrays.sort(A,1,N+1);
		Arrays.sort(B,1,N+1);
		Arrays.sort(C,1,N+1);
		
		
		for(int i = 1;i<=N;++i) {
			Av[i]=N - binarySearch(B, N, A[i]);
			Bv[i] = N- binarySearch(C, N, B[i]);
			Bv[i] += Bv[i-1];
		}
		
		long ans = 0;
		for(int i=1;i<=N;++i) {
				int v =  binarySearch(B, N, A[i]);
				ans += Bv[N]-Bv[v];
		}
		System.out.println(ans);
		
		
	}
	
	static int binarySearch(int arr[],int N,int v) {
		int l = 0,r = N;
		
		while(l<r) {
			int mid = (l+r+1)>>1;
			if(arr[mid]<=v)
				l = mid;
			else
				r = mid-1;
		}
		
		return r;
	}
	
	
	static class Reader{
		static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer tokenizer = new StringTokenizer("");
		
		public static String next() throws IOException {
			while(!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}
		
		public static int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}
}
