package cbq;

import java.util.Scanner;


/**
 * https://www.acwing.com/problem/content/description/424/
 * @author 长白崎
 * @class["区间合并","模拟"]
 */
public class 校门外的树 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int M = sc.nextInt();
		boolean state[] = new boolean[L+1];
		for(int i =1;i<=M;++i){
			int l = sc.nextInt();
			int r = sc.nextInt();
			for(int x= l;x<=r;++x) state[x] = true; 
		}
		int ans = 0;
		for(int i= 0;i<=L;++i) {
			if(!state[i])
				++ans;
		}
		System.out.println(ans);
	}

}
