package cbq;

import java.util.Arrays;
import java.util.Scanner;


/**
 * https://www.lanqiao.cn/problems/5890/learning/?contest_id=145
 * @class DFS,链式向前星
 * @author 长白崎
 *
 */
public class 串门算法赛 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Edge[] edge= new Edge[(n-1)*2];
		int head[]=new int[n+1];
		Arrays.fill(head, -1);
		long sum=0;
		for(int i=0;i<(n-1)*2;i+=2) {
			int u= sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			sum+=(w*2);
			addEdge(edge, head, i, u, v, w);
			addEdge(edge, head, i+1, v, u, w);
		}
		
		long dis[]= new long[n+1];
		dfs(edge, head, dis, 1, -1, 0);
		
		int u=1;
		for(int i=2;i<=n;++i) u=dis[i]>dis[u]?i:u;
		
		dfs(edge, head, dis, u, -1, 0);
		
		u=1;
		for(int i=2;i<=n;++i) u=dis[i]>dis[u]?i:u;
		
		System.out.println(sum-dis[u]);
		
	}

	static void dfs(Edge[] edge,int head[],long dis[],int u,int father,long len) {
		dis[u]=len;
		for(int i = head[u];i!=-1;i=edge[i].next) {
			int j=edge[i].to;
			if(j!=father) dfs(edge, head, dis, j, u, len+edge[i].w);
		}
	}
	
	static void addEdge(Edge edge[],int head[],int ei,int u,int v,int w) {
		Edge e = new Edge();
		e.to=v;e.w=w;e.next=head[u];head[u]=ei;
		edge[ei]=e;
	}
	
	static class Edge{
		int to;
		int w;
		int next;
	}
}
