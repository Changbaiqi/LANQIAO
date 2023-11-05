package cbq;

import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/99/learning/?page=1&first_category_id=1&sort=students_count&name=%E5%88%86%E5%B7%A7%E5%85%8B%E5%8A%9B
 * @class 二分
 * @author 长白崎
 *
 */
public class 分巧克力 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		long w[] = new long[N];
		long h[] = new long[N];
		
		//输入数据
		for(int i=0;i < N; ++i) {
			w[i] = sc.nextLong();
			h[i] = sc.nextLong();
		}
		
		long l=0,r=(long)1e5;
		while(l<=r) {
			long mid = (l+r)/2;
			if(check(w,h,mid,K)) {
				l=mid+1;
			}else
				r=mid-1;
		}
		System.out.println(r);
	}
	
	static boolean check(long w[],long h[],long F,int K) {
		long ans =0;
		
		for(int i=0; i< w.length ; ++i) {
			ans+=(w[i]/F)*(h[i]/F);
		}
		if(ans<K)
			return false;
		return true;
	}

}
