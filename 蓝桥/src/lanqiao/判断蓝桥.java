package lanqiao;

import java.util.Scanner;
import java.util.regex.Pattern;

public class еп╤ою╤ге {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String data = sc.next();
		
		if(data.matches("(?i)lanqiao"))
			System.out.println("yes");
		else
			System.out.println("no");
		
		
		
	}

}
