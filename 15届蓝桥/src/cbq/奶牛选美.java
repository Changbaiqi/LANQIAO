package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ÄÌÅ£Ñ¡ÃÀ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int N = Reader.nextInt();
		int M = Reader.nextInt();
		char map[][] = new char[N][M];
		int nMap[][] = new int[N][M];
		

		for(int i = 0;i<N;++i) {
			map[i] = Reader.next().toCharArray();
		}
		
		
		for(int i = 0;i<N;++i) {
			boolean flag = false;
			for(int j = 0;j<M;++j) {
				if(map[i][j]=='X') {
					fill(map,nMap,i*100+j,i,j);
					flag = true;
					break;
				}
			}
			if(flag) break;
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0;i<N;++i) {
			for(int j = 0;j<M;++j) {
				if(map[i][j]=='X') {
					int res = bfs(map,nMap,nMap[i][j],i,j);
					if(res!=0) min = Math.min(min, res);
				}
			}
		}
		System.out.println(min-1);
		
	}

	// Ìî³ä
	static void fill(char map[][], int nMap[][], int flag, int startX, int startY) {
		Queue<int[]> qu = new LinkedList<int[]>();
		qu.offer(new int[] {startX,startY});
		while (!qu.isEmpty()) {
			int point[] = qu.poll();
			int next[][] = new int[][] { { point[0], point[1] + 1 }, { point[0], point[1] - 1 },
					{ point[0] + 1, point[1] }, { point[0] - 1, point[1] } };

			for (int i = 0; i < next.length; ++i) {
				if (next[i][0] < 0 || next[i][1] < 0 || next[i][0] >= map.length || next[i][1] >= map[0].length)
					continue;

				if (map[next[i][0]][next[i][1]] != 'X' || nMap[next[i][0]][next[i][1]] != 0)
					continue;

				nMap[next[i][0]][next[i][1]] = (-flag);
				qu.offer(new int[] { next[i][0], next[i][1] });
			}
		}
	}

	// ËÑË÷
	static int bfs(char map[][],int nMap[][], int flag, int startX, int startY) {
		Queue<int[]> qu = new LinkedList<int[]>();
		boolean state[][] = new boolean[nMap.length][nMap[0].length];
		qu.offer(new int[] {startX,startY,0});
		while (!qu.isEmpty()) {
			int point[] = qu.poll();
			
			if(map[point[0]][point[1]]=='X' && nMap[point[0]][point[1]]!=flag)
				return point[2];
			
			
			int next[][] = new int[][] { { point[0]-1, point[1] }, { point[0]+1, point[1] },
					{ point[0] , point[1]-1 }, { point[0], point[1]+1 } };

			for (int i = 0; i < next.length; ++i) {
				if (next[i][0] < 0 || next[i][1] < 0 || next[i][0] >= nMap.length || next[i][1] >= nMap[0].length)
					continue;
				
				if(nMap[next[i][0]][next[i][1]]==flag)
					continue;
				
				if(state[next[i][0]][next[i][1]])
					continue;
				
				
				state[next[i][0]][next[i][1]] = true;
				qu.offer(new int[] { next[i][0], next[i][1] ,1+point[2]});
			}
		}
		return 0;
	}

	static class Reader {
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer tk = new StringTokenizer("");

		static String next() {
			while (!tk.hasMoreTokens()) {
				try {
					tk = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return tk.nextToken();
		}

		static int nextInt() {
			return Integer.parseInt(next());
		}
	}

}
