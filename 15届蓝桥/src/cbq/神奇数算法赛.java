package cbq;

import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/5891/learning/?contest_id=145
 * @class 数位DP，DP
 * @author 长白崎
 *
 */
public class 神奇数算法赛 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int r = sc.nextInt();
		
	}
	
	static void slove(int num) {
		int ten[]=new int[20];
		int cnt[]=new int[100];//用于统计数字i出现了多少次
		int dp[] = new int[100]; //dp数组
		
		//初始化
		ten[0]=1;
		for(int i = 1;i<=20;++i) {
			dp[i]= i*ten[i-1];
			ten[i]=10*ten[i-1];
		}
		
		
		int len=0;
		int bit[]=new int[20];
		int res=num;
		while(res!=0) {
			bit[++len]= res%10;
			res/=10;
		}
		
		for(int i=len;i>=1;--i) { //从高到低处理x的每位
			for(int j=0;j<=9;++j) cnt[j]+=dp[i-1]*bit[i];
			for(int j =0 ; j< bit[i]; ++j) cnt[j]+=ten[i-1]; //特判最高位比bit[i]小的数字
			long num2=0;
			for(int j=i-1;j>=1;--j) num2=num2*10+bit[j];
			cnt[bit[i]]+=num2+1; //特判最高位的数字bit[i]
			cnt[0] -= ten[i-1]; //特判前导0
			
		}
		
		
		
	}
	
	
	

}
