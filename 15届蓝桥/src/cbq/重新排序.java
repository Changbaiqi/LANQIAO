package cbq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/4658/
 * @author ³¤°×Æé
 *
 */
public class ÖØÐÂÅÅÐò {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		
		Integer data[] = new Integer[n+1];
		long fs[] = new long[n+1];
		
		
		for(int i=1;i<=n;++i) {
			data[i] = sc.nextInt();
			fs[i] = data[i]+fs[i-1];
		}
		
		long ac[] = new long[n+2];
		int m = sc.nextInt();
		long rSum = 0;
		for(int i=1;i<=m;++i) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			ac[l]+=1;
			ac[r+1]-=1;
			rSum+=fs[r]-fs[l-1];
		}
		
		
		
		Arrays.sort(data,1,n+1,(a,b)->b-a);
		
		ArrayList<Long> opAr = new ArrayList<Long>();
		
		for(int i= 1;i<=n;++i) {
			long acc = ac[i]+=ac[i-1];
			if(acc>0) opAr.add(acc);
		}
		
		
		Collections.sort(opAr,(a,b)->b.compareTo(a));
		long sum =0;
		for(int i = 0;i<opAr.size();++i) {
			sum+=data[i+1]*opAr.get(i);
		}
		System.out.println(sum-rSum);
	}

}
