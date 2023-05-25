package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P1824
 * @author 长白崎
 *
 */
public class 进击的奶牛 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N =sc.nextInt();
		int C = sc.nextInt();
		
		int data[] = new int[N+1];
		for(int i=1 ; i <= N ; ++i) {
			data[i] = sc.nextInt();
		}
		
		Arrays.sort(data,1,N ); 
		System.out.println(binarySearch(data, N-C));
		
	}
	
	
	//二分查找
	public static int binarySearch(int data[],int dif) {
		int l =1 ; 
		int r = data[data.length-1]-data[1];
		while(l+1<r) {
			int mid = (l+r)/2;
			if(check(mid,data,dif))
				l=mid;
			else
				r =mid;
		}
		if(check(r,data,dif))
			return r;
		else
			return l;
	}
	
	//check函数
	public static boolean check(int num,int data[],int dif) {
		int x =0 ;
		int l = data[1];
		for(int i=2 ; i <=data.length-1; ++i) {
			if(data[i]-l<num) ++x;
			else l =data[i];
			if(x>dif) return false;
		}
		return true;
	}

}
