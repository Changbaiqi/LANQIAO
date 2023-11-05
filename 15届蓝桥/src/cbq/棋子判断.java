package cbq;

public class 棋子判断 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int map[][] = new int[10][10];
		
		map[1][1]=1;
		map[1][2]=2;
		map[1][3]=1;
		System.out.println(lr(map,1,1,1));
		
	}
	
	static int lr(int map[][],int x,int y,int q) {
		int l=l(map,x-1,y,q);
		int r = r(map,x,y,q);
		return l+r;
	}
	static int l(int map[][],int x,int y,int q) {
		int h = map.length;
		int w = map[0].length;
		
		//过滤边界
		if(h<=y || y<0 || w<=x || x<0)
			return 0;
		
		if(map[y][x]!=q)
			return 0;
		
		return l(map,x-1,y,q)+1;
	}
	static int r(int map[][],int x,int y,int q) {
		int h = map.length;
		int w = map[0].length;
		
		//过滤边界
		if(h<=y || y<0 || w<=x || x<0)
			return 0;
		
		if(map[y][x]!=q)
			return 0;
		
		return r(map,x+1,y,q)+1;
	}

}
