package cbq;
import java.util.Scanner;

/**
 * https://www.luogu.com.cn/training/1435
 * @author ������
 *
 */
public class �����ߵ����� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt(); //ħ��ֵ
		int S = sc.nextInt(); //����
		int T = sc.nextInt(); //ʱ��
		
		
		int dp[]= new int[T+1];
		
		
		
				
		//��һֱ������
		for( int i=1; i <=T; ++i) {
			if(M>=10) {
				dp[i]=Math.max(dp[i-1]+60,dp[i]);
				M-=10;
			}else {
				dp[i] = dp[i-1];
				M+=4;
			}
		}
		
		
		//�����ܲ��Ļ�
		for(int i= 1 ; i <=T; ++i) {
			dp[i]= Math.max(dp[i-1]+17,dp[i]);
			if(dp[i]>=S) {
				System.out.println("Yes");
				System.out.println(i);
				return;
			}
		}
		System.out.println("No");
		System.out.println(dp[T]);
		
		
		
		
		
	}

}
