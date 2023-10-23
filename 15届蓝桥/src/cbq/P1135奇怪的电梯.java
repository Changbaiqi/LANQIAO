package cbq;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P1135
 * @class BFS
 * @author ³¤°×Æé
 *
 */
public class P1135Ææ¹ÖµÄµçÌÝ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int K[] = new int[N+1];
		for(int i=1 ; i <=N ; ++i) {
			K[i] = sc.nextInt();
		}
		
		System.out.println(bfs(A,B,N,K));
		
	}
	
	
	static long bfs(int start,int end,int N,int K[]) {
		Queue<int[]> qu = new LinkedList<>();
		int state[] = new int[N+1];
		qu.add(new int[] {start,0});
		while(!qu.isEmpty()) {
			int point[] = qu.poll();
			if(point[0]==end) {
				return point[1]; 
			}
			
			int next[]= {
					point[0]+K[point[0]],
					point[0]-K[point[0]]
			};
			
			for(int i =0; i < next.length ; ++i) {
				if(next[i]<1 || next[i]>N)
					continue;
				
				if(state[next[i]]==1)
					continue;
				state[next[i]]=1;
				qu.offer(new int[] {next[i],point[1]+1});
			}
			
			
		}
		return -1;
	}

}
