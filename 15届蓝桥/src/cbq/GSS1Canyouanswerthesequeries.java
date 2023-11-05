package cbq;

import java.util.Scanner;

public class GSS1Canyouanswerthesequeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int data[] = new int[n+1];
		for(int i =1 ;i <=n ; ++i) {
			data[i] = sc.nextInt();
		}
		
		int m = sc.nextInt();
		for(int i = 1; i <= m ; ++i) {
			
		}
		
		
	}
	
	static int ls(int p) {return p<<1;}
	static int rs(int p) {return p<<1|1;}
	
	static void push_up(int tree[],int p) {tree[p]+=(tree[ls(p)]+tree[rs(p)]);}
	
	
	static void build(int tree[],int data[],int p,int l,int r) {
		if(1==r) {tree[p]=data[l]; return;}
		
		int mid = (r+l)>>1;
		build(tree, data, ls(p), l, mid);
		build(tree, data, rs(p), mid+1, r);
		push_up(tree, p);
	}
	
	static int query(int tree[],int p,int l,int r) {
		return 1;
	}

}
