package cbq;

import java.util.Arrays;
import java.util.Scanner;

public class ���ⳬ���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		//����
		String s = sc.next();
		
		String leadZero ="";
		//�жϳ����Ƿ�Ϊ5�ı���
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
