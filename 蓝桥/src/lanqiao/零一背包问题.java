package lanqiao;

import java.util.Scanner;

public class ��һ�������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		
		//N����Ʒ
		int N = sc.nextInt();
		//V����
		int V = sc.nextInt();
		
		
		//��Ʒ����
		int w[] = new int[N+1];
		//��Ʒ��ֵ
		int v[] = new int[N+1];
		
		for(int i = 1 ; i <=N ; ++i) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		
		//dp����
		int dp[][] = new int[N+1][V+1];
		
		//����
		for(int i= 1 ; i <= V ; ++i) {
			//��Ʒ
			for(int j = 1 ; j <= N ; ++j) {
				if(w[j]>i)
					dp[j][i] = dp[j-1][i];
				else {
					dp[j][i] = Math.max(v[j]+ dp[j-1][i-w[j]],dp[j-1][i]);
				}
			}
		}
		System.out.println(dp[N][V]);
		
		
	}

}
