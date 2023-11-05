package cbq;

import java.util.Scanner;

public class 最大公约数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		System.out.println(lcm(a,b));	
	}
	static long lcm(long a,long b) {
		return a/gcd(a,b)*b;
	}
	
	static long gcd(long a,long b) {
		return b==0?a:gcd(b,a%b);
	}

}
