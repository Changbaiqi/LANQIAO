package lanqiao;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/2222/learning/?page=1&first_category_id=1&sort=students_count&name=%E8%BF%B7%E5%AE%AB
 * @author 长白崎
 *
 */
public class 迷宫 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String[] s = in.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		
		
		HashMap<String,HashSet<String>> cs = new HashMap<String, HashSet<String>>();
		for(int i = 0 ; i < m;  ++i) {
			s = in.readLine().split(" ");
			int x1 = Integer.parseInt(s[0]);
			int y1 = Integer.parseInt(s[1]);
			int x2 = Integer.parseInt(s[2]);
			int y2 =Integer.parseInt(s[3]);
			String a1 = x1+"-"+y1;
			String a2 = x2+"-"+y2;
			if(cs.containsKey(a1)) {
				cs.get(a1).add(a2);
			}else {
				HashSet<String> set = new HashSet();
				set.add(a2);
				cs.put(a1, set);
			}
			
			if(cs.containsKey(a2)) {
				cs.get(a2).add(a1);
			}else {
				HashSet<String> set = new HashSet();
				set.add(a1);
				cs.put(a2, set);
			}
		}
		//地图r
		int map[][] = new int[n+1][n+1];
	
		
		System.out.printf("%.2f",(float)bfs(map,new int[n+1][n+1],cs,n,n)/(n*n));
		
	}
	
	public static long bfs(int map[][],int state[][],HashMap<String,HashSet<String>> cs,int startX,int startY) {
		Queue<int[]> qu = new LinkedList<int[]>();
		
		state[startY][startX] =1;
		qu.add(new int[] {startX,startY,0});
		long ans =0;
		while(!qu.isEmpty()) {
			int cc[] = qu.poll();
			
			int next[][]= {
					{cc[0],cc[1]-1},
					{cc[0],cc[1]+1},
					{cc[0]-1,cc[1]},
					{cc[0]+1,cc[1]},
			};
			
//			if(cc[0]==map.length-1 && cc[1]==map.length-1) {
//				//return cc[2];
//			}
			
			
			//如果传送门
			if( cs.containsKey(cc[0]+"-"+cc[1])) {
				for(String xy: cs.get(cc[0]+"-"+cc[1])) {
					int cx = Integer.parseInt(xy.split("-")[0]);
					int cy= Integer.parseInt(xy.split("-")[1]);
					if(state[cy][cx]==1) 
						continue;
					state[cy][cx] = 1;
					qu.offer(new int[] {cx,cy,cc[2]+1});
					ans+=cc[2]+1;
					
				}
			}
			
			//普通走法
			for(int i= 0 ; i < next.length ; ++i) {
				
				
				//过滤
				if(next[i][0]<1 || next[i][1] < 1 || next[i][1] > map.length-1 || next[i][0] >map.length-1)
					continue;
				//过滤走过
				if(state[next[i][1]][next[i][0]]==1)
					continue;
				
				
				state[next[i][1]][next[i][0]] = 1;
				ans+=cc[2]+1;
				qu.offer(new int[] {next[i][0],next[i][1],cc[2]+1});
			}
			
			
		}
		return ans;
	}

}
