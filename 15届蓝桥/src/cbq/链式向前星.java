package cbq;

import java.util.Arrays;
import java.util.Scanner;


public class ��ʽ��ǰ�� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //�ж��ٸ���
		int m = sc.nextInt(); //�ж�������
		
		Edge[] edge = new Edge[m];
		int head[] = new int[n+1];
		Arrays.fill(head, -1);//��ʼ��
		
		for(int i=0 ;i< m;++i) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			addEdge(edge, head, i, u, v, w);
		}
		
		for(int i= 1; i<= n;++i) {
			System.out.println("��"+i+"Ϊ��ͷ�ıߣ�");
			for(int j = head[i];j!=-1;j=edge[j].next) {
				System.out.println(i+"-->"+edge[j].to);
			}
		}
		
	}
	
	/**
	 * ��ӱ�
	 * @param edge �洢�ߵ�����
	 * @param head �洢��iΪ��㣬������Ϊ����������һ��¼���
	 * @param ei �ߵı��
	 * @param u ���
	 * @param v �յ�
	 * @param w Ȩֵ
	 */
	static void addEdge(Edge[] edge,int head[],int ei,int u,int v,int w) {
		Edge e = new Edge();
		e.to=v;e.w=w;e.next=head[u];head[u]=ei;
		edge[ei]=e;
	}
	
	static class Edge{
		int to;
		int w;
		int next;
	}

}

