package lanqiao;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 斤斤计较的小Z {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String s1 = sc.next();
		String s2 = sc.next();
		
		System.out.println(slove(s1, s2));
	}
	
	public static long slove(String s1,String s2) {
		Pattern pattern = Pattern.compile(s1);
		Matcher matcher = pattern.matcher(s2);
		long ans =0;
		while(matcher.find()) {
			matcher.group();
			++ans;
		}
		return ans;
	}

}
