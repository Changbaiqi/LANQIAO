package cbq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * https://www.acwing.com/problem/content/1362/
 * @author 长白崎
 * @class["最大公约数","排序","枚举"]
 */
public class 有序分数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();

		boolean map[][] = new boolean[N+1][N+1];
		ArrayList<int[]> arr  = new ArrayList<>();
		
		for(int i = 1; i<=N;++i) {
			for(int j=0;j<=i;++j) {
				int res = gcd(i,j);
				if(!map[i/res][j/res]) {
					map[i/res][j/res] = true;
					arr.add(new int[] {j/res,i/res});
				}
			}
		}
		
		Collections.sort(arr,(a,b)->{
			Double resA = ((double)a[0])/((double)a[1]);
			Double resB = ((double)b[0])/((double)b[1]);
			return resA.compareTo(resB);
		});
		
		for(int i = 0;i<arr.size();++i) {
			System.out.println(arr.get(i)[0]+"/"+arr.get(i)[1]);
		}
	}
	
	
	static int gcd(int a,int b) {
		return b==0?a:gcd(b,a%b);
	}

}
