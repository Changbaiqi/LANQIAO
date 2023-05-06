package lanqiao;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ·��֮�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		
		//��������
		int top[] = new int[N];
		//������
		int left[] = new int[N];
		
		int sum =0;
		for(int i= 0 ; i <N ; ++i) {
			top[i] = sc.nextInt();
			sum+= top[i];
		}
		for(int i= 0; i < N ; ++i) {
			left[i] = sc.nextInt();
			sum+=left[i];
		}
		
		int state[][] = new int[N][N];
		dfs(0,-1,N-1,N-1,state,top,left,sum,new LinkedList<Integer>());
		
		
	}
	
	
	
	public static void dfs(int startX,int startY,int endX,int endY,int state[][],int top[],int left[],int sum,Deque<Integer> path) {
		
		if(startX==endX && startY == endY && sum==0) {
			//path.offer((endX+1)*(endY+1)-1);
			path.stream().forEach((p)->System.out.print(p+" "));
			System.out.println();
			return;
		}
		
		//ö�����п����ߵķ���
		int next[][]= {
				{startX,startY-1},
				{startX,startY+1},
				{startX-1,startY},
				{startX+1,startY}
		};
		
		for(int i= 0 ; i <next.length ; ++i) {
			
			//����Խ��
			if(next[i][0]<0 || next[i][1] <0 || next[i][1] > state.length-1 || next[i][0] > state[0].length-1)
				continue;
			
			//�����߹�
			if(state[next[i][1]][next[i][0]] ==1)
				continue;
			
			//����û���ӵ�
			if(top[next[i][0]] <=0 || left[next[i][1]]<=0)
				continue;
			
			//����߹�
			state[next[i][1]][next[i][0]] = 1;
			
			path.offer((next[i][1]*(endX+1)+next[i][0]));
			
			
			
			top[next[i][0]]-=1;
			left[next[i][1]]-=1;
			dfs(next[i][0],next[i][1],endX,endY,state,top,left,sum-2,path);
			left[next[i][1]]+=1;
			top[next[i][0]]+=1;
			
			
			state[next[i][1]][next[i][0]] = 0;
			
			path.pollLast();
			
		}
		
	}
	

}
