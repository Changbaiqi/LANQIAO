package cbq;

public class »¥ÖÊ {

	static final long MOD = (long)1e9+7;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		long sum1 = qpow(2,25)/7%MOD;
//		long sum2 = qpow(2,2023)/17%MOD;
//		long sum3 = qpow(2,2023)/(7*17)%MOD;
//		long sum4 = qpow(2,2023)%MOD;
//		System.out.println(sum4-sum1-sum2+sum3);
	solve();	
	}
	
	/**
	 * ¿ìËÙÃÝ
	 * @param a
	 * @param b
	 * @return
	 */
	static long qpow(long a,long b) {
		long sum = 1;
		while(b>0) {
			if(b%2==1) sum = sum*a%MOD;
			a= a*a%MOD;
			b>>=1;
		}
		return sum;
	}
	static long fpow(long a,long b) {
    	long res = 1;
    	a%=MOD;
    	while(b>0) {
    		if(b%2==1) res = res*a%MOD;
    		a = a*a%MOD;
    		b/=2;
    	}
    	return res;
    }
    
    static void solve() {
    	long res=fpow(2023,2023);
    	long a = fpow(2023,2023)*fpow(7,MOD-2)%MOD;
    	long b = fpow(2023,2023)*fpow(17,MOD-2)%MOD;
    	long c = fpow(2023,2023)*fpow(7*17,MOD-2)%MOD;
    	res = (res-a-b +c+2*MOD)%MOD;
    	System.out.println(res);
    	
	}

}
