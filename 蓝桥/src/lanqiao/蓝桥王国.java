package lanqiao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 蓝桥王国 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
//		
//		int N = sc.nextInt(); //N个建筑
//		int M = sc.nextInt(); //M条单向道路
//		
//		//点
//		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
//		
//		for(int i = 0 ; i <M ; ++i) {
//			int u = sc.nextInt();
//			int v = sc.nextInt();
//			int w = sc.nextInt();
//			
//			//检测是否有
//			if(!map.containsKey(u))
//				map.put(u,new ArrayList<Integer>());
//			
//			ArrayList<Integer> resMap = map.get(u);
//			//resMap
//			
//			·
//			
//		}
		
		int map[][] = new int[300000][300000];
		
	}
	
	
	/**
	 * 点
	 * @author 长白崎
	 *
	 */
	public static class Point{
		private Integer table;

		public Point(Integer table) {
			super();
			this.table = table;
		}

		public Integer getTable() {
			return table;
		}

		public void setTable(Integer table) {
			this.table = table;
		}
		
	}
	/**
	 * 边
	 * @author 长白崎
	 *
	 */
	public static class E{
		private Integer start;
		private Integer end;
		private Integer len;
		public E(Integer start, Integer end, Integer len) {
			super();
			this.start = start;
			this.end = end;
			this.len = len;
		}
		public Integer getStart() {
			return start;
		}
		public void setStart(Integer start) {
			this.start = start;
		}
		public Integer getEnd() {
			return end;
		}
		public void setEnd(Integer end) {
			this.end = end;
		}
		public Integer getLen() {
			return len;
		}
		public void setLen(Integer len) {
			this.len = len;
		}
		
	}
	
	
	

}
