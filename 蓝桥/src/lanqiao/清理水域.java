package lanqiao;

import java.util.Scanner;

public class ����ˮ�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int t = sc.nextInt();
		
		int map[][] = new int[n][m];
		
		for(int i= 0; i< t ; ++i) {
			int min_x = m+1;
			int max_x =0;
			int min_y = n+1;
			int max_y = 0;
			
			int r1 = sc.nextInt();
			int c1 = sc.nextInt();
			
			int r2 = sc.nextInt();
			int c2 = sc.nextInt();
			
			min_y = Math.min(min_y, r1);
			min_y = Math.min(min_y, r2);
			max_y = Math.max(max_y, r1);
			max_y = Math.max(max_y, r2);
			
			min_x = Math.min(min_x, c1);
			min_x = Math.min(min_x, c2);
			max_x = Math.max(max_x, c1);
			max_x = Math.max(max_x, c2);
			
			
			for(int y= min_y-1; y< max_y ; ++y ) {
				for(int x= min_x-1; x< max_x ; ++x) {
					map[y][x] =1;
				}
			}
			
			
		}
		
		int sum =0;
		for(int y= 0; y< n ; ++y ) {
			for(int x= 0; x< m ; ++x) {
				if(map[y][x]==0)
					++sum;
			}
		}
		
		System.out.println(sum);
		
		
		
	}

}
