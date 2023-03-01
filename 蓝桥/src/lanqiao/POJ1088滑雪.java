package lanqiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * P描述

Michael喜欢滑雪百这并不奇怪， 因为滑雪的确很刺激。可是为了获得速度，滑的区域必须向下倾斜，而且当你滑到坡底，你不得不再次走上坡或者等待升降机来载你。Michael想知道载一个区域中最长的滑坡。区域由一个二维数组给出。数组的每个数字代表点的高度。下面是一个例子

 1 2 3 4 5 
16 17 18 19 6
15 24 25 20 7
14 23 22 21 8
13 12 11 10 9

一个人可以从某个点滑向上下左右相邻四个点之一，当且仅当高度减小。在上面的例子中，一条可滑行的滑坡为24-17-16-1。当然25-24-23-...-3-2-1更长。事实上，这是最长的一条。


 * @author 20840
 *
 */
public class POJ1088滑雪 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int map[][] = new int[h][w];
		int dp[][] = new int[h][w];
		for(int y =0 ; y < h ; ++y) {
			for(int x = 0; x <w ; ++x) {
				dp[y][x]  = 1;
			}
		}
		
		
		ArrayList<Point> data = new ArrayList<Point>();
		
		for(int y =0 ;y < w ; ++y) {
			for(int x = 0; x < h ; ++x) {
				map[y][x]= sc.nextInt();
				Point point = new Point(y,x,map[y][x]);
				data.add(point);
			}
		}
		
		//排序点位
		Collections.sort(data);

		//从大到小dp
		data.forEach(i->{
			int next[][] = {
				{i.y-1,i.x},
				{i.y+1,i.x},
				{i.y,i.x-1},
				{i.y,i.x+1}
			};
			
			for(int x= 0 ; x < 4 ; ++x) {
				if(next[x][0]<0 || next[x][1]<0 || next[x][0]>=h || next[x][1]>=w)
					continue;
				
				if(map[next[x][0]][next[x][1]] >= i.num)
					continue;
				
				dp[next[x][0]][next[x][1]]= dp[i.y][i.x]+1 > dp[next[x][0]][next[x][1]]? dp[i.y][i.x]+1:dp[next[x][0]][next[x][1]]; 
				
			}
		});
		
		//循环获取最大值
		int max =0;
		for(int y = 0 ; y < h; ++y) {
			for(int x =0 ; x < w ; ++x) {
				 max = max < dp[y][x] ? dp[y][x] : max;  
			}
		}
		
		System.out.println(max);
		
	}
	
	

}

class Point implements Comparable<Point>{
	int y;
	int x;
	int num;
	Point(int y,int x,int num) {
		this.y = y;
		this.x = x;
		this.num = num;
	}
	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		return o.num-this.num;
	}
	
}

