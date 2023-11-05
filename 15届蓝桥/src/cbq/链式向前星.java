package cbq;

import java.util.Arrays;
import java.util.Scanner;


public class 链式向前星 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //有多少个点
		int m = sc.nextInt(); //有多少条边
		
		Edge[] edge = new Edge[m];
		int head[] = new int[n+1];
		Arrays.fill(head, -1);//初始化
		
		for(int i=0 ;i< m;++i) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			addEdge(edge, head, i, u, v, w);
		}
		
		for(int i= 1; i<= n;++i) {
			System.out.println("以"+i+"为开头的边：");
			for(int j = head[i];j!=-1;j=edge[j].next) {
				System.out.println(i+"-->"+edge[j].to);
			}
		}
		
	}
	
	/**
	 * 添加边
	 * @param edge 存储边的数组
	 * @param head 存储以i为起点，其内容为结束点的最近一个录入边
	 * @param ei 边的编号
	 * @param u 起点
	 * @param v 终点
	 * @param w 权值
	 */
	static void addEdge(Edge[] edge,int head[],int ei,int u,int v,int w) {
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

