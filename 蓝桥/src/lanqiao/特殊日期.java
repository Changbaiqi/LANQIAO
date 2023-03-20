package lanqiao;

import java.time.LocalDate;
import java.util.Scanner;

public class �������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int sum = 0 ;
		for (int i = 19000101; i <= 99991231; ++i) {
			if (check(i)) 
				++sum;
		}
		System.out.println(sum);

	}

	public static boolean check(int date) {
		char data[] = String.valueOf(date).toCharArray();
		
		int year = (data[0]-'0')*1000+(data[1]-'0')*100+(data[2]-'0')*10+(data[3]-'0')*1;
		int month = (data[4]-'0')*10+(data[5]-'0')*1;
		int day = (data[6]-'0')*10+(data[7]-'0')*1;
		
		
		try {
			LocalDate.of(year, month, day);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		int left = (data[0]-'0')+(data[1]-'0')+(data[2]-'0')+(data[3]-'0');
		int right = ((data[4]-'0')+(data[5]-'0'))+((data[6]-'0')+(data[7]-'0'));
		if(left!=right) {
			return false;
		}

		return true;
	}

}