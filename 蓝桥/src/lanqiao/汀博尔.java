package lanqiao;

import java.util.Scanner;

public class ͡���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long S = sc.nextLong();
		long L = sc.nextLong();
		
		long tree[] = new long[n];
		
		for(int i= 0; i < n ; ++i) {
			tree[i] = sc.nextLong();
		}
		
		long sz[] = new long[n];
		long max_sz=0;
		for(int i = 0; i < n ; ++i) {
			sz[i] = sc.nextLong();
			max_sz = Math.max(max_sz, sz[i]);
		}
		binarySearch(tree, sz, L, S,max_sz);
		
		
		
		
	}
	
	public static void binarySearch(long tree[],long sz[],long L,long S,long max_sz) {
		
		long l =0,r=((long)1e18/max_sz);
		while(l<=r) {
			long mid = (l+r)/2;
			if(check(mid,tree,sz,L,S))
				r = mid-1;
			else
				l = mid+1;
		}
		System.out.println(l);
		
	}
	public static boolean check(long month,long tree[],long sz[],long L,long S) {
		long sum = 0;
		
		long res_tree[] = new long[tree.length];
		for(int x = 0 ; x < tree.length ; ++x) {
			res_tree[x] = tree[x]+ (sz[x]*month);
			if(res_tree[x]>=L)
				sum+=res_tree[x];
			if(sum>=S)
				return true;
		}
		return false;
	}

}
