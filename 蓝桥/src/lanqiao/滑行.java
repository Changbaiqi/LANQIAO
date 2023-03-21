package lanqiao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 滑行 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n  = sc.nextInt();
		int m = sc.nextInt();
		
		int map[][] = new int[n][m];
		Co co[] = new Co[n*m];
		
		for(int y =0 ,c=0; y < n ; ++y) {
			for(int x = 0; x < m; ++x,++c) {
				map[y][x] = sc.nextInt();
				co[c] = new Co(map[y][x],y,x);
			}
		}
		Arrays.sort(co,(y,x)-> x.getData()-y.getData());
		

		int cc= check(map,co);
		System.out.println(cc);
	}
	
	public static int check(int map[][],Co[] co) {
		int dp[][] = new int[map.length][map[0].length];
		//初始化
		for(int i = 0; i < dp.length ; ++i) {
			Arrays.fill(dp[i], 0);
		}
		
		int max =0;
		for(int c= 0; c < co.length ; ++c) {
			int point[] = new int[] {co[c].getX(),co[c].getY()};
			
			//可能走的格子
			int next[][]= {
					{point[0],point[1]-1},
					{point[0],point[1]+1},
					{point[0]-1,point[1]},
					{point[0]+1,point[1]}
			};
			
			
			for(int i= 0 ; i < next.length ; ++i) {
				//过滤
				if(next[i][0]<0 || next[i][1]<0 || next[i][0]>=map[0].length || next[i][1]>=map.length )
					continue;
				if(map[next[i][1]][next[i][0]] > map[point[1]][point[0]])
					continue;
				
				int res = dp[point[1]][point[0]]+1;
				if(res > dp[next[i][1]][next[i][0]]) {
					dp[next[i][1]][next[i][0]] = res;
					max = Math.max(max, res);
				}
				
			}
			
			
		}
		
		return max;
	}

}

class Co{
	int data;
	int y;
	int x;
	public Co(int data, int y, int x) {
		super();
		this.data = data;
		this.y = y;
		this.x = x;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	
}
