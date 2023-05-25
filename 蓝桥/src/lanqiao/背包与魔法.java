package lanqiao;

import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/2223/learning/?page=1&first_category_id=1&sort=students_count&name=%E8%83%8C%E5%8C%85
 * @author 长白崎
 *
 */
public class 背包与魔法 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M =sc.nextInt();
		int K = sc.nextInt();
		
		int w[][] = new int[N+1][3];
		int v[][] = new int[N+1][3];
		
		for(int i=1 ; i <= N ; ++i) {
			w[i][1] = sc.nextInt();
			v[i][1] = sc.nextInt();
			
			w[i][2] = w[i][1]+K;
			v[i][2] = v[i][1]*2;
		}
		
		int dp[][] = new int[2][M+1];
		
		for(int y =1  ; y <= N ; ++y) {
			for(int x=M ; x>=1 ; --x) {
				if(x>=w[y][1]) {
					//所有物品都不适用魔法的情况下
					dp[0][x] = Math.max(dp[0][x], dp[0][x-w[y][1]]+v[y][1]);
					//比较前一个物品可以使用魔法（但是不选择当前物品）与所有物品都不使用魔法的情况下
					dp[1][x] = Math.max(dp[1][x], dp[1][x-w[y][1]]+v[y][1]);
				}
				if( x>=w[y][2])
					//比较上面比较所得出的结果与当前物品可以使用魔法的情况下的比较结果
					dp[1][x] = Math.max(dp[1][x], dp[0][x-w[y][2]]+v[y][2]);
			}
		}
		System.out.println(Math.max(dp[1][M],dp[0][M]));
	}

}
