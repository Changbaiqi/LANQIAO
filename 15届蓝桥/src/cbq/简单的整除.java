package cbq;

import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/contest/71135/A
 * @class ����������
 * @author ������
 *
 */
public class �򵥵����� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int num = sc.nextInt();
		int yes=0;
		if(num%2==0)++yes;
		if(num%3==0)++yes;
		if(num%5==0)++yes;
		if(num%7==0)++yes;
		if(yes>0)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
