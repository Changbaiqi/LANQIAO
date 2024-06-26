package lanqiao;

import java.util.Stack;
/**
 * https://leetcode.cn/problems/number-of-islands/
 * @author 长白崎
 *
 */
public class 岛屿数量 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		char[][] map = {
//				{'1','1','1','1','0'},
//				{'1','1','0','1','0'},
//				{'1','1','0','0','0'},
//				{'0','0','0','0','0'}
//		};
		char[][] map = {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
		};
		
		System.out.println( numIslands(map) );
		
		
	}
	
	
	public static int numIslands(char[][] grid) {
		
		
		int y = grid.length;
	    int x = grid[0].length;
		
		//标记是否走过
		boolean state[][] = new boolean[y][x];
		
		int sum =0;
		for(int a =0 ; a<y; ++a) {
			for(int b =0 ; b< x ; ++b) {
				if(check(state,grid,b,a))
					++sum;
			}
		}
		
		return sum;
	}
	
	
   public static boolean check(boolean state[][],char[][] grid,int start_x,int start_y) {
	   
	   if(grid[start_y][start_x]=='0')
			return false;
	   
	   if(state[start_y][start_x])
		   return false;
	   
	    int y = grid.length;
	    int x = grid[0].length;
		
	    //栈
	    Stack<Integer[]> stack= new Stack<Integer[]>();
				
		stack.push(new Integer[] {start_x,start_y});
		state[start_y][start_x]= true;
		
		while(!stack.isEmpty()) {
			
			Integer[] point = stack.pop();
			
			//可能走的方向
			int next[][] = {
					{point[0],point[1]-1},
					{point[0],point[1]+1},
					{point[0]-1,point[1]},
					{point[0]+1,point[1]}
			};
			
			
			for(int i= 0 ; i < next.length ; ++i) {
				
				//检测数据合法性
				if(next[i][0]<0 || next[i][1]<0 || next[i][0]>=x || next[i][1]>=y )
					continue;
				
				if(state[next[i][1]][next[i][0]])
					continue;
				
				if(grid[next[i][1]][next[i][0]]=='0')
					continue;
					
				
				state[next[i][1]][next[i][0]] = true;
				stack.push(new Integer[] {next[i][0],next[i][1]});
				
			}
			
			
		}
		
		return true;
   }
}
