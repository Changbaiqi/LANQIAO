package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class 试试看贪心 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		//早上
		int light[] = new int[n];
		
		//晚上
		int right[] = new int[n];
		
		int c[] = new int[n];
		
		long sum = 0 ;
		for(int i = 0 ; i < light.length ; ++i) {
			light[i] = sc.nextInt();
		}
		
		for(int i = 0 ; i < right.length ; ++i) {
			right[i] = sc.nextInt();
			sum+=right[i];
			c[i] = light[i]-right[i];
		}
		
		Arrays.sort(c);
		
		for(int i = n-1; i >= n-k ; --i) {
			sum+=c[i];
		}
		
		System.out.println(sum);

		
	}

}
