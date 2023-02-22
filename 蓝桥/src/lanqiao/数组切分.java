package lanqiao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 数组切分 {
	
	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		
//		int data[] = new int[N];
//		boolean sign[] = new boolean[N];
//		
//		for(int i = 0 ; i < N ; ++i) {
//			data[i] = sc.nextInt();
//		} 
//		dfs(data,sign,0);
		
		int data[] = {3,2,5,1};
		
	}
	
	
	
	
	
	public static long dfs(int data[],boolean sign[],int p) {
		if( p == data.length-1) {
			if(check(data,sign)) {
				System.out.println("完");
				return 1;
			}
			return 0;
		}
		
		
		int sun = 0;
		sign[p] = true;
		sun+= dfs(data,sign,p+1);
		sign[p] = false;
		sun+= dfs(data,sign,p+1);
		
		return sun;
	}
	
	
	//审查
	public static boolean check(int data[],boolean sign[]) {
		
		int p=0,q=1;
		
		while(p<sign.length-1) {
			
			if(sign[p]) {
				
				while(q<sign.length-1 && !sign[q]) {
					++q;
				}
				if(!solu(data,p,q))
					return false;
				
			}
			
			++p;
			q=p+1;
		}
		
		return true;
		
		
	}
	
	public static boolean solu(int data[],int start,int end) {
		
		int res[] = Arrays.copyOfRange(data, start, end);
		
		Arrays.sort(res);
		for(int i = 1 ; i < res.length ; ++i) {
			if(res[i]!= res[i-1]+1)
				return false;
		}
		return true;
		
	}
	
	
	
	
}


