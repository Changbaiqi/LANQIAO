package lanqiao;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 附近最小 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		
		int n = sc.nextInt();
		
		int map[] = new int[n];
		
		int data[] = new int[n];
		for(int i = 0 ; i < n ; ++i) {
			map[i]  = sc.nextInt();
		}
		
		
		int k = sc.nextInt();
		
		Deque<Integer> qu = new LinkedList<Integer>();

		
		for(int i= 0; i< n ; ++i) {
			
			
			//首次入队
			while(!qu.isEmpty() && map[qu.peekLast()]> map[i])
				qu.pollLast();
			
			qu.offerLast(i);
			
			while(k<Math.abs(i-qu.peekFirst()))
				qu.pollFirst();
			
				
				
		}
		
		
		
		
	}

}
