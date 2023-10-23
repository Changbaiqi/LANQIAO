package cbq;

import java.math.BigInteger;
import java.util.Scanner;

public class P1255ÊýÂ¥ÌÝ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		BigInteger a =BigInteger.ZERO,b=BigInteger.ZERO,ans=BigInteger.ONE;
		for(int i=0 ;i < N ; ++i) {
			BigInteger res = b.add(BigInteger.ZERO);
			b = ans.add(BigInteger.ZERO);
			a = res.add(BigInteger.ZERO);
			ans = a.add(b);
		}
		System.out.println(ans.toString());
	}
	
	
	

}
