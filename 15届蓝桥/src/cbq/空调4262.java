package cbq;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/4265/
 * 
 * @author 长白崎
 * @class 差分、贪心
 */
public class 空调4262 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int p[] = new int[N + 1];
		int t[] = new int[N + 1];

		int diff[] = new int[N + 1];

		for (int i = 1; i <= N; ++i)
			p[i] = sc.nextInt();

		int small = 0,big = 0;
		for (int i = 1; i <= N; ++i) {
			t[i] = sc.nextInt(); //输入当前温度
			p[i]-=t[i];
			diff[i] = p[i]-p[i-1]; //计算差分数组
			if(diff[i]<0)
				small+=Math.abs(diff[i]);
			else
				big+=diff[i];
		}
		
		System.out.println(Math.max(big,small));
		
		
	
		
	}

}
