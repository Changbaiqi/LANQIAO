package lanqiao;

import java.util.Scanner;

public class ���ű�2022������׳� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		long l = 0,r = (long) 1e18;
		
		while(l<=r) {
			//if()
		}
	}
	
	public static boolean check(long mid,long num) {
		long sum =0;
		while(mid%5==0) {
			sum+=1;
			mid/=5;
		}
		
		if(sum<num)
		return false;
		return true;
	}

}
