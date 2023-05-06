package lanqiao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Ö±Ïß {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		HashSet<String> data = new HashSet<String>();
		HashSet<Integer> data1 = new HashSet<>();
		for(int y1=0 ; y1 < 21 ; ++y1) {
			for(int x1 =0 ; x1< 20 ; ++x1) {
				for(int y2=y1+1 ; y2 < 21 ; ++y2) {
					for (int x2 = 0; x2 < 20; ++x2) {
		
						
						
						int a1 = x2-x1;
						int a2=(y2-y1);
						int a3 = (-x1*(y2-y1)+y1*(x2-x1));
						
						if(a2==0|| a1==0 || a3==0) {
							data1.add(y2);
							continue;
						}
						
						
						int c = gcd(a1==0?1:a1,a2==0?1:a2);
						
						int cc =gcd(c==0?1:c,a3==0?1:a3);
						cc= cc==0?1:cc;
						a1/=cc;
						a2/=cc;
						a3/=cc;
						data.add(a1+"-"+a2+"-"+a3);
					}
				}
			}
		}
		System.out.println(data.size());
		
	}

	public static int gcd(int x,int y) {
		return x%y==0? y:gcd(y,x%y);
	}

}
