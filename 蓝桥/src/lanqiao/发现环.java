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
		for (int i = 0; i < N; ++i) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			sides[i] = new Side(x, y);
			dataSet.add(x);
			dataSet.add(y);
		}

		// 多少个点
		Integer data[] = dataSet.toArray(new Integer[0]);
		
		
		for(int i = 0; i < data.length ; ++i) {
			// 标记是否选了该边
			boolean sideSel[] = new boolean[sides.length];
			
			if(dfs(sides,sideSel,data[i],data[i],false)) {
				System.out.print(data[i]+" ");
			}
		}
		
	}
	
	
	public static boolean dfs(Side sides[],boolean sideSel[],int point,int end,boolean cc) {
		if(point==end&& cc) {
			return true;
		}
		cc = true;
		
		for(int i = 0; i < sides.length ; ++i) {
			if(sides[i].getX()==point && !sideSel[i]) {
				sideSel[i]=true;
				boolean sw = dfs(sides,sideSel,sides[i].getY(),end,true);
				sideSel[i]=false;
				if(sw)
					return true;
			}else if(sides[i].getY() == point && !sideSel[i]){
				sideSel[i] = true;
				boolean sw = dfs(sides,sideSel,sides[i].getX(),end,true);
				sideSel[i] = false;
				if(sw)
					return true;
			}
		}
		return false;
	}

}

class Side {
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

	public static int check(Side sides[], int x, int y) {
		for (int i = 0; i < sides.length; ++i) {
			if (sides[i].getX() == x || sides[i].getY() == x)
				if (sides[i].getX() == y || sides[i].getY() == y)
					return i;
		}
		return -1;
	}

}