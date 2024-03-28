package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acwing.com/problem/content/description/3748/
 * @author 长白崎
 * @class ["双指针"]
 */
public class 牛的学术圈I {

	public static void main(String[] args)throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		int N = Reader.nextInt();
		int L = Reader.nextInt();
		
		Integer arr[] = new Integer[N+1];
		
		for(int i= 1;i<=N;++i) {
			arr[i] = Reader.nextInt();
		}
		

		Arrays.sort(arr,1,N+1,(a,b)->b-a);
		
		int max =0;

		
		
		
		int l = 1,r=N;
		while(l<=N) {
			while(r>0 && arr[r]<l) --r;
			if(arr[l]>=l-1 && l-r<=L) max =l;
			++l;
		}
		
		System.out.println(max);
		
		
	}
	
	static class Reader {
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
