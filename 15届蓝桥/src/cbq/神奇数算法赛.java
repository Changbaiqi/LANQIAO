package cbq;

import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/5891/learning/?contest_id=145
 * @class ��λDP��DP
 * @author ������
 *
 */
public class �������㷨�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int r = sc.nextInt();
		
	}
	
	static void slove(int num) {
		int ten[]=new int[20];
		int cnt[]=new int[100];//����ͳ������i�����˶��ٴ�
		int dp[] = new int[100]; //dp����
		
		//��ʼ��
		ten[0]=1;
		for(int i = 1;i<=20;++i) {
			dp[i]= i*ten[i-1];
			ten[i]=10*ten[i-1];
		}
		
		
		int len=0;
		int bit[]=new int[20];
		int res=num;
		while(res!=0) {
			bit[++len]= res%10;
			res/=10;
		}
		
		for(int i=len;i>=1;--i) { //�Ӹߵ��ʹ���x��ÿλ
			for(int j=0;j<=9;++j) cnt[j]+=dp[i-1]*bit[i];
			for(int j =0 ; j< bit[i]; ++j) cnt[j]+=ten[i-1]; //�������λ��bit[i]С������
			long num2=0;
			for(int j=i-1;j>=1;--j) num2=num2*10+bit[j];
			cnt[bit[i]]+=num2+1; //�������λ������bit[i]
			cnt[0] -= ten[i-1]; //����ǰ��0
			
		}
		
		
		
	}
	
	
	

}
