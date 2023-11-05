package cbq;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ã”¿Î√‘π¨ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0 ; i < T;++i) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			char[][] map= new char[n][m];
			int sx=0,sy=0;
			for(int x = 0;x<n;++x) {
				String res =sc.next();
				map[x] = res.toCharArray();
				if(res.contains("P")) {
					for(int y = 0;y < m;++y) {
						if(map[x][y]=='P') {
							sx=y;
							sy=x;
						}
							
					}
				} 
			}
			int r1[]=bfs(map,sx,sy,false);
			if(r1!=null) {
				int ans=r1[2];
				int r2[]= bfs(map,r1[0],r1[1],true);
				if(r2!=null) {
					ans+=r2[2];
					System.out.println(ans);
					continue;
				}
			}
			System.out.println("No solution");
		}
	}
	
	
	public static int[] bfs(char map[][],int sx,int sy,boolean mod) {
		Queue<int[]> qu = new LinkedList<int[]>();
		boolean state[][] = new boolean[map.length][map[0].length];
		qu.offer(new int[] {sx,sy,0});
		while(!qu.isEmpty()) {
			int point[]=qu.poll();
			if(mod) {
			if(map[point[1]][point[0]]=='E') {
				return point;
			}
			}else {
				if(map[point[1]][point[0]]=='K') {
					return point;
				}
			}
			
			int next[][] = {
					{point[0],point[1]-1},
					{point[0],point[1]+1},
					{point[0]-1,point[1]},
					{point[0]+1,point[1]}
			};
			
			for(int i =0 ; i < 4;++i) {
				
				if(next[i][0]<0 ||next[i][1]<0||next[i][0]>=map[0].length || next[i][1]>=map.length)
					continue;
				
				if(map[next[i][1]][next[i][0]]=='#')
					continue;
				if(state[next[i][1]][next[i][0]])
					continue;
				if(!mod) {
					if(map[next[i][1]][next[i][0]]=='E')
						continue;
				}
				state[next[i][1]][next[i][0]]=true;
				qu.offer(new int[]{next[i][0],next[i][1],point[2]+1});
			}
		}
		return null;
	}

}
