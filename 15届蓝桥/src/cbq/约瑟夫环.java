package cbq;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/problem/22227?&headNav=acm
 * @class ����
 * @author ������
 *
 */
public class Լɪ�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Queue<Integer> qu = new LinkedList<Integer>();
		int n = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();
		
		//����������������
		for(int i=0; i < n ; ++i) {
			qu.offer(i);
		}
		
		//��ѭ����ָ����ŵĵ�����
		for(int i=0; i <k;++i) {
			qu.offer(qu.poll());
		}
		
		int i =0;
		while(qu.size()!=1) {
			int num=qu.poll();
			++i;
			if(i!=m) {
				qu.offer(num);
				continue;
			}
			i=0;
		}
		System.out.println(qu.poll());
	}

}
