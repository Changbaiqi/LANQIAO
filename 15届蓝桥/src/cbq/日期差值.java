package cbq;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3501/
 * @author ������
 * @class ["��������"]
 */
public class ���ڲ�ֵ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		while(sc.hasNextInt()) {
			int start = sc.nextInt(); //ʱ��
			int end = sc.nextInt();
			
			int startYear = start/10000;
			int startMonth = start%10000/100;
			int startDay = start%10000%100;
			
			int endYear = end/10000;
			int endMonth = end%10000/100;
			int endDay = end%10000%100;
			
			
			LocalDate dateStart = LocalDate.of(startYear, startMonth, startDay);
			LocalDate dateEnd = LocalDate.of(endYear, endMonth, endDay);
			
			
			
			if(dateStart.isAfter(dateEnd)) {
				LocalDate res = dateStart;
				dateStart = dateEnd;
				dateEnd = res;
			}
			
			
			System.out.println(ChronoUnit.DAYS.between(dateStart, dateEnd)+1);
		}
	}

}
