package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class È«ÅÅÁĞ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		
		int data[] = new int[a];
		
		boolean state[] = new boolean[a];
		
		for(int i= 0; i <a ; ++i) {
			data[i] =sc.nextInt();
		}
		
		fullPer(data,state,new int[data.length],0);
		
		
		
		
		
	}
	
	
	public static void fullPer(int data[],boolean state[],int res[],int step) {
		if(step== data.length) {
			System.out.println(Arrays.toString(res));
			return;
		}
		
		for(int i= 0; i< data.length ; ++i) {
			if(state[i])
				continue;
			state[i] = true;
			res[step] = data[i];
			fullPer(data,state,res,step+1);
			state[i] = false;
		}
	}

}
