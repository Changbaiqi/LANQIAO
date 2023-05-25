package lanqiao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.lanqiao.cn/problems/2235/learning/?page=1&first_category_id=1&sort=students_count&name=%E5%B0%8F%E7%90%83
 * @author 长白崎
 *
 */
public class 小球称重 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub、
		Scanner sc = new Scanner(System.in);
		// int ss =1000000000;
		int N = sc.nextInt();
		int M = sc.nextInt();

		Set<Integer> a1 = new HashSet<>(); // 嫌疑
		Set<Integer> a2 = new HashSet<>(); // 正常

		for (int i = 0; i < M; ++i) {
			int K = sc.nextInt();
			ArrayList<Integer> Ldata = new ArrayList<>();
			ArrayList<Integer> Rdata = new ArrayList<>();
			for (int x = 0; x < K; ++x) {
				Ldata.add(sc.nextInt());
			}
			for (int x = 0; x < K; ++x) {
				Rdata.add(sc.nextInt());
			}
			String con = sc.next();

			if (con.equals("<")) {
				if (a1.isEmpty())
					a1.addAll(Ldata);
				else
					slove1(a1, Ldata);
			} else if (con.equals(">")) {
				if (a1.isEmpty())
					a1.addAll(Rdata);
				else
					slove1(a1, Rdata);
			} else {
				a2.addAll(Ldata);
				a2.addAll(Rdata);
				slove2(a1, Ldata, Rdata);
			}

		}
		if (a1.size() == 0)
			System.out.println(N - a2.size());
		else
			System.out.println(a1.size());
	}

	public static void slove1(Set<Integer> aa, ArrayList<Integer> data) {
		ArrayList<Integer> res = new ArrayList<Integer>();

		for (int num : data) {
			if (aa.contains(num))
				res.add(num);
		}
		aa.clear();
		aa.addAll(res);
	}

	public static void slove2(Set<Integer> aa, ArrayList<Integer> Ldata, ArrayList<Integer> Rdata) {
		for (int n : Ldata) {
			if (aa.contains(n))
				aa.remove(n);
		}
		for (int n : Rdata) {
			if (aa.contains(n))
				aa.remove(n);
		}
	}

}
