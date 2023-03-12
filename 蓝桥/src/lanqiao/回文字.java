package lanqiao;

import java.util.Scanner;

public class ������ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			String str = sc.nextLine();
			System.out.println(polo_1(str));
		}	
	}
	
	
	
	public static int polo_1(String str) {
		char date[] = str.toCharArray();
		
		int maxLen = 0 ;
		for(int y = 0 ; y <date.length ; ++y) {
			for(int x =y ; x < date.length ; ++x) {
				String res = str.substring(y, x+1);
				if(check(res)) {
					maxLen = Math.max(res.length(), maxLen);
				}
			}
		}
		
		return maxLen;
		
	}
	
	public static boolean check(String resStr) {
		
		char c[] = resStr.toCharArray();
		for(int i = 0 ; i < resStr.length()/2 ; ++i) {
			if(c[i]!=c[resStr.length()-i-1]) {
				return false;
			}
		}
		
		return true;
	}
	
	
	

}
