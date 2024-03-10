package cbq;

import java.util.Scanner;

public class π‚ÀŸ«©µΩ {

	static long max =-1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		
		
		int N = sc.nextInt();
		int map[] = new int[N];
		boolean state[] = new boolean[N];
		
		for(int i=0;i<N;++i) {
			map[i] = sc.nextInt();
		}
		
		allF(map, state, 0, 0);
		if(max!=-1) {
			int len = String.valueOf(max).length();
			String res ="";
			if(len!=map.length) {
				for(int i=0;i< map.length-len;++i) {res+="0";}
			}
			res+=max;
			System.out.println(res);
		}
		else
			System.out.println(max);
		
		
	}
	public static void allF(int map[],boolean state[],int ans,int sum) {
		if(sum==map.length) {
			if(ans%10!=0)
				return;
			max=max<ans?ans:max;
			return;
		}
		for(int i=0 ;i< map.length;++i) {
			if(state[i])
				continue;
			state[i]=true;
			allF(map,state,ans*10+map[i],sum+1);
			state[i]= false;
		}
	}

}
