package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class ���ű�2022���������з� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc =  new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int data[] = new int[N+1];
		
		int dp[] = new int[N+1];
		dp[0] = 1;
		for(int i =1 ; i < data.length ; ++i) {
			data[i] = sc.nextInt();
			check(data,dp,i);
		}

		System.out.println(dp[N]%(((int)1e9)+7));
	}
	
	public static void check(int data[],int dp[],int index) {
		
		
		int min=data[index],max = data[index];
		for(int i =index ; i > 0 ; --i){
			min = Math.min(min, data[i]);
			max = Math.max(max, data[i]);
			if((index-i)==max-min) {
				dp[index]+=dp[i-1];
				dp[index]%=(((int)1e9)+7);
			}
		}
	}

}
