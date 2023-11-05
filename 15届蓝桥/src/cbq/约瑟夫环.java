package cbq;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/problem/22227?&headNav=acm
 * @class 队列
 * @author 长白崎
 *
 */
public class 约瑟夫环 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Queue<Integer> qu = new LinkedList<Integer>();
		int n = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();
		
		//入队所有输入的数字
		for(int i=0; i < n ; ++i) {
			qu.offer(i);
		}
		
		//先循环到指定编号的的数字
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
