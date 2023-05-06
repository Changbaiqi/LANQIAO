package lanqiao;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/2219/learning/?page=1&first_category_id=1&sort=students_count&name=%E5%B7%A6%E7%A7%BB%E5%8F%B3%E7%A7%BB
 * @author ������
 *
 */
public class �������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M =sc.nextInt();
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int hh[] = new int[420000+N];
		
		
		for(int i= 1; i <= N ; ++i) {
			hh[420000/2+i] = i;
			map.put(i, 420000/2+i);
		}
		
		int L = 420000/2;
		int R = 420000/2+N+1;
		for(int i= 0; i <M ; ++i) {
			String c = sc.next();
			int n = sc.nextInt();
			
			
		 	if(c.equals("L")) {
		 		int index = map.get(n);
		 		hh[index] = 0;
		 		hh[L] = n;
		 		map.put(n, L);
		 		--L;
		 	} 
		 		
		 	if(c.equals("R")) {
		 		int index = map.get(n);
		 		hh[index] = 0;
		 		hh[R] = n;
		 		map.put(n, R);
		 		++R;
		 	} 
		 	
			
		}
		
		for(int i = 0; i < hh.length ; ++i) {
			if(hh[i]==0)
				continue;
			System.out.print(hh[i]+" ");
		}
		
	}
		

}
