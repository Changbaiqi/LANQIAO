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
public class 奇怪的线段算法赛2练 {
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	final static int MAX=200005;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int n = Reader.nextInt();
		int q = Reader.nextInt();
		
		int dif[] = new int[MAX];
		
		Node node[] = new Node[n+q+1];
		
		//区间读入
		for(int i=1 ; i <=n ; ++i) {
			int l = Reader.nextInt();
			int r = Reader.nextInt();
			++dif[l];
			--dif[r+1];
			node[i] = new Node(l, r, 0, 0);
		}
		
		for(int i=1; i <MAX ;++i) dif[i]+=dif[i-1];
		
		int data[] = new int[q+1];//用于寄存查询点的区间数量
		//输入需要知道的区间
		for(int i=1 ; i <=q;++i) {
			int a = Reader.nextInt();
			int b = Reader.nextInt();
			
			data[i] = dif[a];
			//替换
			if(a>b) {
				int c= a;
				a = b;
				b = c;
			}
			node[n+i] = new Node(a, b, 1, i); 
		}
		
		//排序
		Arrays.sort(node,1,node.length);
		
		int tree[] = new int[MAX];
		
		for(int i=1; i <=n+q; ++i) {
			Node nd = node[i];
			if(nd.op!=1) {
				update(tree, nd.l, 1);
			}else {
				data[nd.id]-=count(tree, nd.l);
			}
		}
		
		for(int i =1; i <=q;++i) {
			out.println(data[i]);
		}
		
		out.flush();
	}
	
	static int lowBit(int i) {
		return i&(-i);
	}
	static void update(int tree[],int i ,int v) {
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
		public int l;
		public int r;
		public int op;
		public int id;
		public Node(int l, int r, int op, int id) {
			this.l = l;
			this.r = r;
			this.op = op;
			this.id = id;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(r!=o.r) 
				return o.r-r;
			else {
				if(l!=o.l)
					return l-o.l;
				else
					return op-o.op;
			}
		}
	}
	
	static class Reader{
		static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer tokenizer = new StringTokenizer("");
		
		public static String next() throws IOException {
			while(!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}
		
		public static int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}

}
