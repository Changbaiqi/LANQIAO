package cbq;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/2870/
 * @author 长白崎
 * @class ["日期类"]
 */
public class 回文日期 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int time = sc.nextInt(); //日期
		
		
		int oldYear = time/10000;
		int oldMonth = time%10000/100;
		int oldDay = time%10000%100;
		
		int resYear = Integer.parseInt(new StringBuffer(String.valueOf(oldYear)).reverse().toString()); //镜像年
		
		int newYear = oldYear;
		int newMonth = resYear/100;
		int newDay = resYear%100;

		while(!check(oldYear,oldMonth,oldDay,newYear,newMonth,newDay)) {
			++newYear;
			resYear = Integer.parseInt(new StringBuffer(String.valueOf(newYear)).reverse().toString()); //镜像年
			newMonth = resYear/100;
			newDay = resYear%100;
		}
		
		System.out.println(newYear+(new StringBuffer(newYear+"").reverse().toString()));
		
		while(!check(oldYear,oldMonth,oldDay,newYear,newMonth,newDay) || !check2(newYear)) {
			++newYear;
			resYear = Integer.parseInt(new StringBuffer(String.valueOf(newYear)).reverse().toString()); //镜像年
			newMonth = resYear/100;
			newDay = resYear%100;
		}
		
		System.out.println(newYear+(new StringBuffer(newYear+"").reverse().toString()));
		
	}
	
	/**
	 * 检测日期合规性
	 * @param oldYear
	 * @param oldMonth
	 * @param oldDay
	 * @param newYear
	 * @param newMonth
	 * @param newDay
	 * @return
	 */
	static boolean check(int oldYear,int oldMonth,int oldDay,int newYear,int newMonth,int newDay) {
		LocalDate oldTime = LocalDate.of(oldYear, oldMonth, oldDay);
		LocalDate newTime = null;
		
		//如果日期不合规
		try {
			newTime = LocalDate.of(newYear, newMonth, newDay);
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		
		if(oldTime.isAfter(newTime) || oldTime.isEqual(newTime))
			return false;
		
		return true;
	}
	
	static boolean check2(int newYear) {
		char arr[] = String.valueOf(newYear).toCharArray();
		
		if(arr[0]==arr[2] && arr[1]==arr[3] && arr[0]!=arr[1])
			return true;
		
		return false;
	}
	
	

}
