package cbq;

import java.util.Scanner;
/**
 * https://www.acwing.com/problem/content/1357/
 * @author ³¤°×Æé
 * @class["dfs","bfs"]
 */
public class Ä¸Ç×µÄÅ£ÄÌ {
	static long ans =0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int max[] = new int[] {A,B,C};
		
		boolean state[][][] = new boolean[A+1][B+1][C+1];
		boolean va[] = new boolean[C+1];
		dfs(state,va,max,0,0,C);
		for(int i =0;i<=C;++i) {
			if(va[i])System.out.print(i+" ");
		}
	}
	
	static void dfs(boolean state[][][],boolean va[],int max[],int a,int b,int c) {		
		if(state[a][b][c]) return;
		state[a][b][c] = true;
		++ans;
		if(a==0) va[c]=true;
		dfs(state,va,max,a-Math.min(a, max[1]-b),Math.min(a+b, max[1]),c);
		dfs(state,va,max,a-Math.min(a, max[2]-c),b,Math.min(c+a, max[2]));
		dfs(state,va,max,a,b-Math.min(b, max[2]-c),Math.min(b+c, max[2]));
		dfs(state,va,max,a,Math.min(b+c, max[1]),c-Math.min(max[1]-b, c));
		dfs(state,va,max,Math.min(a+c, max[0]),b,c-Math.min(max[0]-a, c));
		dfs(state,va,max,Math.min(a+b, max[0]),b-Math.min(b, max[0]-a),c);
	} 

}