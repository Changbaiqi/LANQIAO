package cbq;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/1122/learning/?page=1&first_category_id=1&name=%E8%93%9D%E6%A1%A5
 * @author 长白崎
 * @class["Dijkstra","链式向前星","优先队列优化"]
 *
 */
public class 蓝桥王国 {
	static int cnt =0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int head[] = new int[N+1];
		Edge edges[] = new Edge[(M+1)*2];
		init(head,N); //初始化向前星
		for(int i = 1;i<=M;++i) {
			int  u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			addEdge(head, edges, u, v, w);
		}
		long dis[] = dijkstra(head, edges, N, 1, N);

		for(int i=1;i<=N;++i) {
			if(dis[i]!=Long.MAX_VALUE) 
				System.out.print(dis[i]+" ");
			else
				System.out.print(-1+" ");
		}
		
	}
	
	
	
	
	static long[] dijkstra(int head[],Edge edges[],int N,int start,int end) {
		boolean st[] = new boolean[N+1];
		long dis[] = new long[N+1];Arrays.fill(dis, Long.MAX_VALUE); //全部赋值最大
		
		long min ;
		dis[start]=0;
		long sum =0;
		
		
		PriorityQueue<Node> qu = new PriorityQueue<Node>((a,b)->{return ((Long)a.dis).compareTo(((Long)b.dis));});
		
		qu.offer(new Node(0,start));
		while(!qu.isEmpty()) {
			Node u = qu.poll();
			if(st[u.x]) continue; //如果标记过的点，即这个点为起点的这条链已走完
			
			st[u.x] = true; //标记
			
			
			for(int i=head[u.x];i!=-1; i = edges[i].next) {
				int v = edges[i].to;
				if(dis[v]>dis[u.x]+edges[i].w) {
					dis[v] = dis[u.x] + edges[i].w;
					qu.offer(new Node(dis[v],v));
				}
			}
			
		}
		
		return dis;
	}
	
	
	//初始化向前星
	static void init(int head[],int N) {cnt =0;Arrays.fill(head, -1);}
	
	
	static class Node{
		long dis;int x;
		public Node(long dis,int x) {this.dis=dis; this.x=x;}
	}
	
	//添加边
	static void addEdge(int head[],Edge edges[],int u,int v,int w) {
		edges[cnt] = new Edge(v, w, head[u]);  
		head[u] = cnt++;
	}
	
	
	
	static class Edge {
		int to,w,next;

		public Edge(int to,int w,int next) {
			this.to = to;this.w = w;this.next = next;
		}
		
	}

}
