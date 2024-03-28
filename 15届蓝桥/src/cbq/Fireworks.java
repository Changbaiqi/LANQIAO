package cbq;

import java.util.Scanner;

public class Fireworks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-->0) {
			long a = sc.nextLong();
			long b =sc.nextLong();
			long m = sc.nextLong();
			System.out.println(m/a+1+m/b+1);
		}
	}

}
