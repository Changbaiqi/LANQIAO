package lanqiao;

import java.util.HashMap;
import java.util.Scanner;

public class 好等差数列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		//数列长度
		int n = sc.nextInt();
		
		//存储数据的数组
		int data[] = new int[n];
		for(int i= 0 ; i < n ; ++i) {
			data[i] =sc.nextInt();
		}
		//System.out.println(slove(data));
		int c = sc.nextInt();
		
		for(int i= 0; i <c ; ++i) {
			int a = sc.nextInt();
			int v = sc.nextInt();
			//暂时寄存
			int res = data[a];
			
			data[a] = v;
			
			System.out.println(slove(data));
			//data[a] = res;
		}
		
		
		
	}
	
	public static int slove(int nums[]) {
		HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
		int max =0;
		
		for(int y =0 ; y <nums.length ; ++y) {
			for(int x =0 ; x <nums.length ; ++x) {
				int a = nums[x]-nums[y];
				int b = x -(y);
//				if(b==0)
//					continue;
//				
				if(y == x)
					continue;
				if(a%b!=0)
					continue;
				
				
				int k = a/b;
				if(data.containsKey(k)) {
					data.put(k, data.get(k)+1);
				}else {
					data.put(k, 1);
				}
				if(max<data.get(k))
					max = data.get(k);
			}
		}
		return nums.length-max-1;
	}

}
