package cbq;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/5129/learning/?contest_id=144
 * @class 二分，贪心
 * @author 长白崎
 *
 */
public class 分组 {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int data[] = new int[n];
		
		for(int i =0;i < n ; ++i) {
			data[i] = sc.nextInt();
		}
		
		Arrays.sort(data);
		
		int l=0,r = data[n-1]-data[0];
		while(l<=r) {
			int mid =l+ (r-l)/2;
			if(check(data,k,mid))
				r = mid-1;
			else
				l = mid+1;
			
		}
		System.out.println(l);
	}
	
	static boolean check(int data[],int k,int mid) {
		int trim = 1,word = data[0];
		for(int i=1 ; i < data.length ; ++i) {
			if(data[i]-word>mid) {
				++trim;
				word = data[i];
			}	
		}
		return trim<=k;
	}
	

}
