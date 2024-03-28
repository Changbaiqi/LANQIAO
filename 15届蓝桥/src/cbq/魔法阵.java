package cbq;

import java.util.Arrays;
import java.util.Scanner;

public class Ä§·¨Õó {
	static int cnt = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int M = sc.nextInt();
		
		boolean st[][] = new boolean[N][N];
		Edge edges[] = new Edge[M];
		
		for(int i=0;i<M;++i) {
			edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		
		
	}
	
	static void dijkstra(Edge edges[],int N,int start,int end) {
		int parent[] = new int[N];
		int dis[] = new int[N];
		boolean st[] =new boolean[N];
		
		int min = Integer.MAX_VALUE,now=start;
		for(int i = 0;i<N;++i) {
			
		}
		
	}
	
	static class Edge{
		int u,v,w;
		public Edge(int u,int v,int w){
			this.u =u;this.v = v;this.w =w;
		}
	}
	
	

}
