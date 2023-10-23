package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class Windy数二练 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(slove(b)-slove(a-1));
		
	}
	
	
	public static long slove(int a) {
		int data[] = new int[13];
		
		int i=0;
		while(a!=0) {
			data[++i] = a%10;
			a/=10;
		}
		
		//这个dp数组的意思是第i位数字如果前导是n的时候有多少种符合要求的方案。
		long dp[][] = new long[i+1][10];
		
		for(int y=0 ; y < dp.length ; ++y)
			Arrays.fill(dp[y],-1);
			
		return dfs(dp, data, true, true, i, -2);
	}
	
	
	
	public static long dfs(long dp[][]/*dp数组*/,int data[]/*存储的数*/, boolean limit/*限制最高位*/,boolean preZero/*是否前导零*/,int index/*当前需填数的位置*/,int preNum/*前一个位置的数字*/) {
		if(index==0)
			return 1;
		
		
		if(!limit && !preZero && dp[index][preNum]!=-1)  return dp[index][preNum];
		
		//当前位最大值
		int maxNum = limit?data[index]:9;
		
		
		long ans=0;
		for(int i=0; i<=maxNum; ++i) {
			
			//过滤不符合的条件，这里不符合的条件即左右两边都没有相差大于等于2值的数字
			if(Math.abs(preNum-i)<2)
				continue;
			
			if(preZero && i==0)
				ans+=dfs(dp, data, limit && i==data[index]?true:false, true, index-1, -2);
			else
				ans+=dfs(dp, data, limit && i==data[index]?true:false, false, index-1, i);
			
			
			
			
		}
		
		if(!preZero && !limit) dp[index][preNum] = ans;
		return ans;
	}

}
