package lanqiao;

import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P1095
 * @author 长白崎
 *
 */
public class 守望者的逃离 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int S = sc.nextInt();
		int T = sc.nextInt();
		
		int dp[] = new int[T+1];
		
		for(int i=1 ; i <=T; ++i) {
			if(M>=10) {
				dp[i]+=dp[i-1]+60;
				M-=10;
			}else {
				dp[i]=dp[i-1];
				M+=4;
			}
		}
		
		for(int i= 1; i <=T; ++i) {
			dp[i] = Math.max(dp[i-1]+17, dp[i]);
			if(dp[i]>=S) {
				System.out.println("Yes");
				System.out.println(i);
				return;
			}
		}
		
		System.out.println("No");
		System.out.println(dp[T]);
	
		
		
		sc.close();
	}

}
