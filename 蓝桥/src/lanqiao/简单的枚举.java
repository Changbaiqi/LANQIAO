package lanqiao;

import java.util.Scanner;

public class �򵥵�ö�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		char s[] = sc.next().toCharArray();
		
		int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
		int data[] = new int[220];
		for(int i = 0; i < s.length ; ++i) {
			++data[s[i]];
		}
		
		for(int i =97 ; i <= 122 ; ++i) {
			if(data[i]==0)
				continue;
			min = Math.min(min, data[i]);
			max = Math.max( max, data[i]);
		}
		
		if( check((max-min)) ) {
			System.out.println("Lucky Word");
			System.out.println(max-min);
		}else {
			System.out.println("No Answer");
			System.out.println(0);
		}
		
		
	}
	
	
	public static boolean check(int num) {
		if(num==0 || num==1)
			return false;
		
		
		
		for(int i = 2 ; i < Math.sqrt(num);++i) {
			if(num/i==0)
				return false;
		}
		return true;
	}
}
