package cbq;
import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P1095
 * @class dp������dp
 * @author ������
 *
 */
public class P1095NOIP2007�ռ��������ߵ�����1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//ħ����ʼֵ
		int M = sc.nextInt();
		//����
		int S= sc.nextInt();
		//��ûʱ��
		int T =sc.nextInt();
		
		int dp[] = new int[T+1];
		
		//һֱ����
		for(int i = 1; i <= T; ++i) {
			if(M >=10) {
				dp[i] = dp[i-1]+60;
				M-=10;
			}else {
				dp[i] = dp[i-1];
				M+=4;
			}
		}
		
		//�м�����ܵĻ�
		for(int i = 1; i <= T ; ++i) {
			dp[i] = Math.max(dp[i-1]+17, dp[i]);
			//����߳��˵���
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
