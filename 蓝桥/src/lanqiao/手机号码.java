package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class 手机号码 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long L = sc.nextLong();
		System.out.println(slove(L));
//		long R = sc.nextLong();
//		
//		System.out.println(slove(R)-slove(L-1));
	}
	
	
	public static long slove(long num) {
		long bit[] = new long[13];
		
		int i =0;
		while(num!=0) {
			bit[++i] = num%10;
			num/=10;
		}
		/**
		 * 1、第几位
		 * 2、数字是几
		 * 3、目前连续
		 * 4、是否有4
		 * 5、是否有8
		 * 6、是否至少有三位连续
		 */
		long dp[][][][][] = new long[i+1][10][4][2][2];
		for(int x =0 ; x<=i ; ++x)
			Arrays.fill(dp[x], -1);
		
		return dfs(dp,bit,i,0,true,true,false,false,new int[13]);
	}
	
	
	//1、不能同时出现8和4。2、号码中出现至少三个相邻的相同数字
	public static long dfs(long dp[][][][][],long bit[],int index,int preNum,boolean limit,boolean zero,boolean eightSW,boolean fourSW,int res[]) {
		if(index==0)
			return 1;
		
//		if(!limit && !zero&& dp[index][preNum]!=-1)
//			return dp[index][preNum];
		
		long maxNum = limit?bit[index]:9;
		long ans =0;
		for(int i =0 ; i <=maxNum ; ++i) {
			if(zero&& i==0) {
				if(check(res,index))
				ans+=dfs(dp,bit,index-1,0,limit&&i==bit[index]?true:false,true,  false,false,res);
			}else {
				ans+=dfs(dp,bit,index-1,0,limit&&i==bit[index]?true:false,false,  false,false,res);
			}
		}
		
		//if(!zero && !limit) dp[index][preNum] = ans;
		
		return ans;
	}
	
	
	public static boolean check(int res[],int len) {
		int n =1 ;
		for(int i =1 ; i<=len ; ++i) {
			if(res[i-1]==res[i])
				++n;
			else
				n=1;
			if(n>=3)
				return true;
		}
		return false;
	}

}
