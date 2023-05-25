package lanqiao;

import java.util.ArrayList;
import java.util.Scanner;

public class С���ı���6���� {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //��Ʒ����
		int V = sc.nextInt(); //��������
		
		ArrayList<Integer> map[] = new ArrayList[N+1];
		for(int i =0 ; i <=N ; ++i) map[i] = new ArrayList<Integer>();
		
		int w[] = new int[N+1];
		int v[] = new int[N+1];
		int s[] = new int[N+1];
		
		for(int i= 1 ; i <= N ; ++i) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
			s[i] = sc.nextInt();
			
			map[s[i]].add(i); 
		}
		
		int dp[][] = new int[N+1][V+1];
		dfs(map,w,v,s,N,V,0,dp);
		System.out.println(dp[0][V]);
	}
	
	
	public static void dfs(ArrayList<Integer> map[],int w[],int v[],int s[],int N,int V,int root,int dp[][]) {
		
		//����ѡ���������Ʒ�Ļ�
		for(int i=0 ;i <= V ; ++i) {
			if(i>=w[root])
				dp[root][i] = v[root];
		}
		
		//��һ������ö���Ըõ�Ϊ���ڵ�ʱ�������ĵĸ��ڵ㡣
		for(int i=0 ;i <map[root].size() ; ++i) {
			int son = map[root].get(i); //��ȡ��Ӧ���ı��
			
			dfs(map,w,v,s,N,V,son,dp);
			//��������ڱ�����������
			for(int y = V ; y>=0 ; --y) {
				//�����x��ʵҪ��x-w[root]����ſ���������ʵ�������˼������˵�������������Ϊyʱ�����ѡ��root�����������и�x-w[root])�������ô��������ӽ�������ѡ�񷽰��⣬��ѡ�����ļ�ֵ��
				for(int x = 0 ; x <= y-w[root] ; ++x) {
					if(y-x>=0)
						//������˼����˵��rootΪ���ڵ�Ļ�����������Ϊx��ʱ�����������������ö�ٵ��ӽ��sonΪ���ڵ�ʱ����������ѡ�����м�ֵ�ķ�����
						dp[root][y] = Math.max(dp[root][y],dp[root][y-x]+dp[son][x] );
					
				}
			}
	
		}
		
		
				
	}

}
