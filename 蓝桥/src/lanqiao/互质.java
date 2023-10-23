package lanqiao;

import java.math.BigInteger;

public class ª•÷  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		long ans=0;
//		for(long i=10707075014L; i <=107070750133L ; ++i) {
//			if(gcd(i,2023)==1) {
//				++ans;
//			}
//		}
		
		BigInteger a1 = BigInteger.valueOf(2023);
		a1 = a1.pow(2023);
		
		//System.out.println(a1.subtract( a1.divide(BigInteger.valueOf(7)).add( a1.divide(BigInteger.valueOf(17)) ).subtract(  a1.divide(BigInteger.valueOf(7*17)) )).divideAndRemainder(BigInteger.valueOf(1000000007))[1]    );
		//640720414

		System.out.println(863764034%(1000000007));
		/**
		 * 1070----864
		 * 107070-----86376
		 * 1070707-----863764
		 * 10707075-----8637641
		 * 107070750-----86376404
		 * 1070707501-----863764035
		 * 10707075013-----8637640348
		 * 107070750133-----86376403469
		 */
		
		//System.out.println(ans);
//		
//		BigInteger bi = BigInteger.valueOf(2023);
//		System.out.println(bi.pow(2023));
		
	}
	
	public static long gcd(long a,long b) {
		return b==0?a:gcd(b,a%b);
	}

}
