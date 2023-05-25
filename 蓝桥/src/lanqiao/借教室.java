package lanqiao;

import java.util.Scanner;
/**
 * https://www.luogu.com.cn/problem/P1083
 * @author 长白崎
 *
 */
public class 借教室 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		int n =sc.nextInt(); //天数
		int m = sc.nextInt(); //订单数量
		int day[] = new int[n+1]; //用于存储每天剩余的教室
		
		for(int i =1 ; i <=n ; ++i) {
			day[i] = sc.nextInt();
 		}
		
		int d[] = new int[m+1]; //用于存储租借数量
		int s[] = new int[m+1]; //用于存储租借开始天
		int t[] = new int[m+1]; //用于存储租借结束天
		
		for(int i= 1; i <= m; ++i) {
			d[i] = sc.nextInt();
			s[i] = sc.nextInt();
			t[i] =sc.nextInt();
			
		
			int minAns =Integer.MAX_VALUE;//用于记录区间最小数量
			//开始进行教室借租
			for(int x=s[i]; x<=t[i] ; ++x) {
				minAns = day[x]<minAns? day[x]: minAns;
				day[x]-=d[i];
				//如果不符合最低要求，不通过
				if(d[i]>minAns) {
					System.out.println(-1);
					System.out.println(i);
					return;
				}
			}
			
			

		}
		
		System.out.println(2);
		
		
		
		
		
		
		
		
		
	}

}
