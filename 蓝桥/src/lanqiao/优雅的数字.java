package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/CF1036C
 * @author ������
 *
 */
public class ���ŵ����� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1 ; i<=T; ++i) {
			long L = sc.nextLong();
			long R = sc.nextLong();
			System.out.println(slove(R)-slove(L-1));
		}
		
	}
	
	public static long slove(long n) {
		int data[] = new int[20];
		int i =0;
		while(n!=0) {
			data[++i]=(int)(n%10);
			n/=10;
		}
		
		long dp[][]= new long[i+1][4];
		
		for(int x= 0; x <=i ; ++x)
			Arrays.fill(dp[x], -1);
		
	
		return dfs(data,dp,true,0,i,0);
	}
	
	
	/**
	 * ��λDP�����㷨
	 * @param data ���ڴ洢λ�����������
	 * @param dp ��λdp������
	 * @param preZero �Ƿ�ǰ����
	 * @param limit �Ƿ����λ
	 * @param preNum ��һλdfs������
	 * @param index ��ǰdp������
	 * @return ���ص�ǰλ���ķ���Ҫ����ܺ�
	 */
	public static long dfs(int data[],long dp[][],boolean limit,int preNum,int index,int pAns) {
		if(index==0) {
			if(pAns<=3) return 1;
			else
				return 0;
		}
		
		
		
		if( !limit && dp[index][pAns]!=-1)
			return dp[index][pAns];
		
		int maxNum = limit? data[index]: 9;
		long ans =0;
		for(int i = 0 ; i <= maxNum ; ++i) {
			
			if( i==0)
				ans+= dfs(data,dp,limit &&i==data[index] ? true:false,i,index-1,pAns);
			else if(pAns < 3)
				ans+= dfs(data,dp,limit &&i==data[index] ? true:false,i,index-1,pAns+1);
		}
		
		if(!limit)
			dp[index][pAns] = ans;
		
		return ans;
	}
	

}
