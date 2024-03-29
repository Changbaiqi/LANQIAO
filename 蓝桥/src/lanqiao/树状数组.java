package lanqiao;

import java.util.Scanner;

/**
 * https://vjudge.net/problem/HDU-1166
 * 
 * @author 20840
 *
 */
public class 树状数组 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		// 多少条测试条例
		int t = sc.nextInt();

		for (int i = 0; i < t; ++i) {
			int N = sc.nextInt();

			int data[] = new int[N + 1];
			int tree[] = new int[(N + 1)*4];
			
			for (int x = 1; x < data.length; ++x) {
				data[x] = sc.nextInt();
				updata(x, data[x], tree);
			}
			
			while(true) {
				String cmd = sc.next();
				if(cmd.equals("Query")) {
					int start = sc.nextInt();
					int end = sc.nextInt();
					long dis =  getSum(end,tree)-getSum(start-1,tree);
					System.out.println(dis);
				}else if(cmd.equals("Add")) {
					int start = sc.nextInt();
					int end = sc.nextInt();
					updata(start, end, tree);
				}else if(cmd.equals("Sub")) {
					int start = sc.nextInt();
					int end = sc.nextInt();
					updata(start, -end, tree);
				}else if(cmd.equals("End")) {
					break;
				}
			}
			
			
		}
		
		
	}

	//lowbit算法
	public static int lowbit(int x) {
		return x & (-x);
	}
	
	//更新
	public static void updata(int i, int k, int tree[]) {
		while (i < tree.length) {
			tree[i] += k;
			i += lowbit(i);
		}
	}
	
	//统计总和
	public static long getSum(int i,int tree[]) {
		long ans = 0;
		while(i>0) {
			ans += tree[i];
			i -= lowbit(i);
		}
		return ans;
	}

}
