package cbq;

import java.util.Scanner;

public class SettingupCamp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			long a = sc.nextLong();
			long b = sc.nextLong();
			long c = sc.nextLong();
			
			
			if(c==0) {
				if(b%3==0) {System.out.println(a+b/3);}else System.out.println(-1);
			}else {
				long dif = b%3;
				if(dif==0) System.out.println(a+(b+c)/3+((b+c)%3==0?0:1));else
				if((3-dif)>c) System.out.println(-1);else System.out.println(a+(b+c)/3+((b+c)%3==0?0:1));
				
			}
		}
	}

}
