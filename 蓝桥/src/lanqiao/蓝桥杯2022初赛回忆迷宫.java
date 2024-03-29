package lanqiao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ���ű�2022���������Թ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String move = sc.next();
		solve(move);
	}
	
	
	public static void solve(String move) {
		int map[][] = new int[210][210];
		
		int x=105,y=105;
		int minX=210,minY =210;
		int maxX =0,maxY = 0;
		
		map[y][x] = 1;
		for(int i = 0; i < move.length() ; ++i ) {
			if(move.charAt(i)=='U')
				--y;
			if(move.charAt(i)=='D')
				++y;
			if(move.charAt(i)=='L')
				--x;
			if(move.charAt(i)=='R')
				++x;
			minX = Math.min(minX, x);
			minY = Math.min(minY, y);
			maxX = Math.max(maxX, x);
			maxY = Math.max(maxY, y);
			
			map[y][x] = 1;
		}
		
		
		int resMap[][] = new int[maxY-minY+1+2][maxX-minX+1+2];
		for(int yy =1 ;yy < resMap.length ; ++yy) {
			for(int xx =1 ; xx < resMap[yy].length ; ++xx) {
				resMap[yy][xx] = map[minY+(yy-1)][minX+(xx-1)]; 
			}
		}
		
		fillSovle(resMap);
		bfs(resMap);
		//prMap(resMap);
		print(resMap);
	}
	
	
	public static void fillSovle(int map[][]) {
		for(int y =0 ; y < map.length ; ++y) {
			for(int x=0 ; x < map[y].length ; ++x) {
				int next[][]= {
						{x,y-1},
						{x,y+1},
						{x-1,y},
						{x+1,y},
						
				};
				if(map[y][x]!=1)
					continue;
				
				for(int i = 0; i < next.length ; ++i) {
					if(map[next[i][1]][next[i][0]]==0)
						map[next[i][1]][next[i][0]]=2;
				}
			}
		}
		
		
		for(int y =0 ; y < map.length ; ++y) {
			for(int x=0 ; x < map[y].length ; ++x) {
				int next[][]= {
						{x,y-1},
						{x,y+1},
						{x-1,y},
						{x+1,y},
						
				};
				if(map[y][x]!=0)
					continue;
				int well =0;
				for(int i = 0; i < next.length ; ++i) {
					if(next[i][0]<0 || next[i][1]<0 || next[i][1]>=map.length || next[i][0]>=map[0].length)
						continue;
					
					if(map[next[i][1]][next[i][0]]==2)
						++well;
				}
				if(well==4)
					map[y][x]=2;
			}
		}
		//prMap(map);
		//print(map);
	}
	
	public static void bfs(int map[][]) {
		Queue<int[]> data = new LinkedList<int[]>();
		
		
		for(int xx =0 ; xx <map[0].length ; ++xx) {
			if(map[0][xx]==0)
				data.offer(new int[] {xx,0});
			if(map[map.length-1][xx]==0)
				data.offer(new int[] {xx,map.length-1});
		}
		for(int yy =0 ; yy < map.length ; ++yy) {
			if(map[yy][0]==0)
				data.offer(new int[] {0,yy});
			if(map[yy][map[yy].length-1]==0)
				data.offer(new int[] {map[yy].length-1,yy});
		}
		
		//data.offer(new int[] {x,y});
		while(!data.isEmpty()) {
			
			int point[] =  data.poll();
			int next[][] = {
					{point[0],point[1]-1},
					{point[0],point[1]+1},
					{point[0]-1,point[1]},
					{point[0]+1,point[1]},
			};
			
			map[point[1]][point[0]] = 3; 
			
			for(int i= 0 ; i < next.length ; ++i) {
				if(next[i][0]<0 || next[i][1]<0 || next[i][1]>=map.length || next[i][0]>=map[0].length)
					continue;
				
				if(map[next[i][1]][next[i][0]]!=0)
					continue;
				data.offer(new int[] {next[i][0],next[i][1]});
			}
		}
	}
	
	public static void print(int map[][]) {
		for(int y =0 ; y < map.length ; ++y) {
			for(int x=0 ; x < map[y].length ; ++x) {
				if( map[y][x]==1 || map[y][x]==3)
					System.out.print(" ");
				else if(map[y][x]==0 || map[y][x]==2) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	
	public static void prMap(int map[][]) {
		for(int y =0 ; y < map.length ; ++y) {
			for(int x= 0 ; x < map[y].length ; ++x) {
				System.out.print(map[y][x]+" ");
			}
			System.out.println();
		}
		
		
		
	}

}
