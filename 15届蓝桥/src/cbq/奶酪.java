package cbq;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class 奶酪 {
	static PrintWriter out  = new PrintWriter(System.out);
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		int T = Reader.nextInt();
		
		while(T-->0) {
			int n = Reader.nextInt();
			int h = Reader.nextInt();
			int r= Reader.nextInt();
			Node arr[] = new Node[n+1];
			int f[] = new int[n+1];
			
			for(int i=1;i<=n;++i) {
				arr[i] = new Node(Reader.nextInt(),Reader.nextInt(),Reader.nextInt());
			}
			init(f);
			for(int i = 0;i<=n;++i) {
				for(int j=i+1;j<=n;++j) {
					if(i==0) arr[0]  = new Node(arr[j].x, arr[j].y, 0);
					double dis = dist(arr[i].x,arr[i].y,arr[i].z,arr[j].x,arr[j].y,arr[j].z);
					if(i==0) { 
						if(dis<=r) {if(arr[find(f,i)].z<arr[j].z)f[i]=j;};
						} else if(dis<=2*r) {if(arr[find(f,i)].z<arr[j].z)f[i]=j;};
				}
			}
			int v = find(f,0);
			if(arr[v].z+r>=h)out.println("Yes");else out.println("No");
			
		}
		out.flush();
		out.close();
		
	}
	/**
	 * 初始化并查集
	 * @param f
	 */
	static void init(int f[]) {for(int i=0;i<f.length;++i) {f[i]=i;}}
	
	static int find(int f[],int i) {if(f[i]!=i)f[i]=find(f,f[i]);return f[i];}
	
	static double dist( double x1,double y1,double z1,double x2,double y2,double z2) {
		return Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2)+Math.pow(z1-z2, 2));
	}
	
	static class Node {
		double x,y,z;
		public Node(double x,double y,double z) {
			this.x = x;this.y = y;this.z =z;
		}
	}
	
	static class Reader{
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer st = new StringTokenizer("");
		static String next() throws IOException {
			while(!st.hasMoreTokens()){
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}
		
		static int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
		static long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}

}
