package lanqiao;

import java.util.Scanner;

public class �ɼ����� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int min =101,max=0;
		int ans =0;
		for(int i =0; i < n ; ++i) {
			int num = sc.nextInt();
			ans+=num;
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		System.out.println(max);
		System.out.println(min);
		System.out.println(String.format("%.2f",(ans*1.0)/(n*1.0)));
		
		
		
		
		
		
	}

}