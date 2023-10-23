package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class Windy������ {

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
		
		//���dp�������˼�ǵ�iλ�������ǰ����n��ʱ���ж����ַ���Ҫ��ķ�����
		long dp[][] = new long[i+1][10];
		
		for(int y=0 ; y < dp.length ; ++y)
			Arrays.fill(dp[y],-1);
			
		return dfs(dp, data, true, true, i, -2);
	}
	
	
	
	public static long dfs(long dp[][]/*dp����*/,int data[]/*�洢����*/, boolean limit/*�������λ*/,boolean preZero/*�Ƿ�ǰ����*/,int index/*��ǰ��������λ��*/,int preNum/*ǰһ��λ�õ�����*/) {
		if(index==0)
			return 1;
		
		
		if(!limit && !preZero && dp[index][preNum]!=-1)  return dp[index][preNum];
		
		//��ǰλ���ֵ
		int maxNum = limit?data[index]:9;
		
		
		long ans=0;
		for(int i=0; i<=maxNum; ++i) {
			
			//���˲����ϵ����������ﲻ���ϵ��������������߶�û�������ڵ���2ֵ������
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
