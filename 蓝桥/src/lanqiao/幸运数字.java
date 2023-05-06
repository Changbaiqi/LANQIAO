package lanqiao;

import java.math.BigInteger;
import java.util.Scanner;

public class 幸运数字 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long i =1 ;
		int sum =0;
		while(true) {
			if(check(BigInteger.valueOf(i))) {
				++sum;
			}
			
			if(sum==2023) {
				System.out.println(i);
				return;
			}
			++i;
		}
		
		
	}
	
	public static boolean check(BigInteger num) {
		String num2 = num.toString(2);
		String num8 = num.toString(8);
		String num10 = num.toString(10);
		String num16 = num.toString(16);
		
		//二进制
		BigInteger num2add  =  BigInteger.ZERO;
		for(int i= 0 ; i <num2.length() ;++i) {
			num2add = num2add.add(new BigInteger(num2.charAt(i)+"",2));
		}
		if(num.mod(num2add).compareTo(BigInteger.ZERO)!=0)
			return false;
		
		
		//八进制
		BigInteger num8add  =  BigInteger.ZERO;
		for(int i= 0 ; i <num8.length() ;++i) {
			num8add = num8add.add(new BigInteger(num8.charAt(i)+"",8));
		}
		if(num.mod(num8add).compareTo(BigInteger.ZERO)!=0)
			return false;
		
		
		//十进制
		BigInteger num10add  =  BigInteger.ZERO;
		for(int i= 0 ; i <num10.length() ;++i) {
			num10add = num10add.add(new BigInteger(num10.charAt(i)+"",10));
		}
		if(num.mod(num10add).compareTo(BigInteger.ZERO)!=0)
			return false;
		
		
		//十进制
		BigInteger num16add  =  BigInteger.ZERO;
		for(int i= 0 ; i <num16.length() ;++i) {
			num16add = num16add.add(new BigInteger(num16.charAt(i)+"",16));
		}
		if(num.mod(num16add).compareTo(BigInteger.ZERO)!=0)
			return false;
				
		
		
		
		
		return true;
	}

}
