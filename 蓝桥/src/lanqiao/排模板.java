package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class еедё╟Е {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Integer data[] = new Integer[N];
		
		for(int i=0 ; i < N ; ++i) {
			data[i] = sc.nextInt();
		}
		Arrays.sort(data);
		System.out.println(Arrays.toString(data).replace(",", "").replace("[", "").replace("]", ""));
		Arrays.sort(data,(x,y)-> y-x);
		System.out.println(Arrays.toString(data).replace(",", "").replace("[", "").replace("]", ""));
		
	}

}
