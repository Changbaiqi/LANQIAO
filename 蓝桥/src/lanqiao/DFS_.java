package lanqiao;


import java.util.Scanner;


public class DFS_ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int ans = 1;
		int n = sc.nextInt();
		int xh = sc.nextInt();
		for(int i=1 ; i < n ; ++i) {
			int m = sc.nextInt();
			if(xh>m)
				++ans;
		}
		
		int win = 0;
		while(ans>1) {
			ans/=2;
			++win;
		}
		System.out.println(win);
	}

}
