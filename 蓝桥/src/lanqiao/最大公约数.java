package lanqiao;

import java.util.Scanner;
/**
 * https://www.lanqiao.cn/problems/1260/learning/?page=1&first_category_id=1&sort=students_count&second_category_id=8
 * @author ������
 *
 */
public class ���Լ�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=0 ; i < T ; ++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(gcd(a,b));
		}
		
	}
	
	//gcd����
	public static int gcd(int a,int b) {
		return b==0?a:gcd(b,a%b);
	}

}
