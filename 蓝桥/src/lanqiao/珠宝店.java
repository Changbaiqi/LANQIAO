package lanqiao;

import java.util.Scanner;

public class ÷È±¶µÍ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//System.out.println((int)'A');
		int T = sc.nextInt();
		
		
		for(int i = 0; i < T ; ++i) {
			String str = sc.next();
			int ans =0;
			char cc[] = str.toCharArray();
			for(int x = 0 ; x< str.length(); ++x) {
				ans+=(cc[x]-64);
			}
			
			System.out.println(ans);
		}
		
		
	}

}