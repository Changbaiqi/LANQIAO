package cbq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class µÚkÐ¡ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long m = sc.nextLong();
		int k = sc.nextInt();
		ArrayList<Long> data= new ArrayList<Long>();
		for(int i =0 ; i < n ; ++i) {
			data.add(sc.nextLong());
		}
		for(int i= 0; i < m; ++i) {
			int op = sc.nextInt();
			if(op==1) {
				data.add(sc.nextLong());
			}else {
				Collections.sort(data);
				System.out.println(data.get(k-1));
			}
		}
	}

}
