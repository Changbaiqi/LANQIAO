package cbq;



import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P1020
 * @author 长白崎
 * @classs ["dp","二分"]
 */
public class P1020NOIP1999提高组导弹拦截 {
	static int MAX = (int)1e5+2;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int ans =0;
		int arr[] = new int[MAX];
		
		while(sc.hasNextInt()) {
			arr[ans++] = sc.nextInt();
		}
		
		int dp[] = new int[ans];
		int mx =0;
		for(int i= 0;i<ans;++i) {
			for(int j =0;j<i;++j) {
				if(arr[j]>=arr[i]) { dp[i] = Math.max(dp[i], dp[j]+1); mx = Math.max(mx, dp[i]);}
			}
		}
		
		System.out.println(mx+1);
	}
	
	
	
	

}
