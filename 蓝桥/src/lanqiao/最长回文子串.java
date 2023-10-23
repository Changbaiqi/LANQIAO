package lanqiao;

import java.util.Scanner;

public class 最长回文子串 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		char str[] = sc.next().toCharArray();
		System.out.println(manacher(str));
	}
	
	
	public static int manacher(char str[]) {
		
		char resStr[] = new char[str.length*2+1+2];
		resStr[0]='^';
		resStr[1]='#';
		for(int i= 0; i < str.length ; ++i) {
			resStr[i*2+2]=str[i];
			resStr[i*2+2+1]='#';
		}
		resStr[resStr.length-1]='*';
		
		int i= 1;
		int maxLen = 0;
		while(i<resStr.length-2) {
			int len =0;
			int l =i-1;
			int r =i+1;
			while(resStr[l]==resStr[r]) { 
				++len;
				l-=1;
				r+=1;
			}
			
			maxLen = maxLen>len?maxLen:len;
			++i;
		}
		return maxLen;
	}

}
