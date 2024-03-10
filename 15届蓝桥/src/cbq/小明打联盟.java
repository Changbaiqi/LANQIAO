package cbq;

import java.util.Scanner;

public class 小明打联盟 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		
		
		
//		while(sc.hasNextInt()) {
			int T = sc.nextInt();
		
			int x = sc.nextInt();
			int a = sc.nextInt();
	    
			int y = sc.nextInt();
			int b = sc.nextInt();
		
			int L = sc.nextInt();
			int R = sc.nextInt();
			int temp = sc.nextInt();
			int A= sc.nextInt();
		
			int dp[] =new int[T+1];
			
			for(int i=1;i<=2;++i) {
				if(i==1) {
					for(int j= x;j<=T;++j)
						dp[j]=Math.max(dp[j], a+dp[j-x]);
				}else if(i==2) {
					for(int j= y;j<=T;++j)
						dp[j]=Math.max(dp[j], b+dp[j-y]);
				}
			}
			for(int j= L;j<=R;++j) {
				if(R>T) continue;
				int harm = temp+ A*(j-L);
				dp[T]=Math.max(dp[T], harm+dp[T-j]);
			}
			System.out.println(dp[T]);
//			}
			
			
			
		}
		
	}

