package lanqiao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 发现环 {

	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Side sides[] = new Side[N];
		HashSet<Integer> dataSet = new HashSet<>();
		for(int i = 0; i< N ; ++i) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			sides[i] = new Side(x, y);
			dataSet.add(x);
			dataSet.add(y);
		}
		
		//多少个点
		Integer data[] = dataSet.toArray(new Integer[0]);
		//标记是否选了
		
		for(int i= 0 ; i< data.length ; ++i) {
			
			boolean sidesSel[] = new boolean[sides.length];
			
			Queue<Integer> que = new LinkedList<>();
			que.offer(data[i]);
			
			int x=0;
			while(!que.isEmpty()) {
				int point = que.poll();
				if(x!=0 && point==data[i]) {
					System.out.println(data[i]);
				}
				
				for(int y = 0 ;y< data.length ; ++y) {
					int ss = Side.check(sides, point, data[y]);
					if(ss!=-1 && !sidesSel[ss] ) {
						que.offer(data[y]);
						sidesSel[ss]=true;
					}
				}
				
				++x;
			}
			
			
		}
		
		
		
		
		
		
		
		
	}
	
	
	
}

class Side{
	int x;
	int y;
	public Side(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public static int check(Side sides[],int x,int y) {
		for(int i= 0; i< sides.length ; ++i) {
			if(sides[i].getX() == x || sides[i].getY() == x)
				if(sides[i].getX() == y || sides[i].getY() == y)
					return i;
		}
		return -1;
	}
	
}