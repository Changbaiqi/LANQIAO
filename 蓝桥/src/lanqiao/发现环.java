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
			boolean sel[] = new boolean[sides.length];
			
			Queue<Integer> que = new LinkedList<>();
			que.add(data[i]);
			boolean sw = false;
			while(!que.isEmpty()) {
				
				int res = que.poll();
				
				if(res==data[i] && sw) {
					System.out.println(data[i]);
					break;
				}
				sw=true;
					
				for(int x= 0 ;x < sides.length; ++x) {
					
					if (sides[x].getY()==res && !sel[x] ) {
						sel[x] = true;
						que.offer(sides[x].getX());
					}else if (sides[x].getX()==res && !sel[x] ) {
						sel[x] = true;
						que.offer(sides[x].getY());
					} 
				}
				
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
	
}