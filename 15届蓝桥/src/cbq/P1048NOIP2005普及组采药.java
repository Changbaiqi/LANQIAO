package cbq;

import java.util.Scanner;
/**
 * https://www.luogu.com.cn/problem/P1048
 * @class DP,����DP��01����
 * @author ������
 *
 */
public class P1048NOIP2005�ռ����ҩ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		int T = sc.nextInt();
		int M = sc.nextInt();
		
		int t[] = new int[M];
		int m[] = new int[M];
		for(int i=0 ; i < M;++i) {
			t[i]= sc.nextInt();
			m[i] = sc.nextInt();
		}
		
		int dp[] = new int[T+1];
		
		
		for(int i= 0 ; i < M ; ++i) {
			for(int x = T ; x >=t[i];--x) {
				dp[x] = Math.max(dp[x], dp[x-t[i]]+m[i]);
			}
		}
		System.out.println(dp[T]);

	}

}
