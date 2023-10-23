package cbq;

import java.util.Scanner;


/**
 * https://www.luogu.com.cn/problem/P1541
 * @class dp，多维dp，递归，枚举
 * @author 长白崎
 *
 */
public class P1541NOIP2010提高组乌龟棋 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int data[] = new int[n];

		int cards[] = new int[5];

		for (int i = 0; i < n; ++i) {
			data[i] = sc.nextInt();
		}

		for (int i = 0; i < m; ++i) {
			++cards[sc.nextInt()];
		}

		// DP数组
		int dp[][][][] = new int[cards[1]+1][cards[2]+1][cards[3]+1][cards[4]+1];
		
		dp[0][0][0][0] = data[0];
		
		for (int a = 0; a <= cards[1]; ++a) {
			for (int b = 0; b <= cards[2]; ++b) {
				for (int c = 0; c <= cards[3]; c++) {
					for (int d = 0; d <= cards[4]; d++) {
						int step = a+b*2+c*3+d*4;
						if(a!=0) dp[a][b][c][d] = Math.max(dp[a][b][c][d], dp[a-1][b][c][d]+data[step]);
						if(b!=0) dp[a][b][c][d] = Math.max(dp[a][b][c][d], dp[a][b-1][c][d]+data[step]);
						if(c!=0) dp[a][b][c][d] = Math.max(dp[a][b][c][d], dp[a][b][c-1][d]+data[step]);
						if(d!=0) dp[a][b][c][d] = Math.max(dp[a][b][c][d], dp[a][b][c][d-1]+data[step]);
					}
				}
			}
		}
		
		System.out.println(dp[cards[1]][cards[2]][cards[3]][cards[4]]);

	}

}
