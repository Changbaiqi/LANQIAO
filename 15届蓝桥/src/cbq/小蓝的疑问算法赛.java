package cbq;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/5892/learning/?contest_id=145
 * @class
 * @author 长白崎
 *
 */
public class 小蓝的疑问算法赛 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int q= sc.nextInt();
		int point[] = new int[n+1];
		
		for(int i =1;i<= n;++i) {
			point[i] = sc.nextInt();
		}
		
		Edge[] edge=new Edge[n-1];
		int head[]=new int[n+1];
		Arrays.fill(head, -1);
		
		for(int i=0;i<n-1;++i) {
			int u = sc.nextInt();
			int v= sc.nextInt();
			addEdge(edge, head, i, u, v, point[v]);  
		}
		
		for(int i=0;i<q;++i) {
			int x = sc.nextInt();
			int k = sc.nextInt();
//			int max=search(x,k);
//			System.out.println(max);
		}
		
		
	}
	
	static int search(Edge edge[],int head[], int x,int k,int from,int father) {
		if(from==k) {
			return from;
		}
		for(int j=head[from];j!=-1;j=edge[j].next) {
			search(edge, head, x, k, j, from);
		}
		return 0;
	}
	
	static void addEdge(Edge edge[],int head[],int ei,int u,int v,int w){
		Edge e = new Edge();e.to=v;e.w=w;e.next=head[u];head[u]=ei;edge[ei]=e;
	}
	
	
	static class Edge{
		int to;
		int w;
		int next;
	}

}
