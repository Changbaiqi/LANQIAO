package lanqiao;

import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P1182
 * @author 长白崎
 *
 */
public class 数列分段SectionII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt(); //多少个数字
		int M = sc.nextInt(); //要分多少个组
		
		//用于存储输入的数据
		int data[] = new int[N+1];
		int l = 0; //用于记录最大值
		int r = 0;
		for(int i=1 ; i <=N ; ++i) {
			data[i] = sc.nextInt();
			l  =  l>data[i]?l:data[i]; //对比选出二分左值
			r +=data[i]; //二分右值
		}
		
		System.out.println(binarySearch(data, l, r, M));
		
		
		
		
	}
	
	
	//二分查找
	public static int binarySearch(int data[],int l,int r,int M) {
		
		while(l<=r) {
			int mid = l+r >>1;
			if(check(data,mid,M))
				l=mid+1;
			else
				r = mid-1;
		}
		return l;
	}
	
	//check函数
	public static boolean check(int data[],int n,int M) {
		int ans =0;
		int index = 0;
		for(int i=1 ; i<data.length-1; ++i) {
			if(ans+data[i]<=n)
				ans+=data[i];
			else {
				ans=data[i];
				++index;
			}
		}
		return index>=M?true:false;
	}

}
