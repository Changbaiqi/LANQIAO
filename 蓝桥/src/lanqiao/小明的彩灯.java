package lanqiao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 小明的彩灯 {

	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc  = new Scanner(bufferedReader);
		
		int N = sc.nextInt();
		int Q = sc.nextInt();
		
		long data[] = new long[N+1];
		
		
		long dif[] = new long[N+1]; //差分数组
		
		for(int i = 1 ; i <=N ; ++i){
			data[i] = sc.nextLong();
			dif[i] = data[i]-data[i-1];
		}
		
		for(int i = 1 ; i <=Q; ++i) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			long n = sc.nextLong();
			dif[l] += n;
			if(r+1<=N) dif[r+1] -=n;
		}
		
		for(int i =1; i <=N ; ++i) {
			data[i] = data[i-1]+dif[i];
		}
		
		for(int i=1 ; i <=N ; ++i) {
			//ans+=dif[i];
			if(data[i]<0) data[i] = 0;
			System.out.print(data[i]+" ");
		}
		
		
	}

}
