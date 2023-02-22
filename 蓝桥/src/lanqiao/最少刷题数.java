package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class 最少刷题数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub、
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int mid = N/2;
		
		int data[] = new int[N];
		for(int i = 0 ; i < N ; ++i) {
			data[i] = sc.nextInt();
		}
		
		int resArr[] = Arrays.copyOf(data, N);
		
		Arrays.sort(data);
		
		for(int i = 0 ; i < N ; ++i){
			System.out.print(  (int)(data[mid]-resArr[i] >0 ? data[mid]-resArr[i]+1 : 0) + " " );
		}
		
		
		
	}

}
