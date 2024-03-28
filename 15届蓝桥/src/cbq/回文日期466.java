package cbq;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/468/
 * @author 长白崎
 * @class["日期","回文"]
 */
public class 回文日期466 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String start = sc.next();
		String end = sc.next();
		
		int ans =0;
		for(int nowYear = Integer.parseInt(start.substring(0, 4));nowYear <=Integer.parseInt(end.substring(0, 4));++nowYear) {
			String now = String.valueOf(nowYear)+(new StringBuffer(String.valueOf(nowYear)).reverse().toString());
			if(check(now,start,end))
				++ans;
		}
		System.out.println(ans);
		
	}
	
	static boolean check(String now, String start,String end) {
		LocalDate nowDate = null;
		try {			
			nowDate = LocalDate.parse(now,DateTimeFormatter.ofPattern("yyyyMMdd"));
			String res = nowDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
			if(!res.equals(now)) return false;
		}catch (Exception e) {
			return false;
		}
		LocalDate startDate = LocalDate.parse(start,DateTimeFormatter.ofPattern("yyyyMMdd"));
		LocalDate endDate = LocalDate.parse(end,DateTimeFormatter.ofPattern("yyyyMMdd"));
		if(startDate.isAfter(nowDate) || endDate.isBefore(nowDate))
			return false;
		return true;
	}

}
