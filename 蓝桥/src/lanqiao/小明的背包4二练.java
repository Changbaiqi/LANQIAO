package lanqiao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 小明的背包4二练 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(br);
		
		
		int N = sc.nextInt();
		int V = sc.nextInt();
		
		int w[] = new int[N+1];
		int v[] = new int[N+1];
		int s[] = new int[N+1];
		
		
		
		for(int i=1; i <=N ; ++i) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
			s[i] = sc.nextInt();
		}
		
		int dp[] = new int[V+1];
		for(int y= 1;y <=N ; ++y) {
			if(s[y]!=0) {
				int i = 1;
				int res=1;
				
				for(; i <=s[y]; i+=(res*=2)) {
					for(int x=V;x>=1 ; --x) {
						if(x>=res*w[y])
							dp[x] = Math.max(dp[x], dp[x-res*w[y]]+res*v[y]);
					}
				}
				if(s[y]<i) {
					res = s[y]-(i-res); 
					for(int x=V;x>=1 ; --x) {
						if(x>=res*w[y])
							dp[x] = Math.max(dp[x], dp[x-res*w[y]]+res*v[y]);
					}
				}
			}else {
				for(int x=w[y] ; x <=V; ++x) {
					dp[x] = Math.max(dp[x], dp[x-w[y]]+v[y]);
				}
			}
		}
		
		System.out.println(dp[V]);
		
	}

}
