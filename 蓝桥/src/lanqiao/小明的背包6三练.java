package lanqiao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class С���ı���6���� {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(br);
		
		int N = sc.nextInt();
		int V = sc.nextInt();
		
		int w[] = new int[N+1];
		int v[] = new int[N+1];
		int s[] = new int[N+1];
		
		//������ϵͼ
		ArrayList<Integer> map[] = new ArrayList[N+1];
		for(int i=0 ; i <map.length ; ++i) map[i] = new ArrayList<Integer>();
		
		for(int i=1; i <=N ; ++i) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
			s[i] = sc.nextInt();
			map[s[i]].add(i);
		}
		
		int dp[][] = new int[N+1][V+1];
		dfs(map,dp,w,v,N,V,0);
		System.out.println(dp[0][V]);
	}
	
	public static void dfs(ArrayList<Integer> map[],int dp[][],int w[],int v[],int N,int V,int root) {
		//���ѡ���������Ʒ�Ļ�
		for(int i = 0; i <=V; ++i) {
			if(i>=w[root])
				dp[root][i]  = v[root];
		}
		
		for(int i=0 ; i <map[root].size() ; ++i) {
			//��ȡ���ڽڵ�ı��
			int son = map[root].get(i);
			
			dfs(map,dp,w,v,N,V,son);
			
			//������ڱ�����������
			for(int y = V ; y>=0; --y) {
				for(int x=0; x<=y-w[root];++x) {
					if(y>=x)
						dp[root][y] = Math.max(dp[root][y], dp[root][y-x]+dp[son][x]);
				}
			}
		}
	}

}
