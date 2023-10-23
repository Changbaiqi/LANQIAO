package lanqiao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 小明的背包5二练 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(br);
		
		int N = sc.nextInt();
		int V = sc.nextInt();
		
		int w[][] = new int[101][101];
		int v[][] = new int[101][101];
		int s[] = new int[101];
		for(int i = 1; i <=N ; ++i) {
			s[i] = sc.nextInt();
			for(int y=1; y<=s[i]; ++y) {
				w[i][y] = sc.nextInt();
				v[i][y] = sc.nextInt();
			}
		}
		
		int dp[] = new int[V+1];
		
		for(int y = 1 ; y <=N ; ++y) {
			for(int x=V ; x>=1; --x) {
				for(int i=1; i<=s[y]; ++i) {
					if(x>=w[y][i])
						dp[x] = Math.max(dp[x], dp[x-w[y][i]]+v[y][i]); 
				}
			}
		}
		System.out.println(dp[V]);
		
		
		
	}

}
