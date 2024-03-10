package cbq;

import java.util.Scanner;

public class 最大面积牛客 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		long d = sc.nextLong();
		
		long wmin1 = a<c?a:c;
		long hmin1 = b<d?b:d;
		
		long wmin2 = b<c?b:c;
		long hmin2 = a<d?a:d;
		System.out.println(wmin1*hmin1);
	}

}
