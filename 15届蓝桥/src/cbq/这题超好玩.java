package cbq;

import java.util.Arrays;
import java.util.Scanner;

public class 这题超好玩 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		//输入
		String s = sc.next();
		
		String leadZero ="";
		//判断长度是否为5的倍数
		if(s.length()%5!=0)
			for(int i=0; i < 5-s.length()%5;++i) {
				leadZero+="0";
			}
		
		char data[] = (leadZero+s).toCharArray();
		
//		for() {
//			
//		}
		
	}
}
