package lanqiao;

public class ResTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long ans=0;
		for(long i=1; i <=10707075L ; ++i) {
			if(gcd(i,2023)==1) {
				++ans;
			}
		}
		/**
		 * 1070----864
		 * 107070-----86376
		 * 10707075-----8637641
		 * 1070707501-----863764035
		 * 1070708501-----863764841
		 * 10707075013
		 */
		System.out.println(ans);
		//System.out.println(863764035%(1000000007));
	}

	public static long gcd(long a,long b) {
		return b==0?a:gcd(b,a%b);
	}

}
