package cbq;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/5132/learning/?contest_id=144
 * @class KMP£¬×Ö·û´®
 * @author ³¤°×Æé
 *
 */
public class ÆõºÏÆ¥ÅäËã·¨Èü {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String S_str = sc.next();
		char T[] = sc.next().toCharArray();
		
		char S[] = (S_str+S_str+S_str).toCharArray();

		int next[]=buildNext(T);
		int result = kmp(S,T,next);
		if(result==-1) {
			System.out.println("No");
			return;
		}
		
		
		result = Math.abs(S_str.length()-result)>result? result:Math.abs(S_str.length()-result);
		System.out.println("Yes");
		System.out.println(result);
		
	}
	
	static int kmp(char s1[],char s2[],int next[]) {
//		int M = s1
		int i=0,j = 0;
		while(i<s1.length) {
			while(j>0) { 
				if(s1[i]>=65 && s1[i]<97) {
					if((s1[i]+32)!=s2[j]) {
						j=next[j-1];
						continue;
					}
					break;
				}else {
					if((s1[i]-32)!=s2[j]) {
						j=next[j-1];
						continue;
					}
					break;
				}
			}
			
//			if(s1[i]==s2[j]) ++j;
			if(s1[i]>=65 && s1[i]<97) {
				if((s1[i]+32)==s2[j]) ++j;
			}else {
				if((s1[i]-32)==s2[j])++j;
			}
			if(j==s2.length) return i-s2.length+1;
			++i;
		}
		return -1;
	}
	
	static int[] buildNext(char s2[]) {
		int next[] = new int[s2.length];
		
		int i=0,j=1;
		while(j<s2.length) {
			while(i>0&&s2[j]!=s2[i]) i = next[i-1];
			if(s2[j]==s2[i]) ++i;
			next[j] = i;
			++j;
		}
		return next;
	}

}
