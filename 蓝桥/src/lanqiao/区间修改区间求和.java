package lanqiao;

import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/1133/learning/?page=2&first_category_id=1&sort=students_count&second_category_id=8
 * @author ������
 *
 */
public class �����޸�������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int Q = sc.nextInt();
		
		
		int data[] = new int[N+1]; //���ڴ洢
		int tree[] = new int[N*4+1]; //����tree
		int lazyTag[] = new int[N*4+1];
		
		//����������ֵ
		for(int i = 1; i <=N ; ++i) {
			data[i] = sc.nextInt();
		}
		
		//�����߶���
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
     * ��ȡ��ǰ�ڵ��ŵ�����ӽ����
     *
     * @param p ����ǰ���ı�ǩ���
     * @return ���������ӽڵ�ı�ǩ��
     */
    public static int ls(int p) {
        return p << 1;
    }

    /**
     * ��ȡ��ǰ����ŵ��Ҷ��ӽ����
     *
     * @param p ����ǰ���ı�ǩ���
     * @return ���������ӽ��ı�ǩ��
     */
    public static int rs(int p) {
        return p << 1 | 1;
    }

    /**
     * ���ڼ��㵱ǰ�������Ӧ�������ӽ����ܺ�
     *
     * @param tree ���������߶���
     * @param p    ��ʾ������Ҫ����Ľ��ı�ǩ
     */
    public static void pushUp(int tree[], int p) {
        tree[p] = tree[ls(p)] + tree[rs(p)]; //�����
    }

    /**
     * �����߶���
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
     * ����Ͳ�ѯ
     *
     * @param tree �������߶���
     * @param L    ����������Ҫ��ѯ�������Ӧ���������
     * @param R    ����������Ҫ��ѯ�������Ӧ�������ұ�
     * @param p    ����������ǵ�ǰ������ѯ���ڵĸ��ڵ�Ľ���ǩ
     * @param ls   ����ǰ�����ķ�Χ���
     * @param rs   ����ǰ�����ķ�Χ�ұ�
     * @return �������յ������ܺ�ֵ
     */
    public static int query(int tree[], int lazyTag[], int L, int R, int p, int ls, int rs) {
        //��ȫ����
        if (L <= ls && R >= rs) return tree[p];
        pushDown(tree, lazyTag, ls, rs, p);
        int res = 0;
        int mid = (ls + rs) >> 1;
        if (L <= mid) res += query(tree, lazyTag, L, R, ls(p), ls, mid);
        if (R > mid) res += query(tree, lazyTag, L, R, rs(p), mid + 1, rs);
        return res;
    }

    /**
     * ����Ǹ��º���
     *
     * @param tree    �߶���������
     * @param lazyTag ���������
     * @param ls      ��Ҫ�޸ĵ��������߽�
     * @param rs      ��Ҫ�޸�������ұ߽�
     * @param p       ��ǰ�޸�������ı�ǩ���
     * @param v       ��Ҫ�޸ĵ�ֵ
     */
    public static void addTag(int tree[], int lazyTag[], int ls, int rs, int p, int v) {
        lazyTag[p] += v;
        tree[p] += v * (rs - ls + 1);
    }

    /**
     * ��������´���
     *
     * @param tree    �߶���������
     * @param lazyTag ���������
     * @param ls      �������߽�
     * @param rs      ������ұ߽�
     * @param p       ��Ӧ����ı�ǩ
     */
    public static void pushDown(int tree[], int lazyTag[], int ls, int rs, int p) {
        //���ز���Ҫ���´��ݵ������
        if (lazyTag[p] == 0)
            return;

        //��ʼ����Ǵ���
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
        //���´���
        pushDown(tree,lazyTag,ls,rs,p);
        int mid = (ls+rs)>>1;
        //������ӽ�����Ҫ����ô�ݹ�����ӽ�����
        if (L<=mid) update(tree,lazyTag,L,R,ls,mid,ls(p),v);
        //������ӽ�����Ҫ����ô�ݹ�����ӽ�����
        if(R > mid) update(tree,lazyTag,L,R,mid+1,rs,rs(p),v);
        //���µ�ǰ����ֵ
        pushUp(tree,p);
    }



}
