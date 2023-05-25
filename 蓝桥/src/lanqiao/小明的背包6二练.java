package lanqiao;

import java.util.ArrayList;
import java.util.Scanner;

public class 小明的背包6二练 {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //物品数量
		int V = sc.nextInt(); //背包容量
		
		ArrayList<Integer> map[] = new ArrayList[N+1];
		for(int i =0 ; i <=N ; ++i) map[i] = new ArrayList<Integer>();
		
		int w[] = new int[N+1];
		int v[] = new int[N+1];
		int s[] = new int[N+1];
		
		for(int i= 1 ; i <= N ; ++i) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
			s[i] = sc.nextInt();
			
			map[s[i]].add(i); 
		}
		
		int dp[][] = new int[N+1][V+1];
		dfs(map,w,v,s,N,V,0,dp);
		System.out.println(dp[0][V]);
	}
	
	
	public static void dfs(ArrayList<Integer> map[],int w[],int v[],int s[],int N,int V,int root,int dp[][]) {
		
		//假如选择了这个物品的话
		for(int i=0 ;i <= V ; ++i) {
			if(i>=w[root])
				dp[root][i] = v[root];
		}
		
		//这一层用于枚举以该点为根节点时其子树的的根节点。
		for(int i=0 ;i <map[root].size() ; ++i) {
			int son = map[root].get(i); //获取对应结点的编号
			
			dfs(map,w,v,s,N,V,son,dp);
			//这个是用于遍历背包容量
			for(int y = V ; y>=0 ; --y) {
				//这里的x其实要与x-w[root]配合着看，这里其实是这个意思，就是说当背包容量最大为y时，如果选了root（所以这里有个x-w[root])这个点那么配合其他子结点其余的选择方案这，能选的最大的价值。
				for(int x = 0 ; x <= y-w[root] ; ++x) {
					if(y-x>=0)
						//这里意思就是说以root为根节点的话，背包容量为x的时候，配合其以其上面所枚举的子结点son为根节点时候他们所能选的最有价值的方案。
						dp[root][y] = Math.max(dp[root][y],dp[root][y-x]+dp[son][x] );
					
				}
			}
	
		}
		
		
				
	}

}
