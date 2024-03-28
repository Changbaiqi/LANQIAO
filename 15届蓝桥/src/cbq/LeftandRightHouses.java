package cbq;

import java.util.Scanner;

/**
 * https://codeforces.com/contest/1945/problem/C
 * @author ³¤°×Æé
 *
 */
public class LeftandRightHouses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0) {
			int n = sc.nextInt();
			int arr[] = new int[n+2];
			char[] a = sc.next().toCharArray();
			for(int i=1;i<=n;++i) arr[i] = a[i-1]=='0'?0:1;
			
			//Ç°×ººÍ
			int b [] = new int[n+2];//0
			int c[] = new int[n+2];//1
			for(int i = 1;i<=n;++i) {
				b[i] +=b[i-1]+(arr[i]==0? 1:0);
				c[i] +=c[i-1]+(arr[i]==1? 1:0);
			}
			double min = Double.MAX_VALUE; int index =0;
			for(int i=0;i<=n;++i) {
				int l_zero = b[i];
				int r_one = c[n]-c[i];
				if(l_zero>=Math.round(i/2.0) && r_one>=Math.round((n-i)/2.0)) {
					if(min>Math.abs((double)n/2.0-i)) {
						min = Math.abs((double)n/2-i);
						index =i;
					}
				}
			}
			System.out.println(index);
			
		}
	}

}
