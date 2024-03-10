package cbq;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/4667/
 * @author 长白崎
 * @class ["字符串","统计"]
 *
 */
public class 字符统计4664 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		char S[] = sc.next().toCharArray();
		
		int arr[] = new int['z'+1];
		int max = 0;
		for(int i = 0; i <S.length ; ++i) {
			++arr[S[i]];
			max = Math.max(arr[S[i]], max);
		}
		
		for(int i= 0;i<arr.length;++i) {
			if(arr[i]==max)
				System.out.print((char)i);
		}
		
	
	}

}
