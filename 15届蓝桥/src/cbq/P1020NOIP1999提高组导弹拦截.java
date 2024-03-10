package cbq;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author 20840
 * @classs dp、二分
 */
public class P1020NOIP1999提高组导弹拦截 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
//		ArrayList<Integer> data = new ArrayList<Integer>(); //存储导弹
		int data[] = new int[50001];
		int sum = 0;//记录总数
		while(sc.hasNextInt()) {
			data[sum++]=sc.nextInt();
		}
		
		//利用dp
		int dp[] = new int[sum];
//		dp[0] = 1;
		int max = 0;
		Arrays.fill(dp, 1);//初始化
		for(int i= 0;i<sum;++i) {
			for(int x = i+1;x<sum;++x) {
				if(data[i]>=data[x]) {
					dp[x]= Math.max(dp[x], dp[i]+1);
					max = Math.max(dp[x], max);
				}
			}
		}
		System.out.println(max);
		
		int ans = 1;
		for(int i = 1;i < sum;++i) {
			if(data[i-1]<data[i])
				++ans;
		}
		System.out.println(ans);
		
	}

}
