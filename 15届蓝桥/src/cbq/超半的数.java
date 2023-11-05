package cbq;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/problem/22222?&headNav=acm
 * @class Map、hash、数字统计
 * @author 长白崎
 *
 */
public class 超半的数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		Map<Integer, Integer> data = new HashMap<Integer, Integer>();
		
		for(int i =0 ; i < n; ++i) {
			int x = sc.nextInt();
			if(data.containsKey(x)) {
				data.put(x, data.get(x)+1);
			}else {
				data.put(x, 1);
			}
			if(data.get(x)>n/2) {
				System.out.println(x);
				return;
			}
				
		}
	}

}
