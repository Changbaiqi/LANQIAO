package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/contest/53808/A
 * @author 长白崎
 *
 */
public class 简单的签到题 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int map[] = new int[n];
		
		for(int i= 0; i< n ; ++i) {
			map[i] = sc.nextInt();
		}
		
		Arrays.sort(map);
		
		int ans =0;
		int m=map[0];
		for(int i= 1; i< n; ++i) {
			ans+=map[i]*(m==0?1:m);
			m+=map[i];
		}
		System.out.println(ans);
		
		
	}
	
	
	

}
