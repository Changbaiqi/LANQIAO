package cbq;
import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P1359
 * @author 长白崎
 *
 */
public class P1359租用游艇 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int data[][] = new int[n][n];
		
		//dp数组
		int dp[] = new int[n];
				
		//输入
		for(int y =0 ; y< n; ++y) {
			for (int x =y+1 ; x < n ; ++x) {
				data[y][x] = sc.nextInt();
			}
			dp[y] = (int)1e6;
		}
		
		dp[0] = 0;
		for(int y =0 ; y< n ; ++y) {
			for(int x =0 ;x< y ; ++x) {
				dp[y] = Math.min(data[x][y]+dp[x], dp[y]);
			}
		}
		
		System.out.println(dp[n-1]);

	}

}
