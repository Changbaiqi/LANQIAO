package lanqiao;

import java.math.BigInteger;

public class ×ÖÄ¸Êý {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		long i =2022;
		
		while(true) {
			char turn[] = BigInteger.valueOf(i).toString(16).toCharArray();
			boolean sw= true;
			for(int x = 0 ;x < turn.length ; ++i) {
				if( turn[x]<'a' || turn[x]>'z') {
					sw = false;
					break;
				}
			}
			if(sw) {
				System.out.println(turn);
				return;
			}
			++i;
		}
		
	}

}
