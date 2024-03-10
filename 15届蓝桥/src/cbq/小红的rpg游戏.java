package cbq;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 小红的rpg游戏 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int h = sc.nextInt();
		
		char map[][] = new char[n][m];
		for(int i=0;i<n;++i) {
			map[i] = sc.next().toCharArray();
		}
		System.out.println(bfs(map, 0, 0, m-1, n-1, h));
		
	}
	
	static int bfs(char map[][],int sx,int sy,int ex,int ey,int h) {
		Queue<int[]> qu = new LinkedList<int[]>();
		boolean state[][][] = new boolean[map.length][map[0].length][h+1];
		state[0][0][h] = true;
		qu.offer(new int[] {sx,sy,0,h});
		while(!qu.isEmpty()) {
			
			int point[] = qu.poll();
			
			if(point[0]==ex && point[1]==ey) {
				return point[2];
			}
			
			int next[][]= {
					{point[0],point[1]-1},
					{point[0],point[1]+1},
					{point[0]-1,point[1]},
					{point[0]+1,point[1]}
			};
			
			for(int i=0;i<next.length;++i) {
				//过滤边界
				if(next[i][0]<0 || next[i][0]>=map[0].length || next[i][1]<0 || next[i][1]>=map.length)
					continue;
				//过滤墙
				if(map[next[i][1]][next[i][0]]=='*')
					continue;

				//是否是怪物
				int v = 0;
				if(map[next[i][1]][next[i][0]]>='1' && map[next[i][1]][next[i][0]]<='9'){
					v = map[next[i][1]][next[i][0]]-'0';
					if(point[3]-v<=0)
						continue;
				}
				
				//过滤走过
				if(state[next[i][1]][next[i][0]][point[3]-v])
					continue;
				
				state[next[i][1]][next[i][0]][point[3]-v]=true;
				qu.offer(new int[] {next[i][0],next[i][1],point[2]+1,point[3]-v});
			}
		}
		
		return -1;
	}

}
