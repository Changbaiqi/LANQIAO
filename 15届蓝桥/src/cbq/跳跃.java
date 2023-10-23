package cbq;
import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/553/learning/?page=2&first_category_id=1&sort=students_count
 * @author 长白崎
 *
 */
public class 跳跃 {

	static long maxSum =0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		
		
		int map[][] = new int[n][m];
		boolean state[][] = new boolean[n+1][m];
		
		
		for(int y = 0 ; y <n ; ++y) {
			for(int x =0; x <m ; ++x) {
				map[y][x] = sc.nextInt();
			}
		}
		state[0][0] = true;
		dfs(0,0,m-1,n-1,map,state,map[0][0]);
		System.out.println(maxSum);
	}
	
	public static void dfs(int startX,int startY,int endX,int endY,int map[][],boolean state[][],long sum) {
		
		if(startX==endX && startY== endY) {
			maxSum = Math.max(maxSum, sum);
			return;
		}
		
		int next[][]= {
				{startX,startY+1},//下1
				{startX,startY+2},//下2
				{startX+1,startY},//右1
				{startX+2,startY}//右2
		};
		
		for(int i= 0; i < 4 ; ++i) {
			//过滤越界
			if(next[i][0]<0 || next[i][1]<0 || next[i][0]>=map[0].length || next[i][1]>=map.length)
				continue;
			
			//过滤走过的
			if(state[next[i][1]][next[i][0]])
				continue;
			
			state[next[i][1]][next[i][0]] = true;
			dfs(next[i][0],next[i][1],endX,endY,map,state,map[next[i][1]][next[i][0]]+sum);
			state[next[i][1]][next[i][0]] = false;
		}
		
		
	}

}
