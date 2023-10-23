package cbq;

import java.util.Scanner;

public class �߶���ģ�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int tree[] = new int[n*4];
		int tag[] = new int[n*4]; //lazy-tag���
		
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
	
	
	//�����
	static int ls(int i) {
		return i<<1;
	}
	//�Ҷ���
	static int rs(int i) {
		return i<<1|1;
	}
	//���ϴ�������ֵtree
	static void push_up(int tree[],int p) {
		tree[p] = tree[ls(p)]+tree[rs(p)];
	}
	
	static void push_down(int tree[],int tag[],int p,int l,int r) {
		if(tag[p]!=0) {
			int mid = (l+r)>>1;
			addTag(tree, tag, ls(p), l, mid, tag[p]);
			addTag(tree, tag, rs(p), mid+1, r, tag[p]);
			
			tag[p] = 0; //������Ϊtag�ڵ�ֵ�����´����ˣ����Ե�ǰ��tag�ڵ�ֵӦ������
		}
	}
	
	/**
	 * �����߶���
	 * @param data
	 * @param tree
	 * @param tag
	 * @param p
	 * @param l
	 * @param r
	 */
	static void build(int data[],int tree[],int tag[],int p,int l,int r) {
		tag[p] = 0; //��ʼ��tag���
		if(l==r) {tree[p]=data[l]; return;}//�ж��Ƿ�Ҷ�ӽ��
		
		int mid = (l+r)>>1; //ȡ�м�ֵ
		build(data,tree,tag,ls(p),l,mid); //���������ӽڵ����
		build(data,tree,tag,rs(p),mid+1,r); //���������ӽڵ����
		push_up(tree,p);
	}
	
	/**
	 * ���ڵ�p����tag��ǣ����Ҵ��¼���tree
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
	 * ����ֵ
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
		
		//���tag���
		if(L<=l && r<=R) {
			addTag(tree, tag, p, l, r, v);
			return;
		}
		push_down(tree, tag, p, l, r); //������ܸ�����ô��tag���ǵ�����
		//���½��еݹ�ʵ��
		int mid = (l+r)>>1;
		if(L<=mid) update(tree, tag, L, R, ls(p), l, mid, v);
		if(R>mid) update(tree, tag, L, R, rs(p), mid+1, r, v);
		push_up(tree, p); //����ֵ
	}
	
	/**
	 * ��ѯ����ĺ�
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
		push_down(tree, tag, p, l, r);//���ܸ��ǵĻ��ͽ�tag��������
		int mid = (l+r)>>1;
		int res =0;
		if(L<=mid) res+=query(tree,tag, L, R, ls(p), l, mid);
		if(R>mid) res+=query(tree,tag, L, R, rs(p), mid+1, r);
		return res;
	}
	
	
	
	

}
