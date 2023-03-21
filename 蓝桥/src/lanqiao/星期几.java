package lanqiao;

import java.util.Scanner;

public class ÐÇÆÚ¼¸ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int w = sc.nextInt();
		
		int n = (sc.nextInt()+w)%7;
		if(n==0)
			System.out.println(7);
		else
			System.out.println(n);
		
		
		
	}

}
