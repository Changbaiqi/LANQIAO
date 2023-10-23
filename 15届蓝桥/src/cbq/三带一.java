package cbq;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/5127/learning/?contest_id=144
 * @class 字符串处理
 * @author 长白崎
 *
 */
public class 三带一 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=0 ; i < T ; ++i) {
			int map[] = new int[300];
			char nn[] = sc.next().toCharArray();
			
			int max =0;
			int min = 5;
			for(int x =0 ; x < nn.length ; ++x ) {
				++map[nn[x]];
				max = map[nn[x]] > max ? map[nn[x]] : max;
				min = map[nn[x]] < min ? map[nn[x]] : min;
			}
			if(max==3 && min==1)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}

}
