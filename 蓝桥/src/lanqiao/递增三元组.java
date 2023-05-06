package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class 递增三元组 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Integer a[] = new Integer[N];
		Integer b[] = new Integer[N];
		Integer c[] = new Integer[N];
		
		for(int i = 0; i < a.length ; ++i) {
			a[i] = sc.nextInt();
		}
		for(int i = 0; i < a.length ; ++i) {
			b[i] = sc.nextInt();
		}
		for(int i = 0; i < a.length ; ++i) {
			c[i] = sc.nextInt();
		}
		
		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);
		
		int ai =0,bi=0,ci=0;
		int ans =0;
		
		while(bi<b.length) {
			while(ai<a.length && a[ai]<b[bi])
				++ai;
			while(ci<c.length &&c[ci]<=b[bi])
				++ci;
			ans+=ai*(a.length-ci);
			++bi;
		}
		System.out.println(ans);
	}

}
