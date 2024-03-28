package cbq;

import java.util.Scanner;

public class 分解质因数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		System.out.println(slove(n));
		
	}
	
	static long slove(long n) {
		long ans =0;
		for(long i = 2; i<=Math.sqrt(n);++i) {
			while(n%i==0) {
				n/=i;
				++ans;
			}
		}
		return ans;
	}

}
