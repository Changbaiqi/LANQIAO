package cbq;
import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/1447/learning/?page=2&first_category_id=1&sort=students_count
 * @author ³¤°×Æé
 *
 */
public class íÀÂë³ÆÖØ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int data[] = new int[N+1];
		
		for(int i= 1 ; i <=N ; ++i) {
			data[i] = sc.nextInt();
		}
		
		boolean dp[][] = new boolean[N+1][100001];
		
		for(int i=1 ; i <=N; ++i) {
			dp[i][data[i]] = true;
			for(int j = 0; j <=100000; ++j) {
				if(dp[i-1][j]) {
					dp[i][j] = true;
					dp[i][Math.abs(data[i]-j)] = true;
					dp[i][data[i]+j] = true;
				}
			}
		}
		
		long ans=0;
		for(int i=1; i <= 100000; ++i) {
			if(dp[N][i])
				++ans;
		}
		System.out.println(ans);
		
		
	}
	

}
