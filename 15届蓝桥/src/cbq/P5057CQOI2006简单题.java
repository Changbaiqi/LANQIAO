package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

/**
 * https://www.luogu.com.cn/problem/P5057
 * @class 树状数组，快速输入，快输输出，差分，前缀和
 * @author 长白崎
 *
 */
public class P5057CQOI2006简单题 {

	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
//	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int n = Reader.nextInt();
		
		int m= Reader.nextInt();
		
		int tree[] = new int[n+1];
		
		for(int i= 0; i < m; ++i) {
			int op = Reader.nextInt();
			
			if(op ==1) {
				int l = Reader.nextInt();
				
				int r = Reader.nextInt();
				
				update(tree,l,1);
				update(tree,r+1,1);
			}else {
				int x = Reader.nextInt();
				out.println(sum(tree,x)%2);
			}
		}
		
		out.flush();
		
		
	}
	
	static int lowBit(int i) {
		return i&(-i);
	}
	
	static void update(int tree[],int i,int v) {
		while(i<tree.length) {
			tree[i] +=v;
			i+=lowBit(i);
		}
	}
	
	static long sum(int tree[],int i) {
		long ans =0;
		while(i>0) {
			ans+=tree[i];
			i-=lowBit(i);
		}
		return ans;
	}

	/** 快速输入类 */
	 
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
