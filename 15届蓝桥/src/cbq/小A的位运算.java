package cbq;


import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/contest/71135/A
 * @class 位运算、前缀、后缀
 * @author 长白崎
 *
 */
public class 小A的位运算 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int data[] = new int[n+2];
		int a[] = new int[n+2];
		int b[] =  new int[n+2];
		
		for(int i= 1 ;i<= n ; ++i) {
			data[i] = sc.nextInt();
		}
		
		for(int i=1;i<=n;++i) a[i]=a[i-1]|data[i];
		for(int i=n;i>=1;--i) b[i]=b[i+1]|data[i];
		
		long max=0;
		
		for(int i=1;i<=n;++i) if((a[i-1]|b[i+1])>max) max=a[i-1]|b[i+1];
		System.out.println(max);
	}

}
