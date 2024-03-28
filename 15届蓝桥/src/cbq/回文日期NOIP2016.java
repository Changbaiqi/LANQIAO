package cbq;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/problem/16438
 * @author 长白崎
 * @class ["回文","日期"]
 */
public class 回文日期NOIP2016 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		int startYear = start/10000;
		int startMonth = start%10000/100;
		int startDay = start%10000%100;
		
		int endYear =  end/10000;
		int endMonth = end%10000/100;
		int endDay =   end%10000%100;
		
		
		int ans = 0;
		for(int i=startYear;i<=endYear;++i) {
			int now = Integer.parseInt(i+(new StringBuffer(String.valueOf(i)).reverse().toString()));
			if(check(startYear,startMonth,startDay,endYear,endMonth,endDay,now/10000,now%10000/100,now%10000%100))
				++ans;
		}
		System.out.println(ans);
	}

	static boolean check(int startYear,int startMonth,int startDay, int endYear,int endMonth,int endDay,int nowYear,int nowMonth,int nowDay) {
		LocalDate nowTime = null;
		try {
			nowTime = LocalDate.of(nowYear, nowMonth, nowDay);
		} catch (Exception e) {
			return false;
		}
		
		LocalDate startTime = LocalDate.of(startYear, startMonth, startDay);
		LocalDate endTime = LocalDate.of(endYear, endMonth, endDay);
		if(startTime.isAfter(nowTime)|| endTime.isBefore(nowTime))
			return false;
		
		return true;
	}

}
