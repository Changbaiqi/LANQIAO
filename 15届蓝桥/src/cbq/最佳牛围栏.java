package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 长白崎
 * @class ["高精度二分","数论"]
 */
public class 最佳牛围栏 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		int N = Reader.nextInt();
		int F = Reader.nextInt();
		
		int arr[] = new int[N+1];
		int max = 0; //最大值
		for(int i =1 ;i<=N;++i) {
			arr[i] = Reader.nextInt();
			max = Math.max(max, arr[i]);
		}
		
		
		double l  = 0,r = max;
		
		while(r-l> 1e-5) {
			double mid = (l+r)/2.0;
			if(check(arr,N,F,mid))
				l = mid;
			else
				r = mid;
			
		}
		System.out.println((int)(r*1000));
		
		
	}
	
	
	static boolean check(int arr[],int N,int F,double mid) {
		double sum[] = new double[N+1];
		
		//与平均值答案相减看差值
		for(int i = 1;i<=N;++i) {sum[i]=arr[i]-mid+sum[i-1];}
		
		double min = 0;
		for(int l = 0,r=F ; r<=N;++r,++l) {
			min = Math.min(min, sum[l]);
			if(sum[r]-min>=0) return true;
		}
		
		return false;
		
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
