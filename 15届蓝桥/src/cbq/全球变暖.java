package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acwing.com/problem/content/1235/
 * 
 * @author ³¤°×Æé @class["bfs","dfs","ºéË®Ìî³ä"]
 *
 */
public class È«Çò±äÅ¯ {
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int N = Reader.nextInt();

		char map[][] = new char[N][N];

		int resMap[][] = new int[N][N];

		for (int i = 0; i < N; ++i) {
			String str = Reader.next();
			map[i] = str.toCharArray();
//			fillMap[i] = str.toCharArray();
		}
		fillBfs(map,resMap,N);
		
		int mapAns = bfs(resMap,N);
		fill(map, resMap, N);
//		
		int fillMapAns = bfs(resMap,N);
		System.out.println(mapAns-fillMapAns);
	}

	static int bfs(int map[][], int N) {

		boolean[][] state = new boolean[N][N];
		boolean vi[] = new boolean[N*N+1];
		int ans = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (state[i][j] || map[i][j] == 0)
					continue;
				if(vi[map[i][j]])continue;
					++ans; vi[map[i][j]]=true;
				Queue<int[]> qu = new LinkedList<int[]>();
				state[i][j] = true;
				qu.offer(new int[] { i, j });
				while (!qu.isEmpty()) {
					int point[] = qu.poll();

					int next[][] = new int[][] { { point[0] - 1, point[1] }, { point[0] + 1, point[1] },
							{ point[0], point[1] - 1 }, { point[0], point[1] + 1 } };

					for (int z = 0; z < 4; ++z) {
						if (next[z][0] < 0 || next[z][1] < 0 || next[z][0] >= N || next[z][1] >= N)
							continue;
						if (map[next[z][0]][next[z][1]] == 0)
							continue;
						if (state[next[z][0]][next[z][1]])
							continue;
						state[next[z][0]][next[z][1]] = true;
						qu.offer(new int[] { next[z][0], next[z][1] });
					}
				}

			}
		}
		return ans;
	}

	static void fillBfs(char map[][], int resMap[][], int N) {
		boolean[][] state = new boolean[N][N];
		int flag =0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (state[i][j] || map[i][j] == '.')
					continue;
				++flag;
				Queue<int[]> qu = new LinkedList<int[]>();
				state[i][j] = true;
				resMap[i][j] = flag;
				qu.offer(new int[] { i, j });
				while (!qu.isEmpty()) {
					int point[] = qu.poll();

					int next[][] = new int[][] { { point[0] - 1, point[1] }, { point[0] + 1, point[1] },
							{ point[0], point[1] - 1 }, { point[0], point[1] + 1 } };

					for (int z = 0; z < 4; ++z) {
						if (next[z][0] < 0 || next[z][1] < 0 || next[z][0] >= N || next[z][1] >= N)
							continue;
						if (map[next[z][0]][next[z][1]] == '.')
							continue;
						if (state[next[z][0]][next[z][1]])
							continue;
						state[next[z][0]][next[z][1]] = true;
						resMap[next[z][0]][next[z][1]]=flag;
						qu.offer(new int[] { next[z][0], next[z][1] });
					}
				}

			}
		}
	}

	static void fill(char map[][], int fillMap[][], int N) {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j] == '.')
					continue;

				int next[][] = new int[][] { { i + 1, j }, { i - 1, j }, { i, j + 1 }, { i, j - 1 } };

				for (int z = 0; z < 4; ++z) {
					if (next[z][0] < 0 || next[z][1] < 0 || next[z][1] >= N || next[z][0] >= N)
						continue;
					if (map[next[z][0]][next[z][1]] == '.') {
						fillMap[i][j] = 0;
						break;
					}
				}

			}
		}

	}

	static class Reader {
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer tokenizer = new StringTokenizer("");

		static String next() throws IOException {
			while (!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(br.readLine());
			}
			return tokenizer.nextToken();
		}

		static int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		static long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}

}
