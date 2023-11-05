package cbq;

import java.util.Scanner;

public class ÆÌµØ°åËã·¨Èü {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i <=T ; ++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a>b) {
				int c = a;
				a = b;
				b = c;
			}
			
			if(a>=2 && b>=3 && (a*b%6)==0) {
				System.out.println("Yes");
			}else
				System.out.println("No");
		}
	}

}
