package cbq;

import java.util.Arrays;
import java.util.Scanner;

public class –°√¿¥Úπ÷ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int H = sc.nextInt();
		int A = sc.nextInt();
		
		Node data[] = new Node[n];
		for(int i=0;i<n;++i) {
			data[i] = new Node();
			data[i].h = sc.nextInt();
		}
		for(int i=0;i<n;++i) data[i].a = sc.nextInt();
		
		
		
	}
	
	static void dfs(Node data[]) {
		for(int i=0;i<data.length;++i) {
			
		}
	}
	
	static class Node implements Comparable<Node>{
		int h;
		int a;
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(a>o.a && h>o.h)
				return a-o.a;
			
			return h-o.h;
		}
		
		
		
	}

}
