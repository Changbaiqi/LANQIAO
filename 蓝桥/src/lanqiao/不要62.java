package lanqiao;

import java.util.Scanner;

public class ��Ҫ62 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		
	}
	
//	public static void slove(int num) {
//		
//		
//	}
	
	public static void init(int num) {
		int bit[] = new int[9];
		int i=0;
		while(num!=0) {
			bit[++i] = num%10;
			num/=10;
		}
		
		dfs(i,bit,i,true);
	}
	
	public static long dfs(int pos,int bit[],int bitAns,boolean limit) {
		if(pos==1)
			return 1; //�����յ�
		
		
		long ans =0;
		for(int i=0;i<=(limit?bit[pos]:9);++i) {
			
			if(limit && i==bit[pos])
				ans+=dfs(pos-1,bit,bitAns,true);
			else
				ans+=dfs(pos-1,bit,bitAns,false);
			
		}
		//dp[][pos]
		return ans;
		
	}

}
