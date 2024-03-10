package cbq;

import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/contest/71135/F
 * @class 等差数列
 * @author 长白崎
 *
 */
public class 整数划分 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i =0 ;i< T;++i) {
			int n = sc.nextInt();
			slove(n);
		}
	}
	
	static void slove(int num) {
		
		for(int i= 1,ans=1;ans<=num;++i,ans+=i) {
			if(ans+(i+1)>num) {
				System.out.print(i+(num-ans)+" ");
				break;
			}
			System.out.print(i+" ");
		}
		System.out.println();
	}

}
