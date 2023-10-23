package lanqiao;

import java.util.Scanner;

public class 小明的背包3二练 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		int V = sc.nextInt();
		
		int w[] = new int[N+1];
		int v[] = new int[N+1];
		int s[] = new int[N+1];
		
		for(int i=1; i<= N ; ++i) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
			s[i] = sc.nextInt();
		}
		
		
		int dp[] = new int[V+1];
		
		
		
		for(int y =1 ; y<= N ;  ++y) {
			
				int res =1;
				int i =1 ;
				for(;i<=s[y] ; i+=(res*=2)) {
					for(int x =V; x >=w[y]*res ; --x) {
							dp[x] = Math.max(dp[x], dp[x-w[y]*res]+v[y]*res);
						}
				}
				
				if(i>s[y])
				{
					res = s[y]-(i-res);
					for(int x =V; x >=w[y]*res ; --x) {
						dp[x] = Math.max(dp[x], dp[x-w[y]*res]+v[y]*res);
					}
					
				}			
			
		}
		System.out.println(dp[V]);
		
	}

}
