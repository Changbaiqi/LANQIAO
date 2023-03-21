package lanqiao;

import java.util.Scanner;

public class �źŸ��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int w = sc.nextInt();
		int h= sc.nextInt();
		
		int n = sc.nextInt();
		int r = sc.nextInt();
		
		int jy[] = new int[n];
		int jx[] = new int[n];
		
		
		for(int i = 0 ; i < n ; ++i) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			jy[i] = y;
			jx[i] = x;
		}
		int ans=0;
		for(int y = 0 ; y <= h ; ++y) {
			for(int x= 0; x<= w; ++x) {
				for(int i = 0; i< n ; ++i) {
					if(check(jx[i],jy[i],r,x,y)) {
						++ans;
						break;
					}
				}
			}
		}
		
		System.out.println(ans);
	}
	
	
	
	
	public static boolean check(int cx,int cy,int r,int pointx,int pointy) {
		int rr = (int) (Math.pow((cx-pointx),2)+Math.pow((cy-pointy), 2));
		if(rr<=r*r)
			return true;
		
		return false;
	}

}
