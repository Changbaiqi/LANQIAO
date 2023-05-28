package lanqiao;


import java.util.Scanner;

public class Kevinϲ����򵥰汾 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		//һ���������������
		int T = sc.nextInt();
		
		for(int i= 1; i <=T ; ++i) {
			int n = sc.nextInt(); //���г���
			long k = sc.nextLong(); //��������
			
			
 			Num data[] = new Num[n+1]; //���ڴ洢����
 			long p2[] = new long[n+1]; //���ڴ洢2��������ǰ׺��
 			long p5[] = new long[n+1]; //���ڴ洢5��������ǰ׺��
 			
 			for(int x =1 ; x <=n ; ++x) {
 				long a = sc.nextLong();
 				long fiveAns = modAns(a,5);
 				long twoAns = modAns(a,2);
 				data[x] = new Num(a, fiveAns, twoAns);
 				p2[x] = p2[x-1]+twoAns;
 				p5[x] = p5[x-1]+fiveAns;
 			}
 			long ans = 0;
 			for(int l=1 ; l <=n ; ++l) {
  				ans+= slove(p2,p5,data,l,k);
			}
			System.out.println(ans);
 			
 			
 			
			
			
		}
		
		
		
		sc.close();
	}
	
	//��������
	public static long modAns(long x,long mod) {
		long ans = 0;
		while(x%mod==0) {
			x/=mod;
			++ans;
		}
		return ans;
	}
	
	
	//�����㷨
	public static long slove(long p2[],long p5[],Num data[],int l,long k) {
		
		long ans =0;
		//���������ڶ��ֲ������½�
		int l1 = l; int r1 = data.length-1;
		
		while(l1<r1) {
			int mid = (l1+r1)>>1;
			long minAns = Math.min(p2[mid]-p2[l-1], p5[mid]-p5[l-1]);
			if(minAns>=k)
				r1 = mid;
			else
				l1 = mid+1;
		}
		//���û���ҵ�����Ҫ������½���ô��ֱ���˳���˵���Դ˵�Ϊ��׼����Ҫ��Ķ���û��
		//if(l1>data.length-1) return 0;
		long minAns = Math.min(p2[l1]-p2[l-1], p5[l1]-p5[l-1]);
		if(minAns!=k) return 0;
		
		
		//���ֲ������Ͻ�
		int l2 = l; int r2 = data.length-1;
		while(l2<r2) {
			int mid = (l2+r2+1)>>1;
			long minAns2 = Math.min(p2[mid]-p2[l-1], p5[mid]-p5[l-1]);
			if(minAns2>k)
				r2= mid-1;
			else
				l2=mid;
		}
		long minAns2 = Math.min(p2[l2]-p2[l-1], p5[l2]-p5[l-1]);
		if(minAns2!=k) return 0;
		
		ans+= l2-l1+l;
		
		return ans;
	}
	
	
	public static class Num{
		long num;
		long five;
		long two;
		public Num(long num, long five, long two) {
			super();
			this.num = num;
			this.five = five;
			this.two = two;
		}
	}
}

