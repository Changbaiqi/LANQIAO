package cbq;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NOIP2017图书管理员 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int q = sc.nextInt();
		int data[] = new int[n];
		for(int i = 0; i < n ; ++i) {
			data[i] = sc.nextInt();
		}
		
		Arrays.sort(data);
		
		for(int i= 0; i < q; ++i) {
			int len = sc.nextInt();
			int late = sc.nextInt();
			boolean flag = false;
			for(int  x = 0 ; x < n ; ++x) {
				String str =String.valueOf(data[x]);
				Pattern pattern = Pattern.compile("[\\d\\D]+"+late);
				Matcher m =pattern.matcher(str);
				if(m.find()) {
					System.out.println(str);
					flag=true;
					break;
				}

			}
			if(flag) System.out.println(-1);
		}
		
	}

}
