package lanqiao;

import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/1176/learning/?page=1&first_category_id=1&sort=students_count&name=%E8%83%8C%E5%8C%85
 * @author 长白崎
 *
 */
public class 小明的背包3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int V = sc.nextInt();
		
		int w[] = new int[21000]; //体积
		int v[] = new int[21000]; //价值
		
		int ans =0;
		for(int i= 1,x=1; i <= N ; ++i) {
			int sw = sc.nextInt();
			int sv = sc.nextInt();
			int n = sc.nextInt();
			ans+=n;
			int rx = x;
			for(; x < rx+n ; ++x) {
				w[x] = sw;
				v[x] = sv;	
			}			
		}
		
		int dp[][] = new int[ans+1][V+1];
		for(int y = 1; y <= ans ; ++y ) {
			for(int x =1 ; x <=V ; ++x) {
				if(x>=w[y])
					dp[y][x] = Math.max(dp[y-1][x-w[y]]+v[y], dp[y-1][x]);
				else
					dp[y][x] = dp[y-1][x];
			}
		}
		
		System.out.println(dp[ans][V]);
		
	}

}
