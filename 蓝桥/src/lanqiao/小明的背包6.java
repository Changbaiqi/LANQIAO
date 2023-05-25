package lanqiao;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/1179/learning/?page=1&first_category_id=1&sort=students_count&difficulty=30&name=%E8%83%8C%E5%8C%85
 * @author 长白崎
 *
 */
public class 小明的背包6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //一共有N件物品
		int V = sc.nextInt(); //背包容量
		
		int w[] = new int[N+1];
		int v[] = new int[N+1];
		int s[] = new int[N+1];
		
		ArrayList<Integer> map[] = new ArrayList[N+1];
		for(int i=0;i<map.length ; ++i) map[i] = new ArrayList<Integer>();
		
		for(int i=1 ; i <=N ; ++i) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
			s[i] = sc.nextInt();
			map[s[i]].add(i);
		}
		
		
		int dp[][] = new int[N+1][V+1];
		dfs(dp,map,0,V,w,v,s);
		System.out.println(dp[0][V]);
	}
	
	public static void dfs(int dp[][],ArrayList<Integer> map[],int root,int V,int w[],int v[],int s[]) {
		
		//选择当前结点的话。
		for(int i = 0 ; i<=V;++i)
			if(i>=w[root])
				dp[root][i] = v[root];
		
		for(int i=0; i <map[root].size() ; ++i) {
			int point = map[root].get(i);
			dfs(dp,map,point,V,w,v,s);
			
			for(int y = V; y>=w[root]; --y) {
				for(int x=0;x<=y-w[root]; ++x) {
					dp[root][y] = Math.max(dp[root][y], dp[root][y-x]+dp[point][x]);
				}
			}
		}
		
			
	}
	
	
	
}
