package lanqiao;


import java.util.Scanner;

public class 二进制问题 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		Integer.numberOfLeadingZeros(10);
		//从1到N
		int N = sc.nextInt();
		//包含K个1
		int K = sc.nextInt();
//		
//		String str = BigInteger.valueOf(1000000).toString(2);
//		System.out.println(str);
//		
		System.out.println(C(test(N),K));
		
		//long dp[][] = new long[][];
	}
	
	public static long dfs() {
		return 0;
	}
	
	public static int test(int num) {
		int count =0;
		while(num!=0) {
			num>>=1;
			count+=1;
		}
		return count;
	}

	
	public static long C(int n, int m) {
	    long[][] dp = new long[n+1][m+1];
	    for (int i = 0; i <= n; i++) {
	        dp[i][0] = 1;
	    }
	    for (int i = 1; i <= n; i++) {
	        for (int j = 1; j <= m && j <= i; j++) {
	            dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
	        }
	    }
	    return dp[n][m];
	}
}
