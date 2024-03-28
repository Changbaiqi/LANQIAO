package cbq;

import java.util.Scanner;

public class GCDisGreater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			
			long arr[] = new long[n+1];
			for(int i=1;i<=n;++i) {
//				arr[i]
			}
		}
	}
	
	
	/**
	 * gcd
	 * @param a
	 * @param b
	 * @return
	 */
	static long gcd(long a,long b) {
		return b==0?a:gcd(b,a%b);
	}

}
