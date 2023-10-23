package lanqiao;

public class ¹úÈü2022 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long dp[][] = new long[2023][11];
		dp[0][0] = 1;
		
		for(int y=1; y <=2022 ; ++y) {
			for(int x =1 ; x <=10 ; ++x) {
				if(y>=x)
					dp[y][x] = dp[y-x][x] + dp[y-x][x-1];
			}
		}
		System.out.println(dp[2022][10]);
		
	}
	

}
