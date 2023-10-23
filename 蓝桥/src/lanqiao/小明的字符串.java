package lanqiao;

import java.util.Scanner;

public class Ğ¡Ã÷µÄ×Ö·û´® {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String strF = sc.next();
		String strS = sc.next();
		
		for(int i =strS.length() ; i>0 ; --i) {
			if(strF.contains(strS.substring(0, i))) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
}
