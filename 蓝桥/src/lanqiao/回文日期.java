package lanqiao;

import java.time.LocalDate;
import java.util.Scanner;

public class 回文日期 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String time = sc.nextLine();
		
		polo_1(time);
		

	}
	
	//暴力
	public static void polo_1(String time) {
		
		String time_1 = time;
		while(true) {
			
			
			String year =  time_1.substring(0,4);
			String month = time_1.substring(4,6);
			String day = time_1.substring(6,8);

			
			String year_res = new StringBuffer(year).reverse().toString();
			
			int time_res = Integer.parseInt(year.toString()+year_res);
			
			int time_num = Integer.parseInt(time_1);
			if(time_res <= Integer.valueOf(time)) {
				time_1 = String.valueOf(Integer.parseInt(time_1)+((int)1e4));
				continue;
			}
			
			if( !polo_2(String.valueOf(time_res)) ){
				time_1 = String.valueOf(Integer.parseInt(time_1)+((int)1e4));
				continue;
			}
				
			System.out.println(time_res);
			break;
		}
		
		time_1 = time;
		while(true) {
			
			
			String year =  time_1.substring(0,4);
			String month = time_1.substring(4,6);
			String day = time_1.substring(6,8);

			//转置
			String year_res = new StringBuffer(year).reverse().toString();
			
			
			int time_res = Integer.parseInt(year.toString()+year_res);
			
			int time_num = Integer.parseInt(time_1);
			if(time_res <= Integer.parseInt(time)) {
				time_1 = String.valueOf(Integer.parseInt(time_1)+((int)1e4));
				continue;
			}
			
			if( !polo_2(String.valueOf(time_res)) ){
				time_1 = String.valueOf(Integer.parseInt(time_1)+((int)1e4));
				continue;
			}
			
			char time_char[] = String.valueOf(time_res).toCharArray();
			if(!(time_char[0]==time_char[2]&&
					time_char[2]==time_char[5]&&
					time_char[5]==time_char[7]&&
					time_char[1]==time_char[3]&&
					time_char[3]==time_char[4]&&
					time_char[4]==time_char[6])) {
				time_1 = String.valueOf(Integer.parseInt(time_1)+((int)1e4));
				continue;
			}
				
			System.out.println(time_res);
			break;
		}
		
	}
	
	//检测日期是否合格
	public static boolean polo_2(String time) {
		String year =  time.substring(0,4);
		String month = time.substring(4,6);
		String day = time.substring(6,8);
		try {
			LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	
	
	

}
