package lanqiao;

import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/1371/learning/?page=1&first_category_id=1&sort=students_count&second_category_id=8
 * @author ³¤°×Æé
 *
 */
public class »ØÎÄÅĞ¶¨ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//×Ö·û´®
		String str = sc.next();
		if(check(str))
			System.out.println("Y");
		else
			System.out.println("N");
	}
	
	public static boolean check(String str) {
		
		for(int l=0,r=str.length()-1;r-l>0;--r,++l) {
			if(str.charAt(l)!=str.charAt(r))
				return false;
		}
		return true;
	}
	

}
