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
 * https://www.lanqiao.cn/problems/3538/learning/?subject_code=2&group_code=4&match_num=14&match_flow=1&origin=cup
 * @author 长白崎
 * @class["第十四届蓝桥杯省赛JavaB组"]
 */
public class 合并区域 {
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int N = Reader.nextInt();

		int arr1[][] = new int[N][N];
		int arr2[][] = new int[N][N];

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				arr1[i][j] = Reader.nextInt();
			}
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				arr2[i][j] = Reader.nextInt();
			}
		}
		int max = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {

				if (arr1[i][j] == 1) {
					boolean state[][] = new boolean[N][N];
					int ans = dfsAns(arr1, state, N, i, j);
					fill(arr1, N, ans, i, j);
					max = Math.max(max, ans);
				}
				if (arr2[i][j] == 1) {
					boolean state[][] = new boolean[N][N];
					int ans = dfsAns(arr2, state, N, i, j);
					fill(arr2, N, ans, i, j);
					max = Math.max(max, ans);
				}

			}
		}
		max = Math.max(linkSum(arr1, arr2, N), max);
		System.out.println(max);

	}

	/**
	 * 递归统计
	 * 
	 * @param arr
	 * @param state
	 * @param N
	 * @param startY
	 * @param startX
	 * @return
	 */
	static int dfsAns(int arr[][], boolean state[][], int N, int startY, int startX) {
		int ans = 0;
		if (startY >= N || startX >= N || startX < 0 || startY < 0)
			return ans;
		if (arr[startY][startX] == 0)
			return ans;
		if (state[startY][startX])
			return ans;
		ans += 1;
		state[startY][startX] = true;
		ans += dfsAns(arr, state, N, startY + 1, startX);
		ans += dfsAns(arr, state, N, startY - 1, startX);
		ans += dfsAns(arr, state, N, startY, startX + 1);
		ans += dfsAns(arr, state, N, startY, startX - 1);
		return ans;
	}

	static void fill(int arr[][], int N, int fillNum, int startY, int startX) {
		if (startY >= N || startX >= N || startX < 0 || startY < 0)
			return;
		if (arr[startY][startX] == 0 || arr[startY][startX] == fillNum)
			return;

		arr[startY][startX] = fillNum;
		fill(arr, N, fillNum, startY + 1, startX);
		fill(arr, N, fillNum, startY - 1, startX);
		fill(arr, N, fillNum, startY, startX + 1);
		fill(arr, N, fillNum, startY, startX - 1);
	}

	static int linkSum(int arr1[][], int arr2[][], int N) {
		int max = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {

				max = Math.max(max, arr1[0][i] + arr2[0][j]);
				max = Math.max(max, arr1[0][i] + arr2[j][0]);
				max = Math.max(max, arr1[0][i] + arr2[N - 1][j]);
				max = Math.max(max, arr1[0][i] + arr2[j][N - 1]);

				max = Math.max(max, arr1[i][0] + arr2[0][j]);
				max = Math.max(max, arr1[i][0] + arr2[j][0]);
				max = Math.max(max, arr1[i][0] + arr2[N - 1][j]);
				max = Math.max(max, arr1[i][0] + arr2[j][N - 1]);

				max = Math.max(max, arr1[N - 1][i] + arr2[0][j]);
				max = Math.max(max, arr1[N - 1][i] + arr2[j][0]);
				max = Math.max(max, arr1[N - 1][i] + arr2[N - 1][j]);
				max = Math.max(max, arr1[N - 1][i] + arr2[j][N - 1]);

				max = Math.max(max, arr1[i][N - 1] + arr2[0][j]);
				max = Math.max(max, arr1[i][N - 1] + arr2[j][0]);
				max = Math.max(max, arr1[i][N - 1] + arr2[N - 1][j]);
				max = Math.max(max, arr1[i][N - 1] + arr2[j][N - 1]);
			}
		}

		return max;

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
