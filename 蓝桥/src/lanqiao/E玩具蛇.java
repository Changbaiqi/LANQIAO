package lanqiao;

public class E����� {

	static int sum = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int y = 0 ; y < 4 ; ++y ) {
			for(int x = 0 ; x < 4; ++x) {
				int map[][]=new int[4][4];
				map[y][x] = 1;
				dfs(map,y,x,1);
			}
		}
		System.out.println(sum);
	}
	
	public static void dfs(int map[][],int y,int x,int step) {
		
		if(step==16) {
			++sum;
			return;
		}
		
		int next[][]= {
				{y-1,x},
				{y+1,x},
				{y,x-1},
				{y,x+1}
		};
		
		for(int i = 0 ; i < 4 ; ++i) {
			
			if(next[i][0]<0 || next[i][1]<0 ||next[i][0]>3 ||next[i][1]>3)
				continue;
			
			if(map[next[i][0]][next[i][1]]==1)
				continue;
			
			map[next[i][0]][next[i][1]]=1;
			
			dfs(map,next[i][0],next[i][1],step+1);
			
			map[next[i][0]][next[i][1]]=0;
			
		}
		
		
		
	}

}
