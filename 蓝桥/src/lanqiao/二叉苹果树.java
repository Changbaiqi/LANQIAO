package lanqiao;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P2015
 * @author 长白崎
 *
 */
public class 二叉苹果树 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();  //表示树的结点
		int Q = sc.nextInt();  //表示要保留主的苹果数量
		
		ArrayList<Edge>[] map = new ArrayList[N+1];
		for(int i =0 ; i <=N ; ++i) map[i] = new ArrayList<>();
		
		
		for(int i=1 ; i < N ; ++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int s = sc.nextInt();
			map[a].add(new Edge(b,s));
			map[b].add(new Edge(a,s));
		}
		
		int dp[][] = new int[N+1][N+1];
		
		dfs(Q,map,dp,1,0);
		
		System.out.println(dp[1][Q]);
		
		
		
	}
	
	
	public static void dfs(int Q,ArrayList<Edge> map[],int dp[][],int root,int father) {
		
		for(int i= 0; i< map[root].size() ; ++i) {
			
			int son = map[root].get(i).point;
			int q = map[root].get(i).apple;
			
			if(father==son) continue;
			dfs(Q,map,dp,son,root);
			
			for(int y=Q;y>=0; --y){
				for(int x=0; x <=y-1;++x) {
					dp[root][y] = Math.max(dp[root][y], dp[root][y-x-1]+dp[son][x]+q);
				}
			}
			
		}
	}

	public static class Edge{
		public int point;
		public int apple;
		
		Edge(int point,int apple){
			this.point = point;
			this.apple = apple;
		}
	}
}
