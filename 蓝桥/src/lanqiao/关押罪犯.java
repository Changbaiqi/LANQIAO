package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class 关押罪犯 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		CT data[] = new CT[N+1];
		for(int i = 1;i <=N ; ++i) {
			data[i] = new CT(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(data,1,data.length,(x,y)->{
			return y.c-x.c;
		});
		
		
		//分类并查集算法数组
		int map[] = new int[N*2+1];
		//初始化分类并查集
		for(int i= 1; i <=N*2 ; ++i) map[i] = i;
		
		for(int i= 1 ; i <=N ; ++i) {
			//如果并查集查询相等，那么返回结果
			if(query(map, data[i].a, data[i].b)) {
				
			}
			
		}
		
		System.out.println();
	}
	
	//比较
	public static boolean query(int map[],int a,int b) {
		return find(map,a)==find(map,b);
	}
	//查询
	public static int find(int map[],int i) {
		return map[i]==i? i : find(map,map[i]);
	}
	
	//并查集父节点修改
	public static void edit(int map[],int a,int b) {
		
	}
	
	
	static class CT{
		int a;
		int b;
		int c;
		public CT(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
	}

}
