package cbq;

import java.util.Scanner;

public class 树状数组模板 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int data[] = new int[9];
		int tree[] = new int[9];
		
		//输入8个数组，并且存储到树状数组
		for(int i =1 ; i <= 8 ; ++i) {
			data[i] = sc.nextInt();
			update(data,tree,i,data[i]);
		}
		System.out.println(countSum(data,tree,5));
		
		
	}
	
	
	static int lowBit(int i) {
		return i&(-i);
	}
	
	static void update(int data[],int tree[],int i,int v) {
		
		while(i<data.length) {
			tree[i] += v;
			i +=lowBit(i);
		}
	}
	
	static long countSum(int data[],int tree[],int i) {
		long ans =0;
		while(i>0) {
			ans +=tree[i];
			i -=lowBit(i);
		}
		return ans;
	}

}
