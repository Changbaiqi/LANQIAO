package lanqiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class 通电_kruskal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		Integer n = sc.nextInt();

		Integer x[] = new Integer[n + 1];
		Integer y[] = new Integer[n + 1];
		Integer h[] = new Integer[n + 1];
		

		for (int i = 1; i <= n; ++i) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
			h[i] = sc.nextInt();
		}

		System.out.println(String.format("%.2f", kruskal(x, y, h)));

	}

	public static double kruskal(Integer x[], Integer y[], Integer h[]) {
		ArrayList<Side1> sides = new ArrayList<Side1>();

		//记录每个结点的父节点,用于并查集
		Integer parent[] = new Integer[10001];
		int cc=0;
		for(int i= 0; i<parent.length ;++i) parent[i]=i;//初始化并查集数组

		// 添加边
		for (int yy = 1; yy < y.length; ++yy) {
			for (int xx = yy + 1; xx < x.length; ++xx) {
				sides.add(new Side1(yy, xx, money(x[yy], y[yy], h[yy], x[xx], y[xx], h[xx])));
			}
		}

		// 排序
		sides.sort((xx, yy) -> xx.moeny < yy.moeny ? -1 : (xx.moeny > yy.moeny ? 1 : 0));

		double ans = 0;
		for (int i = 0; i < sides.size(); ++i) {
			int p1 = find(parent,sides.get(i).getPoint1());
			int p2 = find(parent,sides.get(i).getPoint2());
			if(p1==p2)
				continue;
			
			parent[p1] = p2;
			ans += sides.get(i).getMoeny();
		}
		return ans;
	}

	public static double money(int x_1, int y_1, int h_1, int x_2, int y_2, int h_2) {
		return (Math.sqrt(Math.pow(x_1 - x_2, 2) + Math.pow(y_1 - y_2, 2)) + Math.pow(h_1 - h_2, 2));
	}
	
	public static int find(Integer parent[],Integer point) {
		while(parent[point]!=point) {
			point = parent[point];
		}
		return point;
	}

}

class Side1 {
	int point1;// 下标
	int point2;// 下标

	double moeny;

	public Side1(int point1, int point2, double moeny) {
		super();
		this.point1 = point1;
		this.point2 = point2;
		this.moeny = moeny;
	}

	public int getPoint1() {
		return point1;
	}

	public void setPoint1(int point1) {
		this.point1 = point1;
	}

	public int getPoint2() {
		return point2;
	}

	public void setPoint2(int point2) {
		this.point2 = point2;
	}

	public double getMoeny() {
		return moeny;
	}

	public void setMoeny(double moeny) {
		this.moeny = moeny;
	}

}
