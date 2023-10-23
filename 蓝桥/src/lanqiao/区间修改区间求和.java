package lanqiao;

import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/1133/learning/?page=2&first_category_id=1&sort=students_count&second_category_id=8
 * @author 长白崎
 *
 */
public class 区间修改区间求和 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int Q = sc.nextInt();
		
		
		int data[] = new int[N+1]; //用于存储
		int tree[] = new int[N*4+1]; //构建tree
		int lazyTag[] = new int[N*4+1];
		
		//输入存入的数值
		for(int i = 1; i <=N ; ++i) {
			data[i] = sc.nextInt();
		}
		
		//构建线段树
		build(tree, data, 1, 1, N);
		
		for(int i = 1 ; i <=Q ; ++i) {
			int cn = sc.nextInt();
			
			if(cn==1) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				int k = sc.nextInt();
				update(tree, lazyTag, l, r, 1, N, 1, k);
			}else if(cn==2) {
				int l = sc.nextInt();
				int r= sc.nextInt();
				System.out.println(query(tree, lazyTag, l, r, 1, 1, N));
			}
		}
		
		
		
		
	}

    /**
     * 获取当前节点编号的左儿子结点编号
     *
     * @param p 代表当前结点的标签序号
     * @return 返回其左子节点的标签号
     */
    public static int ls(int p) {
        return p << 1;
    }

    /**
     * 获取当前结点编号的右儿子结点编号
     *
     * @param p 代表当前结点的标签序号
     * @return 代表其右子结点的标签号
     */
    public static int rs(int p) {
        return p << 1 | 1;
    }

    /**
     * 用于计算当前结点所对应的左右子结点的总和
     *
     * @param tree 所构建的线段树
     * @param p    表示我们需要计算的结点的标签
     */
    public static void pushUp(int tree[], int p) {
        tree[p] = tree[ls(p)] + tree[rs(p)]; //区间和
    }

    /**
     * 构建线段树
     *
     * @param tree
     * @param left
     * @param right
     */
    public static void build(int tree[], int data[], int p, int left, int right) {
        if (left == right) {
            tree[p] = data[left];
            return;
        }

        int mid = (left + right) >> 1;
        build(tree, data, ls(p), left, mid);
        build(tree, data, rs(p), mid + 1, right);
        pushUp(tree, p);
    }

    /**
     * 区间和查询
     *
     * @param tree 构建的线段树
     * @param L    代表我们需要查询的数组对应的区间左标
     * @param R    代表我们需要查询的数组对应的区间右标
     * @param p    代表的是我们当前的所查询基于的父节点的结点标签
     * @param ls   代表当前父结点的范围左标
     * @param rs   代表当前父结点的范围右标
     * @return 返回最终的区间总和值
     */
    public static int query(int tree[], int lazyTag[], int L, int R, int p, int ls, int rs) {
        //完全覆盖
        if (L <= ls && R >= rs) return tree[p];
        pushDown(tree, lazyTag, ls, rs, p);
        int res = 0;
        int mid = (ls + rs) >> 1;
        if (L <= mid) res += query(tree, lazyTag, L, R, ls(p), ls, mid);
        if (R > mid) res += query(tree, lazyTag, L, R, rs(p), mid + 1, rs);
        return res;
    }

    /**
     * 懒标记更新函数
     *
     * @param tree    线段树的数组
     * @param lazyTag 懒标记数组
     * @param ls      需要修改的区域的左边界
     * @param rs      需要修改区域的右边界
     * @param p       当前修改区域结点的标签序号
     * @param v       需要修改的值
     */
    public static void addTag(int tree[], int lazyTag[], int ls, int rs, int p, int v) {
        lazyTag[p] += v;
        tree[p] += v * (rs - ls + 1);
    }

    /**
     * 懒标记向下传递
     *
     * @param tree    线段树的数组
     * @param lazyTag 懒标记数组
     * @param ls      区间的左边界
     * @param rs      区间的右边界
     * @param p       对应区间的标签
     */
    public static void pushDown(int tree[], int lazyTag[], int ls, int rs, int p) {
        //拦截不需要向下传递的懒标记
        if (lazyTag[p] == 0)
            return;

        //开始懒标记传递
        int mid = (ls + rs) >> 1;
        addTag(tree, lazyTag, ls, mid, ls(p), lazyTag[p]);
        addTag(tree, lazyTag, mid + 1, rs, rs(p), lazyTag[p]);
        lazyTag[p] = 0;
    }

    public static void update(int tree[], int lazyTag[], int L, int R, int ls, int rs, int p, int v) {
        if (L <= ls && R >= rs) {
            addTag(tree, lazyTag, ls, rs, p, v);
            return;
        }
        //向下传递
        pushDown(tree,lazyTag,ls,rs,p);
        int mid = (ls+rs)>>1;
        //如果左子结点符合要求那么递归进左子结点继续
        if (L<=mid) update(tree,lazyTag,L,R,ls,mid,ls(p),v);
        //如果右子结点符合要求那么递归进右子结点继续
        if(R > mid) update(tree,lazyTag,L,R,mid+1,rs,rs(p),v);
        //更新当前结点的值
        pushUp(tree,p);
    }



}
