package lanqiao;

import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P1002
 * @author 长白崎
 *
 */
public class P1002NOIP2002普及组过河卒 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int by = sc.nextInt();
		int bx = sc.nextInt();

		long map[][] = new long[by + 1][bx + 1];

		int my = sc.nextInt();
		int mx = sc.nextInt();

		// 标记障碍
		int next[][] = { { mx, my }, { mx - 1, my - 2 }, { mx - 2, my - 1 }, { mx + 1, my - 2 }, { mx + 2, my - 1 },
				{ mx - 2, my + 1 }, { mx - 1, my + 2 }, { mx + 1, my + 2 }, { mx + 2, my + 1 },

		};
		for (int i = 0; i < next.length; ++i) {
			if (next[i][0] < 0 || next[i][1] < 0 || next[i][1] >= map.length || next[i][0] >= map[0].length)
				continue;
			map[next[i][1]][next[i][0]] = 1;
		}

		long dp[][] = new long[by + 1][bx + 1];
		dp[0][0] = 1;
		for (int y = 0; y <= by; ++y) {
			for (int x = 0; x <= bx; ++x) {
				
				long a1 = 0;
				long a2 = 0;
				
				if (y == 0 && x == 0)
					continue;

				if(map[y][x]==1)
					continue;
				
				if (y - 1 >= 0 && x >= 0 && y - 1 <= by && x <= bx)
					a1 = dp[y - 1][x];
				if (y >= 0 && x - 1 >= 0 && y <= by && x - 1 <= bx)
					a2 = dp[y][x - 1];
				
				dp[y][x] = a1 + a2;
			}
		}
		//pr(map);
		//System.out.println();
		//pr(dp);
		System.out.println(dp[by][bx]);

	}
	
	public static void pr(long dp[][]) {
		for(int y = 0 ; y < dp.length ; ++y) {
			for(int x =0; x<dp[y].length ; ++x ) {
				System.out.print(dp[y][x]+" ");
			}
			System.out.println();
		}
	}

}
