package lanqiao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ȫ���ů {

	static int ans = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		char map[][] = new char[N][N];
		int state[][] = new int[N][N];
		
		for(int i = 0 ; i < N ; ++i) {
			map[i] = sc.next().toCharArray();
		}
		
		
		for(int y =0 ; y < N ; ++y) {
			for(int x = 0; x < N ; ++x) {
				if(map[y][x]!='#' || state[y][x]==1)
					continue;
				bfs(map,state,x,y);
			}
		}
		
		System.out.println(ans);
		
		
	}
	
	public static void bfs(char map[][],int state[][],int startX,int startY) {
		
		Queue<int[]> data = new LinkedList<int[]>();
		data.add(new int[] {startX,startY});
		boolean sw = false;
		while(!data.isEmpty()) {
			int point[] = data.poll();
			
			int next[][] = {
					{point[0],point[1]-1},
					{point[0],point[1]+1},
					{point[0]-1,point[1]},
					{point[0]+1,point[1]},
			};
			
			
			
			int num=0;
			int isNotWater = 0; 
			for(int i= 0; i < next.length ; ++i) {
				
				if(next[i][0]<0 || next[i][1] < 0 || next[i][1] >= map.length || next[i][0] >= map[0].length)
					continue;
				
				++num;
				
				if(map[next[i][1]][next[i][0]]!='#')
					continue;
				
				++isNotWater;
				if(state[next[i][1]][next[i][0]]==1)
					continue;
				
				
				state[next[i][1]][next[i][0]] = 1;
				data.offer(new int[] {next[i][0],next[i][1]});
			}
			if(num==isNotWater)
				sw = true;
		}
		
		if(!sw) {
			++ans;
		}
		
		
		
		
	}

}
