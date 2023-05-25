package lanqiao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/problem/51178?&headNav=acm
 * @author 长白崎
 *
 */
public class 没有上司的舞会 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt(); //一共有几名职员
		int happy[] = new int[N+1]; //存happy值
		
		
		//输入happy值
		for(int i= 1; i <= N ; ++i) {
			happy[i] = sc.nextInt();
		}
		
		HashMap<Integer, ArrayList<Integer>> tree = new HashMap<Integer, ArrayList<Integer>>();
		int jl[] = new int[N+1];
		
		while(true) {
			int L = sc.nextInt();
			int K = sc.nextInt();
			jl[L] = K;
			if(L==0 && K==0)
				break;
			if(tree.containsKey(K)) {
				tree.get(K).add(L);
			}else {
				tree.put(K, new ArrayList<Integer>());
				tree.get(K).add(L);
			}
		}
		
		int p = 0;
		for(int i=1 ; i <=N ; ++i) {
			if(jl[i]!=0)
				continue;
			p=i;
			break;
		}
		
		int dp[][] = new int[N+1][2];
		
		
		dfs(happy,dp,tree,p);
		System.out.println(Math.max(dp[p][0], dp[p][1]));
	}
	
	public static void dfs(int happy[],int dp[][],HashMap<Integer, ArrayList<Integer>> tree,int n) {
		
		dp[n][1] = happy[n];
		
		if(tree.containsKey(n))
		for(int i=0; i < tree.get(n).size(); ++i ) {
			dfs(happy,dp,tree,tree.get(n).get(i));
			dp[n][1] += dp[tree.get(n).get(i)][0];
			dp[n][0] += Math.max( dp[tree.get(n).get(i)][0], dp[tree.get(n).get(i)][1] );
		}
	}
	
	

}
