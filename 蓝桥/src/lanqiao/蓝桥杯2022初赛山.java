package lanqiao;

import java.util.Scanner;

public class ���ű�2022����ɽ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		long ans =0;
//		for(int i= 20; i <= 20223; ++i) {
//			StringBuffer ss = new StringBuffer(String.valueOf(i));
//			
//			String s1 = ss.toString();
//			String s2  = ss.reverse().toString();
//			String con = s1+s2;
//			int num = Integer.valueOf(con);
//			if(num<2022 && num>2022222022)
//				continue;
//			++ans;
//			
//			//int a1 = 2022332202;
//		}
//		System.out.println(ans);
		long ans =0;
		for(int i= 2022; i <=2022222022;++i) {
			String ss = String.valueOf(i);
			String a1 = ss.substring(0, ss.length()/2);
			StringBuffer a2 = new StringBuffer( ss.substring(ss.length()-(ss.length()/2),ss.length()) );
			a2 = a2.reverse();
			if(a1.equals(a2.toString()))
				++ans;
			
		}
		System.out.println(ans);
	}

}
