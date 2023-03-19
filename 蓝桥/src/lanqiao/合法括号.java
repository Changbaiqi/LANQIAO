package lanqiao;

import java.util.Scanner;

public class ºÏ·¨À¨ºÅ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		char data[] = sc.next().toCharArray();
		
		int a=0,b=0;
		for(int i = 0 ; i < data.length ; ++i) {
			if(data[i]=='(')
				++a;
			if(data[i]==')')
				++b;
			if(b>a) {
				System.out.println("NO");
				return;
			}
		}
		if(a!=b)
			System.out.println("NO");
		else
			System.out.println("YES");
		
	}

}
