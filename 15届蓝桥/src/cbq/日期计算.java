package cbq;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3221/
 * @author 长白崎
 * @class["日期"]
 */
public class 日期计算 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int d = sc.nextInt();
		LocalDate res= LocalDate.of(y, 1, 1);
		res = res.plusDays(d-1);
		System.out.println(res.getMonthValue());
		System.out.println(res.getDayOfMonth());
	}

}
