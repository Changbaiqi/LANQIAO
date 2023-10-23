package cbq;

import java.util.Scanner;

public class 线段树模板 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int tree[] = new int[n*4];
		int tag[] = new int[n*4]; //lazy-tag标记
		
		int data[] = new int[n+1];
		for(int i=1;i<=n;++i) {
			int num = sc.nextInt();
			data[i] = num;
		}
		build(data,tree,tag,1,1,n);
		System.out.println(query(tree,tag, 3, 5, 1, 1, n));
		update(tree, tag, 3, 5, 1, 1, n, 3);
		System.out.println(query(tree,tag, 3, 5, 1, 1, n));
	}
	
	
	//左儿子
	static int ls(int i) {
		return i<<1;
	}
	//右儿子
	static int rs(int i) {
		return i<<1|1;
	}
	//向上传递区间值tree
	static void push_up(int tree[],int p) {
		tree[p] = tree[ls(p)]+tree[rs(p)];
	}
	
	static void push_down(int tree[],int tag[],int p,int l,int r) {
		if(tag[p]!=0) {
			int mid = (l+r)>>1;
			addTag(tree, tag, ls(p), l, mid, tag[p]);
			addTag(tree, tag, rs(p), mid+1, r, tag[p]);
			
			tag[p] = 0; //这里因为tag内的值被向下传递了，所以当前的tag内的值应该清零
		}
	}
	
	/**
	 * 构建线段树
	 * @param data
	 * @param tree
	 * @param tag
	 * @param p
	 * @param l
	 * @param r
	 */
	static void build(int data[],int tree[],int tag[],int p,int l,int r) {
		tag[p] = 0; //初始化tag标记
		if(l==r) {tree[p]=data[l]; return;}//判断是否倒叶子结点
		
		int mid = (l+r)>>1; //取中间值
		build(data,tree,tag,ls(p),l,mid); //继续向左子节点进行
		build(data,tree,tag,rs(p),mid+1,r); //继续向右子节点进行
		push_up(tree,p);
	}
	
	/**
	 * 给节点p打上tag标记，并且从新计算tree
	 * @param tree
	 * @param tag
	 * @param p
	 * @param l
	 * @param r
	 * @param v
	 */
	static void addTag(int tree[],int tag[],int p,int l,int r,int v) {
		tag[p]+=v;
		tree[p]+= v*(r-l+1);
	}
	
	/**
	 * 更新值
	 * @param tree
	 * @param tag
	 * @param L
	 * @param R
	 * @param p
	 * @param l
	 * @param r
	 * @param v
	 */
	static void update(int tree[],int tag[],int L,int R,int p,int l,int r,int v) {
		
		//添加tag标记
		if(L<=l && r<=R) {
			addTag(tree, tag, p, l, r, v);
			return;
		}
		push_down(tree, tag, p, l, r); //如果不能覆盖那么把tag覆盖到子树
		//向下进行递归实现
		int mid = (l+r)>>1;
		if(L<=mid) update(tree, tag, L, R, ls(p), l, mid, v);
		if(R>mid) update(tree, tag, L, R, rs(p), mid+1, r, v);
		push_up(tree, p); //更新值
	}
	
	/**
	 * 查询区间的和
	 * @param tree
	 * @param L
	 * @param R
	 * @param p
	 * @param l
	 * @param r
	 * @return
	 */
	static int query(int tree[],int tag[],int L,int R,int p,int l,int r) {
		if(l>=L && R>=r) {return tree[p];}
		push_down(tree, tag, p, l, r);//不能覆盖的话就将tag传给子树
		int mid = (l+r)>>1;
		int res =0;
		if(L<=mid) res+=query(tree,tag, L, R, ls(p), l, mid);
		if(R>mid) res+=query(tree,tag, L, R, rs(p), mid+1, r);
		return res;
	}
	
	
	
	

}
