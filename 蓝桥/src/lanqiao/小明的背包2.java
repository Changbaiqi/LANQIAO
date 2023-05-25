package lanqiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * https://www.lanqiao.cn/problems/1175/learning/?page=1&first_category_id=1&sort=students_count&name=%E8%83%8C%E5%8C%85
    *   ע��δ��󣨱��ڴ棩
 * @author ������
 *
 */
public class С���ı���2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(System.in);
		
		StreamTokenizer sc = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		
		
		sc.nextToken();
		int N = (int)sc.nval;
		
		sc.nextToken();
		int V = (int)sc.nval;
		
		//int w[] = new int[N+1];
		//int v[] = new int[V+1];
		
		
		int dp[][] = new int[N+1][V+1];
		for(int y=1 ; y <=N ; y++) {
			sc.nextToken();
			//w[y] = (int)sc.nval;
			int w = (int)sc.nval;
			sc.nextToken();
			int v = (int)sc.nval;
			for(int x=1 ; x <= V ; x++) {
				if(w>x)
					dp[y][x] = dp[y-1][x];
				else
					dp[y][x] = Math.max(dp[y-1][x], dp[y][x-w]+v);
				
			}
		}
		System.out.println(dp[N][V]);
		

	}

}
