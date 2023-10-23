package lanqiao;

import java.util.Scanner;
/**
 * https://vjudge.net/problem/HDU-2602
 * @author 长白崎
 *
 */
public class BoneCollector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 1 ; i <=T ; ++i) {
			int N = sc.nextInt(); //骨头数量
			int C = sc.nextInt(); //背包体积
			int w[] = new int[N+1]; //骨头的价值
			int c[] = new int[N+1]; //骨头的体积
			
			for(int x=1; x<=N ; ++x) {
				w[x] = sc.nextInt();
			}
			for(int x=1; x<=N ; ++x) {
				c[x] = sc.nextInt();
			}
			
			//开始DP
			int dp[] = new int[C+1];
			
			for(int y=1 ;y<=N ; ++y) {
				for(int x =C ; x>=c[y] ; --x) {
					dp[x] = Math.max(dp[x], dp[x-c[y]]+w[y]);
				}
			}
			
			System.out.println(dp[C]);
		}
	}

}
