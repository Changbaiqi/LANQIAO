package lanqiao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class �������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
//		
//		int N = sc.nextInt(); //N������
//		int M = sc.nextInt(); //M�������·
//		
//		//��
//		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
//		
//		for(int i = 0 ; i <M ; ++i) {
//			int u = sc.nextInt();
//			int v = sc.nextInt();
//			int w = sc.nextInt();
//			
//			//����Ƿ���
//			if(!map.containsKey(u))
//				map.put(u,new ArrayList<Integer>());
//			
//			ArrayList<Integer> resMap = map.get(u);
//			//resMap
//			
//			��
//			
//		}
		
		int map[][] = new int[300000][300000];
		
	}
	
	
	/**
	 * ��
	 * @author ������
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
	 * ��
	 * @author ������
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
