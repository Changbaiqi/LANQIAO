package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.lanqiao.cn/problems/5131/learning/?contest_id=144
 * @class 树状数组、前缀和、差分、线段树、贪心、快输
 * @author 长白崎
 *
 */
public class 奇怪的线段算法赛 {
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//代表区间个数
		int n = Reader.nextInt();
		//代表询问个数
		int q = Reader.nextInt();
		
		int sum[] = new int[200005];
		int tree[] = new int[200005];
		
		Node node[] = new Node[n+q+1];
		
		for(int i=1 ; i <= n;  ++i) {
			int l =Reader.nextInt();
			int r = Reader.nextInt();
			++sum[l];
			--sum[r+1];
			node[i]= new Node(0,0,l,r);
		}
		
		for(int i =1; i <200005;++i) sum[i]+=sum[i-1];
		
		int res[]=new int[q+1];
		for(int i=1;  i <= q; ++i) {
			int l = Reader.nextInt();
			int r = Reader.nextInt();
			
			res[i]=sum[l];
			if(l>r) {
				int c = l;
				l = r;
				r=c;
			}
				
			node[i+n]= new Node(i,1,l,r);		
		}
		Arrays.sort(node,1,node.length);
		
		for(int i=1; i <=n+q ; ++i) {
			Node nd = node[i];
			if(nd.op==0) {
				update(tree,nd.l,1);
			}else {
				res[nd.id]-=count(tree, nd.l);
			}
		}
		for(int i=1; i<=q; ++i)
			out.println(res[i]);
		
		out.flush();
		
	}
	
	
	static int lowBit(int i) {
		return i&(-i);
	}
	
	static void update(int tree[],int i,int v) {
		while(i<tree.length) {
			tree[i]+=v;
			i+=lowBit(i);
		}
	}
	
	static long count(int tree[],int i) {
		long ans =0;
		while(i>0) {
			ans+=tree[i];
			i-=lowBit(i);
		}
		return ans;
	}
	
	
	static class Node implements Comparable<Node>{
		int l;
		int r;
		int id;
		int op;
		
		public Node(int id, int op, int l, int r) {
			this.id = id;
			this.op = op;
			this.l = l;
			this.r = r;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(r==o.r) {
				if(l!=o.l) return l-o.l;
				return op-o.op;
			}
			return o.r-r;
		}
		
		
		
	}
	static class Reader{
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer tokenizer = new StringTokenizer("");
		static String next() throws IOException {
			while(!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(br.readLine());
			}
			return tokenizer.nextToken();
		}
		
		static int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
		static double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(next());
		}
	}
	
	
}
