package lanqiao;

import java.util.Scanner;

public class 签到题签到题 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		//测试数据条数
		int T = sc.nextInt();
		
		for(int i = 0 ; i < T ; ++i) {
			//店的数量
			int n = sc.nextInt();
			//达到多少钱减免
			int a = sc.nextInt();
			//减免金额
			int b = sc.nextInt();
			int mina=Integer.MAX_VALUE;
			for(int xx = 0 ; xx < n ; ++xx) {
				//多少菜品
				int k = sc.nextInt();
				//满多少元减免
				int x  = sc.nextInt();
				//减免额度
				int y = sc.nextInt();
				
				//用于存每个菜品的价格
				int data[] = new int[k];
				
				//用于存储每个菜对应最大减免后的价格
				int dataJ[] = new int[k];
				
				for(int ii = 0 ; ii < k ; ++ii) {
					data[ii] = sc.nextInt();
					dataJ[ii] = data[ii];
					if(data[ii]>=a)
						dataJ[ii] -=b;
					if(data[ii]>=x)
						dataJ[ii]-=y;
				}
				int min = Integer.MAX_VALUE;
				for(int cc =0 ; cc < dataJ.length ; ++cc) {
					min = Math.min(min, dataJ[cc]);
				}
				mina = Math.min(min, mina);
				
				
			}
			System.out.println(mina<0? 0:mina);
			
			
			
		}
		
		
		
	}

}
