package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * https://www.luogu.com.cn/problem/P3374
 * @class 线性数组，模板题
 * @author 长白崎
 */
public class P3374模板树状数组1 {
	
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String[] s = in.readLine().split(" ");

		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);

		int tree[] = new int[n+1];
		// 输入值
		s = in.readLine().split(" ");
		for (int i = 1; i <= n; ++i) {
			update(tree, i, Integer.parseInt(s[i-1]));
		}

		for (int i = 1; i <= m; ++i) {
			s = in.readLine().split(" ");
			int op = Integer.parseInt(s[0]);
			int x = Integer.parseInt(s[1]);
			int y = Integer.parseInt(s[2]);
			if (op == 1)
				update(tree, x, y);
			else
				out.println(sum(tree,y)-sum(tree,x-1));
				
		}
		
		out.flush();
		out.close();
		in.close();
	}

	static int lowBit(int i) {
		return i & (-i);
	}

	static void update(int tree[], int i, int v) {

		while (i < tree.length) {
			tree[i] += v;
			i += lowBit(i);
		}
	}

	static long sum(int tree[], int i) {
		long sum = 0;
		while (i > 0) {
			sum += tree[i];
			i -= lowBit(i);
		}
		return sum;
	}

}
