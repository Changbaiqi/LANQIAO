package cbq;

import java.util.Arrays;
import java.util.Scanner;

public class Íæ¾ß {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer data[] = new Integer[n];
		for(int i=0 ;i < n ; ++i) {
			data[i] = sc.nextInt();
		}
		Arrays.sort(data,(a,b)->b-a);
		
		
		
		
	}

}
