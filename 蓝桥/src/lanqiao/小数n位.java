package lanqiao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class С��nλ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a= sc.nextInt();
		int b =sc.nextInt();
		int n = sc.nextInt();
		
		BigDecimal aa = BigDecimal.valueOf(a).setScale(n+3);
		BigDecimal bb = BigDecimal.valueOf(b).setScale(n+3);
 		BigDecimal data[] = aa.divideAndRemainder(bb);
        String d =data[1].setScale(n+3).toString().substring(n, n+3).toString();
		
		System.out.println(data[1].setScale(3).toString());
	}

}
