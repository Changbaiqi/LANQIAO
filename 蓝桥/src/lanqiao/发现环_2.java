package lanqiao;

import java.util.HashSet;
import java.util.Scanner;

public class 发现环_2 {
	public static void main(String[] args) {
		
		//入点_1
		int e[] = new int[100001];
		//出点_1
		int o[] = new int[100001];
		
		//入点_2
		int ne[] = new int[100001];
		//出点_2
		int no[] = new int[100001];
		
		//存储点
		HashSet<Integer> point  = new HashSet<Integer>();
		
		Scanner sc = new Scanner(System.in);
		
		int N= sc.nextInt();
		
		for(int i= 0; i< N ; ++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			point.add(a);
			point.add(b);
			
			++o[a];
			++ne[a];
			
			++e[b];
			++no[b];
		}
		
		Integer dd[] =  point.toArray(new Integer[0]);
		
		for(int i= 0; i <dd.length ; ++i) {
			if(e[dd[i]]!=0&& ne[dd[i]]!=0) {
				System.out.print(dd[i]+" ");
			}
		}
		
		
		
		
		
		
	}
}
