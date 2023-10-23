package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * https://www.luogu.com.cn/problem/P3368
 * @class 树状数组，差分
 * @author 长白崎
 *
 */
public class P3368模板树状数组2 {
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
//		out.println(83121214);
		int N = Reader.nextInt();
		int M = Reader.nextInt();
		
		long tree[] = new long[N+10];
		
		long res =0;
		for(int i=1; i <= N ; ++i) {
			long v =Reader.nextInt();
			update(tree,i,v-res);
			res=v;
		}
		
		for(int i= 0; i < M ; ++i) {
			int op = Reader.nextInt();
			if(op==1) {
				int l = Reader.nextInt();
				int r = Reader.nextInt();
				long v = Reader.nextInt();
				update(tree,l,v);
				update(tree,r+1,v);
			}else {
				int x = Reader.nextInt();
				out.println(sum(tree,x));
//				out.flush();
			}
		}
		out.flush();
		out.close();
	}
	
	static int lowBit(int i) {
		return i&(-i);
	}
	
	
	static void update(long tree[],int i ,long v) {
		while(i<tree.length) {
			tree[i]+=v;
			i+=lowBit(i);
		}
	}
	
	static long sum(long tree[],int i) {
		long ans = 0;
		while(i>0) {
			ans+=tree[i];
			i-=lowBit(i);
		}
		return ans;
	}
	
	
	 /** 快速输入类 */
    static class Reader {
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer tokenizer = new StringTokenizer("");
        /** 获取下一段文本 */
        static String next() throws IOException {
            while ( ! tokenizer.hasMoreTokens() ) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }
        static int nextInt() throws IOException {
            return Integer.parseInt( next() );
        }
        static double nextDouble() throws IOException {
            return Double.parseDouble( next() );
        }
    }

}
