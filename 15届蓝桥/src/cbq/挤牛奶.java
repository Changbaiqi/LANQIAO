package cbq;

import java.util.Arrays;
import java.util.Scanner;
/**
 * https://www.acwing.com/problem/content/1345/
 * @author 长白崎
 * @class ["区间合并","差分"]
 */
public class 挤牛奶 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
//		ArrayList<long[]> arr = new ArrayList<long[]>();
		Node[] arr = new Node[N+1];arr[0] = new Node(0,0);
		for(int i= 1;i<=N;++i) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			arr[i]=new Node(l,r);
		}
		
		Arrays.sort(arr,1,N+1,(a,b)->(int)(a.l-b.l));
	
		long resMin =arr[1].l; long resMax =arr[1].l;long max=0;
		long noMaxTime =0;
		for(int i = 1; i<=N;++i) {
			if(arr[i].l-resMax<=0) { resMax = Math.max(resMax,arr[i].r); max = Math.max(max, resMax-resMin);continue;}
			noMaxTime = Math.max(noMaxTime, arr[i].l-resMax);
			resMin = arr[i].l; resMax = arr[i].r;
			if(max<arr[i].r-arr[i].l){resMin = arr[i].l;resMax=arr[i].r;max =resMax-resMin;}
		}
		System.out.println(max+" "+noMaxTime);
	}
	static class Node{
		int l = 0;
		int r = 0;
		public Node(int l,int r) {this.l=l;this.r=r;}
	}

}
