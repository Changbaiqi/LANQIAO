package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class 最大子矩阵 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int map[][] = new int[N][M];
		for(int y =0 ; y < map.length ; ++y) {
			for(int x =0 ;x < map[y].length ; ++x) {
				map[y][x] = sc.nextInt();
			}
		}
		
		int max_min[][][][] = new int[N][M][M][2];
		
		//计算每行指定区域最小值
		for(int y= 0 ;y < map.length ; ++y) {
			for(int x_1 = 0 ; x_1<M ; ++x_1) {
				for(int x_2 = x_1 ; x_2<M ; ++x_2) {
					int res[] = Arrays.copyOfRange(map[y], x_1, x_2+1);
					Arrays.sort(res);
					max_min[y][x_1][x_2][0] = res[res.length-1];
					max_min[y][x_1][x_2][1] = res[0];
					//System.out.println(Arrays.toString(res));
					                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
				}
			}
		}
		
		for(int x =0 ;x < map[0].length ; ++x) {
			for(int y =0 ; y < map.length ; ++y) {
				
			}
		}
		
		
		
		
		
		
	}

}
