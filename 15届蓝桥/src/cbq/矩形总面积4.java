package cbq;

import java.util.Scanner;

public class 矩形总面积4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long x1 = sc.nextLong();
		long y1 = sc.nextLong();
		long x2 = sc.nextLong();
		long y2 = sc.nextLong();
		long x3 = sc.nextLong();
		long y3 = sc.nextLong();
		long x4 = sc.nextLong();
		long y4 = sc.nextLong();
		
		long res = Math.max(0, Math.min(y2, y4)-Math.max(y1, y3))*Math.max(0,(Math.min(x2, x4)-Math.max(x1, x3)));
		System.out.println( (y2-y1)*(x2-x1)+(y4-y3)*(x4-x3)-res);
	}

}
