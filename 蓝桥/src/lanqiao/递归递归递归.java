package lanqiao;

import java.util.Scanner;

public class �ݹ�ݹ�ݹ� {

	static int sum = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; ++i) {
			int M = sc.nextInt();
			int N = sc.nextInt();

			int K = sc.nextInt();

			boolean map[][] = new boolean[M][N];
			boolean state[][] = new boolean[M][N];
			sum=0;

			dfs(map, state, 0, -1, 0, K);
			System.out.println(sum);
		}

	}

	public static void dfs(boolean map[][], boolean state[][], int x, int y, int ans, int win) {

		if (ans == win) {
			++sum;
			return;
		}

		int next[][] = { { x, y + 1 }, { x, y - 1 }, { x + 1, y } };

		for (int i = 0; i < next.length; ++i) {

			if (next[i][0] < 0 || next[i][1] < 0 || next[i][0] >= map[0].length || next[i][1] >= map.length)
				continue;
			if (state[next[i][1]][next[i][0]])
				continue;

			state[next[i][1]][next[i][0]] = true;
			// ���
			boolean sw = false;
			int nnext[][]= {
					{next[i][0],next[i][1]-1},
					{next[i][0],next[i][1]+1},
					{next[i][0]-1,next[i][1]},
					{next[i][0]+1,next[i][1]},
					
			};
			for (int e = 0; e < nnext.length; ++e) {
				if (nnext[e][0] < 0 || nnext[e][1] < 0 || nnext[e][0] >= map[0].length || nnext[e][1] >= map.length)
					continue;
				if (map[nnext[e][1]][nnext[e][0]]) {
					sw = true;
					break;
				}
			}
			if (sw) {
				map[next[i][1]][next[i][0]] = false;
				//pr(map);
				dfs(map,state,next[i][0],next[i][1],ans,win);
			}else {
				map[next[i][1]][next[i][0]] = true;
				//pr(map);
				dfs(map,state,next[i][0],next[i][1],ans+1,win);
				map[next[i][1]][next[i][0]] = false;
				dfs(map,state,next[i][0],next[i][1],ans,win);
			}
			state[next[i][1]][next[i][0]] = false;
			break;
		}

	}
	
	public static void pr(boolean map[][]) {
		System.out.println();
		for(int y = 0 ;y <map.length ; ++y) {
			for(int x =0 ; x < map[y].length ; ++x) {
				System.out.print((map[y][x]?1:0)+" ");
			}
			System.out.println();
		}
	}

}
