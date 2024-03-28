package cbq;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 无
 * @author 长白崎
 * @class["第十四届蓝桥杯JavaB组国赛"]
 */
public class C礼物 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long arr[] = new long[n*2];
		for(int i=0;i<n*2;++i) {
			arr[i] = sc.nextLong();
		}
		
		Arrays.sort(arr);
		long sum =0;
		for(int i = 0;i<n;++i) {
			sum+=arr[i]+arr[(2*n-1)-i];
		}
		
		System.out.println(sum);
		
	}

}
