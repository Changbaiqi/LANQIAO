package cbq;
import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P1095
 * @class dp，线性dp
 * @author 长白崎
 *
 */
public class P1095NOIP2007普及组守望者的逃离1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//魔法初始值
		int M = sc.nextInt();
		//距离
		int S= sc.nextInt();
		//沉没时间
		int T =sc.nextInt();
		
		int dp[] = new int[T+1];
		
		//一直用闪
		for(int i = 1; i <= T; ++i) {
			if(M >=10) {
				dp[i] = dp[i-1]+60;
				M-=10;
			}else {
				dp[i] = dp[i-1];
				M+=4;
			}
		}
		
		//中间插入跑的话
		for(int i = 1; i <= T ; ++i) {
			dp[i] = Math.max(dp[i-1]+17, dp[i]);
			//如果走出了岛屿
			if(dp[i]>=S) {
				System.out.println("Yes");
				System.out.println(i);
				return;
			}
		}
		
		System.out.println("No");
		System.out.println(dp[T]);
		
		
	}

}
