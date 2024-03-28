package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 最小生成树 {
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int N = Reader.nextInt();
		int M = Reader.nextInt();
		int f[] = new int[N+1];
		Edge[] edges = new Edge[M];
		for(int i=0;i<M;++i) {
			int u = Reader.nextInt();
			int v = Reader.nextInt();
			int w = Reader.nextInt();
			edges[i] = new Edge(u,v,w);
		}
		
		kruskal(edges, f, N, M);
		out.flush();
		out.close();
	}
	
	/**
	 * 初始化并查集
	 * @param f
	 */
	static void initF(int f[]) {for(int i=0;i<f.length;++i)f[i]=i;}
	/**
	 * 并查集
	 * @param f
	 * @param i
	 * @return
	 */
	static int find(int f[],int i) {
		if(f[i]!=i) f[i]=find(f,f[i]);
		return f[i];
	}
	
	/**
	 * kruskal算法
	 * @param edges
	 * @param f
	 */
	static void kruskal(Edge edges[],int f[],int N,int M) {
		initF(f);
		Arrays.sort(edges,(a,b)->a.w-b.w);
		
		int sum=0,ans =0;
		for(int i=0;i<M;++i) {
			Edge e = edges[i];
			int u = find(f,e.u);
			int v = find(f,e.v);
			
			if(u==v) continue;
			sum +=e.w;
			++ans;
			f[u] = v;
		}
		if(ans+1==N) {
			out.println(sum);
		}else {
			out.println("orz");
		}
		
	}
	static class Edge{
		int u,v,w;
		public Edge(int u,int v,int w){
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}

	static class Reader {
		static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer tokenizer = new StringTokenizer("");

		public static String next() throws IOException {
			while (!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		public static int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		public static long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}

}
