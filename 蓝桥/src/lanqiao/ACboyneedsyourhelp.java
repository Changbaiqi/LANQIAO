package lanqiao;

import java.util.Scanner;

public class ACboyneedsyourhelp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//while()
		int N = sc.nextInt(); //��ѡN�ſ�
		int M = sc.nextInt(); //ֻ��ѧM��
		
		int A[][] = new int[N+1][M+1]; //��i�ſ�ѧϰa���ܵõķ���
		for(int i =1; i <=N ; ++i) {
			
			int a = sc.nextInt(); //ѧϰa��
			int b = sc.nextInt();//ѧϰa�����ܵõ��ķ���
			A[i][a] = b; 
		}
		
		//��ʼDP
		
		int dp[]= new int[M+1];
		
		for(int y = 1 ; y <=N ; ++y) {
			for(int x=M ; x>=1 ; --x) {
				for(int i = 1 ; i<=M ; ++i) {
					if(x>=i)
						dp[x] = Math.max(dp[x], dp[x-i]+A[y][i]);
				}
			}
		}
		
		
		
		
	}

}
