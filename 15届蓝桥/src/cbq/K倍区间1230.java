package cbq;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/description/1232/
 * @author 长白崎
 * @class 前缀和、思维题
 *
 */
public class K倍区间1230 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //数列长度
		int K = sc.nextInt(); //K倍区间
		
		long arr[] = new long[N+1]; //前缀和
		
		long cnt[]= new long[100000001];cnt[0]=1;
		for(int i=1 ;i<=N;++i) {
			int num = sc.nextInt();
			arr[i] = arr[i-1]+num;
		}
		
		
		long ans = 0;
		for(int i=1;i<=N;++i) {
			ans+=cnt[(int)arr[i]%K];
			++cnt[(int)arr[i]%K];
		}
		
		System.out.println(ans);
		
		
	}

}
