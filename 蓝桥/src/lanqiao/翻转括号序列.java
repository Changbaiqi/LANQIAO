package lanqiao;

import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/1589/learning/?page=1&first_category_id=1&sort=students_count&tags=%E5%9B%BD%E8%B5%9B&name=%E7%BF%BB%E8%BD%AC
 * @author ³¤°×Æé
 *
 */
public class ·­×ªÀ¨ºÅÐòÁÐ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		
		char str[] = sc.next().toCharArray();
		
		for(int i= 1 ; i <= m; ++i) {
			int c = sc.nextInt();
			//²Ù×÷2
			if(c==2) {
				int index = sc.nextInt();
				long ans=0;
				int maxIndex = 0;
				for(int x =index-1 ; x<str.length; ++x) {
					if(str[x]=='(')
						++ans;
					else if(str[x]==')')
						--ans;
					if(ans<0)
						break;
					else if(ans==0)
						maxIndex = x+1; 
						
				}
				System.out.println(maxIndex);
			}else if(c==1) {//²Ù×÷1
				int L = sc.nextInt();
				int R = sc.nextInt();
				
				for(int x = L-1 ; x<=R-1 ; ++x) {
					if(str[x]=='(')
						str[x] = ')';
					else if(str[x]==')')
						str[x] = '(';
				}
			}
			
			
		}
		
	}

}
