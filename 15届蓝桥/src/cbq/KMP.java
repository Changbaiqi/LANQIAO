package cbq;
import java.util.Arrays;
import java.util.Scanner;

public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//String s = sc.next();
		String pat = sc.next();
		
		int next[] = new int[pat.length()];
		
		buildNext(pat.toCharArray(), next);
		System.out.println(Arrays.toString(next));
		//System.out.println(kmp(s.toCharArray(),pat.toCharArray(),next));
		
	}
	
	
	
	public static int kmp(char s[],char pat[],int next[]) {
		
		
		int j=0;
		for(int i=0 ; i<s.length ; ++i) {
			while(j>0 && s[i]!=pat[j]) j = next[j-1];
			if(s[i]==pat[j]) ++j;
			if(j==pat.length) return i-pat.length+1;
		}
		return -1;
	}
	
	public static void buildNext(char pat[],int next[]) {
		
		int i = 0;
		for(int j=1; j < pat.length ; ++j) {
			while(i>0 && pat[i]!=pat[j]) i = next[i-1];
			if(pat[i]==pat[j]) ++i;
			next[j] = i;
		}
		
	}

}
