package cbq;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/description/5402/
 * @author 长白崎
 * @class["蓝桥真题","数论","容斥","矩形"]
 */
public class 矩形总面积 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long x1 = sc.nextInt(); //左、下边界x坐标
		long y1 = sc.nextInt(); //下边界y坐标
		long x2 = sc.nextInt(); //右边界x坐标
		long y2 = sc.nextInt(); //
		long x3 = sc.nextInt();
		long y3 = sc.nextInt();
		long x4 = sc.nextInt();
		long y4 = sc.nextInt();
		
		
		
		long sum1= (x2-x1)*(y2-y1);
		long sum2 = (x4-x3)*(y4-y3);
		
		long over = Math.max(0, Math.min(x2, x4)-Math.max(x1, x3))*Math.max(0, Math.min(y2, y4)-Math.max(y1, y3));
		
		System.out.println(sum1+sum2-over);
		
	}
	

}
