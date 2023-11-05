package cbq;

import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P1618
 * @class 辗转相除法、dfs、穷举、全排列
 * @author 长白崎
 *
 */
public class P1618三连击升级版 {
	static long ans = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		boolean state[] = new boolean[10];
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c= sc.nextInt();
		dfs(state,a,b,c, 0, 0);
		if(ans==0)
			System.out.println("No!!!");
	}
	
	static void dfs(boolean state[],int ra,int rb,int rc,int resI,int sum) {
		
		if(resI==state.length-1) {
			int a = sum/1000000;
			sum%=1000000;
			int b = sum/1000;
			sum%=1000;
			long ca = a/gcd(gcd(a,b),sum);
			long cb = b/gcd(gcd(a,b),sum);
			long cc = sum/gcd(b,sum);
			long ba = ra/gcd(gcd(ra,rb),rc);
			long bb = rb/gcd(gcd(ra,rb),rc);
			long bc = rc/gcd(gcd(ra,rb),rc);
			if(ca==ba && cb==bb && cc==bc) {
				System.out.println(a+" "+b+" "+sum);
				++ans;
			}
			return;
		}
		
		for(int i =1; i < state.length ; ++i) {
			if(!state[i]) {
				state[i]=true;
				dfs(state,ra,rb,rc,resI+1,sum*10+i);
				state[i] = false;
			}
		}
	}
	
	static long gcd(long a,long b) {
		if(b==0)
			return a;
		return gcd(b,a%b);
	}

}
