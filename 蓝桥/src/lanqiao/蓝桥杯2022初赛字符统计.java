package lanqiao;

import java.util.Scanner;

public class ���ű�2022�����ַ�ͳ�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int data[] = new int['z'+1];
		
		int max =0;
		for(int i = 0;i <str.length() ; ++i) {
			++data[str.charAt(i)];
			max = Math.max(max, data[str.charAt(i)]);
		}
		for(int i= 0; i < data.length ; ++i) {
			if(data[i]!=max)
				continue;
			System.out.print((char)i);
		}
	}

}
