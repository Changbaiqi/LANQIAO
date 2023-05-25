package lanqiao;

import java.util.ArrayList;
import java.util.Scanner;

public class 金明的预算方案 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //钱总数
		int m = sc.nextInt(); //希望购买的物品个数
		
		int v[] = new int[m+1];
		int p[] = new int[m+1];
		int q[] = new int[m+1];
		
		ArrayList<Integer> map[] = new ArrayList[m+1];
		for(int i =0 ; i <=m ; ++i) map[i] = new ArrayList<Integer>();
		
		
		
		for(int i=1; i <= m ; ++i) {
			v[i] = sc.nextInt(); //物品的价格
			p[i] = sc.nextInt(); //重要度
			q[i] = sc.nextInt(); //对应的主件
			if(q[i]==0) {
				map[0].add(i);
			}else {
				map[q[i]].add(i);
			}
		}
		
		
		int dp[][] = new int[m+1][n+1];
		
		dfs(v,p,q,map,n,m,0,dp);
		System.out.println(dp[0][n]);
	}
	
	public static void dfs(int v[],int p[],int q[],ArrayList<Integer> map[],int n,int m,int root,int dp[][]) {
		
		for(int i = 0; i <= n ; ++i)
			if(i>=v[root])
				dp[root][i] = v[root]*p[root];
		
		for(int i = 0 ; i <map[root].size() ; ++i) { //子树的数量为分组
			int res = map[root].get(i);
			
			dfs(v,p,q,map,n,m,res,dp);
			
			
			for(int y=n; y>=0 ; --y) {
				for(int x =0 ;x <= y-v[root]; ++x) {
					if(y-x>=0)
						dp[root][y] = Math.max(dp[root][y], dp[root][y-x]+dp[res][x]);
				}
			}
			
			
		}
	}

}
