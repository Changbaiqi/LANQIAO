package cbq;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3383/
 * @author ������
 * @class["�廪��ѧ���л�����","�ֽ�������"]
 */
public class �������ĸ���3380 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			System.out.println(solve(n));
		}
	}
	
	static long solve(int n) {
		long ans = 0;
		for(int i=2;i<=Math.sqrt(n);++i) {
			if(n%i==0) {
				while(n%i==0) {n/=i;++ans;}
			}
			
		}
		if(n>1) {++ans;}
		return ans;
	}
	

}
