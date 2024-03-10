package cbq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/description/5410/
 * @author 长白崎
 * @class 二分、区间合并
 */
public class 管道5407 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //会打开的阀门数
		int len = sc.nextInt(); //管道长度
		
		int L[]=new int[n]; //表示第L段管道的阀门
		int S[]=new int[n]; //表示对应第L段管道阀门会在S时刻打开
		
		
	
		//输入数据
		for(int i = 0;i<n;++i) {
			L[i] = sc.nextInt();
			S[i] = sc.nextInt();
		}
	
		long l =0,r = 2000000000,mid =0;
		while(l<r) {
			mid = (l+r+1)>>1;
		if(!check(L,S,n,len,mid))
			l=mid;
		else
			r=mid-1;
		}
//		if(!check(L,S,n,len,r)) {
//			System.out.println(r+1);
//			return;
//		}
			
		System.out.println(r+1);
	}
	
	
	
	static boolean check(int L[],int S[],int n,int len,long mid) {
		ArrayList<long[]> list = new ArrayList<long[]>();
		for(int i= 0;i< n;++i) {
			if(mid<S[i])
				continue;
			list.add(new long[] {L[i]-(mid-S[i]),L[i]+(mid-S[i])});
		}
		if(list.size()==0)
			return false;
		
		Collections.sort(list,(a,b)-> (int)(a[0]-b[0]));
		long min = list.get(0)[0],max=list.get(0)[1];
		for(int i= 1;i<list.size();++i) {
			if(max+1<list.get(i)[0])
				return false;
			max = Math.max(max, list.get(i)[1]);
		}
		if(min>1 || max<len)
			return false;
		return true;
	}

}
