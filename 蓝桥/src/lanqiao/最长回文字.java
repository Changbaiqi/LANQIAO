package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class 最长回文字 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		 
		 int n = sc.nextInt();
		 
		 String A= sc.next();
		 String B= sc.next();
		 
		 int Ap[] = new int[A.length()+(A.length()+1)+2];
		 int Bp[] = new int[B.length()+(B.length()+1)+2];
		 char Am[] = Manacher(A.toCharArray(), Ap).toCharArray();
		 char Bm[] = Manacher(B.toCharArray(), Bp).toCharArray();
		 
		 int max =1;
		 for(int i = 2 ; i < Am.length-1 ; ++i) {
			 int len = Math.max(Ap[i], Bp[i-2]);
			 while(Am[i-len]==Bm[i-2+len]) ++len;
			 max = Math.max(len-1, max);
			 
		 }
		 System.out.println(max);
	}
	
	//Manacher算法
	public static String Manacher(char str[],int p[]) {
		String resStr = "$#";
		
		for(int i = 0 ; i < str.length ; ++i) {
			resStr+=str[i];
			resStr+="#";
		}
		resStr+="^";
		
		char resChar[] = resStr.toCharArray();
		for(int i = 1 ; i< resChar.length-1 ; ++i) {
			int x=0;
			while(resChar[i-x-1]==resChar[i+x+1]) {++x;}
			p[i] = x;
		}
		
		return resStr;
	}

}
