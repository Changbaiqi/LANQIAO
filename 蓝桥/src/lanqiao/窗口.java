package lanqiao;

import java.util.HashMap;
import java.util.Scanner;

public class ´°¿Ú {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int K = sc.nextInt();

		HashMap<Integer, Win> map = new HashMap<Integer, Win>();
		for (int i = 0; i < K; ++i) {
			String c = sc.next();

			if (c.equals("new")) {
				int pid = sc.nextInt();
				int top = sc.nextInt();
				int left = sc.nextInt();
				int height = sc.nextInt();
				int wight = sc.nextInt();
				Win win = new Win();
				win.setPid(pid);
//				win.set
//				map.put(pid,);
			}

			if (c.equals("new")) {

			}
			

			if (c.equals("new")) {

			}
			

			if (c.equals("new")) {

			}
			

			if (c.equals("new")) {

			}
			
						
		}

	}

}

class Win {
	private int pid;
	private int top;
	private int left;
	private int h;
	private int w;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

}
