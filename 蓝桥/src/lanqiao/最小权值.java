package lanqiao;


/**
 * https://www.lanqiao.cn/problems/1563/learning/?page=1&first_category_id=1&sort=students_count&tags=%E5%9B%BD%E8%B5%9B&name=%E6%9C%80%E5%B0%8F%E6%9D%83%E5%80%BC
 * @author 长白崎
 *
 */
public class 最小权值 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long dp[] = new long[2022];
		dfs(dp, 2021);
		System.out.println(dp[2021]);
	}

	public static void dfs(long dp[], int root) {
		//结点序号起始就是1
		if (root == 0 || dp[root]>0)
			return;
		
		if (root == 1) {
			dp[root] = 1;
		} else {
			dp[root] = Long.MAX_VALUE;
			for (int L = 0; L <= root - 1; ++L) {
				int R = (root-1) - L;
				dfs(dp, R);
				dfs(dp, L);
				dp[root] = Math.min(dp[root], 1 + 2 * dp[L] + 3 * dp[R] + L * L * R);
			}
		}
	}

}
