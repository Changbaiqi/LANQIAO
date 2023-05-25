package lanqiao;

import java.util.Scanner;

public class windy数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
	
		
		
		System.out.println(slove(b)-slove(a-1));
//		System.out.println(dp(a));
//		System.out.println(dp(b));
		
	}
	
	
	
	public static long slove(long num) {
		long bit[] = new long[12];
		
		int index  =0;
		while(num!=0) {
			bit[++index] = num%10;
			num/=10;
		}
		
		long dp[][] = new long[index+1][10];
		for(int y = 0 ; y <= index ; ++y)
			for(int x= 0; x <=9 ; ++x)
				dp[y][x] = -1;
		
		return dfs(dp,bit,index,-2,true,true);
	}
	
	public static long dfs(long dp[][],long bit[],int index,int preNum,boolean limit,boolean zero) {
		if(index==0)
			return 1;
		
		if(!limit&&!zero && dp[index][preNum]!=-1) return dp[index][preNum];
		
		long maxNum = limit?bit[index]: 9;
		
		long ans = 0;
		for(int i =0 ; i<=maxNum; ++i ) {
			
			//过滤不符合的
			if(Math.abs(preNum-i)<2)
				continue;
			
			if(zero && i==0)
				ans+=dfs(dp,bit,index-1,-2,limit && i==bit[index]?true:false,true);
			else
				ans+=dfs(dp,bit,index-1,i,limit && i==bit[index]?true:false,false);	
		}
		
		if(!zero && !limit) dp[index][preNum] = ans;
		
		return ans;
	}
	
	
	
	
}