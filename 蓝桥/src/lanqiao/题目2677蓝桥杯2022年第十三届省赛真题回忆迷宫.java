package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class 题目2677蓝桥杯2022年第十三届省赛真题回忆迷宫 {

	static int min_x=300,min_y=300,max_x = 0,max_y=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int resMap[][] = new int[301][301];
		
		Scanner sc = new Scanner(System.in);
		int stepNum  = sc.nextInt();
		String stepStr = sc.next();
		//根据步数填迷宫
		polo_1(resMap,stepStr.toCharArray());
		//裁剪迷宫
		polo_2(resMap);
	}
	
	//根据步数填迷宫
	public static void polo_1(int resMap[][],char steps[]) {
		 
		int x = 150,y=150;
		for(int i = 0; i < steps.length ; ++i){
			if(steps[i]=='U') {
				resMap[--y][x] =1;
			}
			if(steps[i]=='D') {
				resMap[++y][x]=1;
			}
			if(steps[i] == 'L') {
				resMap[y][--x] = 1;
			}
			if(steps[i]=='R') {
				resMap[y][++x] = 1;
			}

			min_x = Math.min(min_x, x);
			min_y = Math.min(min_y, y);
			max_x = Math.max(max_x, x);
			max_y = Math.max(max_y, y);
		}
		
	}
	
	//裁剪迷宫
	public static int[][] polo_2(int resMap[][]){
		int map[][] = new int[max_y+1-(min_y-2)][max_x+1-(min_x-2)];
		for(int y = min_y-1 ; y <= max_y+1 ; ++y ) {
			for(int x = min_x-1 ; x<= max_x+1 ; ++x) {
				map[y-(min_y-1)][x-(min_x-1)] = resMap[y][x];
			}
		}
		
		//传染算法
		for(int y = 0 ; y < map.length ; ++y) {
			for(int x =0 ; x < map[y].length ; ++x) {
				//列举方向
				int next[][] = {
						{y-1,x},
						{y +1,x},
						{y,x-1},
						{y,x+1}
				};
				if(map[y][x]!=1)
					continue;
				for(int i = 0; i < next.length ; ++i) {
					if(next[i][0]<0 || next[i][1]<0 ||next[i][0]>map.length-1 || next[i][1] > map[y].length-1)
						continue;
					if(map[next[i][0]][next[i][1]]==1)
						continue;
					map[next[i][0]][next[i][1]] = 2;
					
				}
			}
		}
//		for(int i = 0 ; i < map.length ; ++i) {
//		System.out.println(Arrays.toString(map[i]));
//	}
	
		//宫外填平
		for(int y= 0 ;y < map[0].length ; ++y) {
			if(map[0][y]!=0)
				continue;
			
			polo_3(map,0,y);
		}
		for(int y= 0 ;y < map[0].length ; ++y) {
			if(map[map.length-1][y]!=0)
				continue;
			
			polo_3(map,map.length-1,y);
		}
		for(int y= 0 ;y < map.length ; ++y) {
			if(map[y][0]!=0)
				continue;
			
			polo_3(map,y,0);
		}
		for(int y= 0 ;y < map.length ; ++y) {
			if(map[y][map[0].length-1]!=0)
				continue;
			
			polo_3(map,y,map[0].length-1);
		}
		
		
		
//		for(int i = 0 ; i < map.length ; ++i) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		for(int y =0 ;y < map.length ; ++y) {
			StringBuffer strLin = new StringBuffer();
			int end = 0;
			for(int x = 0 ;x < map[y].length ; ++x) {
				if(map[y][x]==2||map[y][x]==0) {
					strLin.append('*');
					end = x;
				}
				else
					strLin.append(' ');
			}
			
			System.out.println(strLin.toString().substring(0, end+1));
			
		}
		
		return map;
	}
	

	//传染算法标记第一行和最后一行
	public static void polo_3(int map[][],int y,int x){
		
		if(y<0||x<0 ||y>map.length-1 || x>map[0].length-1)
			return;
		if(map[y][x]!=0)
			return;
		
		map[y][x] = 3;
		polo_3(map,y-1,x);
		polo_3(map,y+1,x);

		polo_3(map,y,x-1);
		polo_3(map,y+1,x+1);
		polo_3(map,y+1,x);
	}
	
	

}
