package cbq;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/1231/
 * @author 长白崎
 * @class ["日期"]
 *
 */
public class 日期问题 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String time  = sc.next();
		
		String sl[] = time.split("/");
		int arr[] = new int[3];
		
		for(int i=0;i<3;++i) {
			arr[i] = Integer.parseInt(sl[i]);
		} 
		
		int data[][] = new int[][] {
			{arr[0],arr[1],arr[2]},
			{arr[2],arr[0],arr[1]},
			{arr[2],arr[1],arr[0]}
		};
		
		HashSet<String> map = new HashSet<String>();
		ArrayList<int[]> cData = new ArrayList<int[]>();
		
		
		for(int i=0 ;i<data.length;++i) {
			
			if(check(1900+data[i][0],data[i][1],data[i][2]) && !map.contains(1900+data[i][0]+"-"+data[i][1]+"-"+data[i][2])) {
				cData.add(new int[] {1900+data[i][0],data[i][1],data[i][2]});
				map.add(1900+data[i][0]+"-"+data[i][1]+"-"+data[i][2]);
			}
			if(check(2000+data[i][0],data[i][1],data[i][2])&& !map.contains(2000+data[i][0]+"-"+data[i][1]+"-"+data[i][2])) {
				cData.add(new int[] {2000+data[i][0],data[i][1],data[i][2]});
				map.add(2000+data[i][0]+"-"+data[i][1]+"-"+data[i][2]);
			}
		}
		
		Collections.sort(cData,(a,b)->{
			LocalDate atime = LocalDate.of(a[0], a[1], a[1]);
			LocalDate btime = LocalDate.of(b[0], b[1], b[1]);
			if(atime.isAfter(btime))
				return 1;
			else if(atime.isBefore(btime))
				return -1;
			else
				return 0;

		});
		
		for(int i =0 ;i<cData.size();++i) {
			System.out.printf("%04d-%02d-%02d\n",cData.get(i)[0],cData.get(i)[1],cData.get(i)[2]);
		}
	}

	/**
	 * 判断日期合法性
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	static boolean check(int year,int month ,int day) {
		
		LocalDate time  = null;
		//日期不合法
		try {
		time = LocalDate.of(year, month, day);
		}catch (Exception e) {
			return false;// TODO: handle exception
		}
		
		LocalDate forward = LocalDate.of(1960, 1, 1);
		LocalDate late = LocalDate.of(2059, 12, 31);
		
		if((forward.isBefore(time) || forward.isEqual(time))&& (late.isAfter(time))|| time.isEqual(late)) {
			return true;
		}
		
		return false;
	}

}
