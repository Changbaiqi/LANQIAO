package lanqiao;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 走迷宫 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		//迷宫行走状态
		int state[][] = new int[N+1][M+1];
		
		//地图
		int map[][] = new int[N+1][M+1];
		for(int y = 1 ; y <=N ; ++y) {
			for(int x=1 ; x <=M ; ++x) {
				map[y][x] = sc.nextInt();
			}
		}
		
		int startX = sc.nextInt();
		int startY = sc.nextInt();
		int endX = sc.nextInt();
		int endY = sc.nextInt();
		
		map[startY][startX] = 1;
		map[endY][endX] = 1;
		System.out.println(bfs(state,map,startX,startY,endX,endY));
		
		
	}
	
	public static void pr(int map[][]) {
		for(int y=1 ; y<=map.length-1 ; ++y) {
			for(int x= 1; x <=map[y].length-1 ; ++x) {
				System.out.print(map[y][x]+" ");
			}
			System.out.println();
		}
	}
	
	public static long bfs(int state[][],int map[][],int startX,int startY,int endX,int endY) {
		Queue<int[]> qu = new LinkedList<>();
		
		
		//加入起点
		qu.add(new int[] {startX,startY,0});
		state[startY][startX] = 1;
		while(!qu.isEmpty()) {
			
			//出队
			int xy[] = qu.poll();
			
			//判断是否为终点
			if(xy[0]==endX && xy[1]==endY) {
				pr(map);
				//System.out.println(map[xy[1]][xy[1]]);
				//System.out.println();
				//pr(state);
				return xy[2];
			}
			
			
			//枚举下一步
			int next[][] = {
					{xy[0],xy[1]-1},
					{xy[0],xy[1]+1},
					{xy[0]-1,xy[1]},
					{xy[0]+1,xy[1]}
			};
			
			for(int i=0 ; i <next.length ; ++i) {
				
				//过滤越界
				if(next[i][0]<1 || next[i][1]<1 || next[i][1]>map.length-1 || next[i][0]>map[0].length-1)
					continue;
				//过滤障碍
				if(map[next[i][1]][next[i][0]] ==0)
					continue;
				//过滤走过的路
				if(state[next[i][1]][next[i][0]]==1)
					continue;
				
				state[next[i][1]][next[i][0]] = 1;
				//加入队列
				qu.offer(new int[] {next[i][0],next[i][1],xy[2]+1});
			}
			
		}
		
		return -1;
		
	}

}
