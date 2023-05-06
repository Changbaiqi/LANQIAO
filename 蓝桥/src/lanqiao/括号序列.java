package lanqiao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 括号序列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		//0为左括号数，1为有括号数
		int data[][] = new int[s.length()+1][2];
		
		int l=0,r =0;
		for(int i= 1 ; i <=s.length() ; ++i) {
			if(s.charAt(i-1)=='(') {
				++l;
				data[i][1]= data[i-1][1]+1;
				data[i][0] = data[i-1][0];
			}else {
				++r;
				data[i][1]= data[i-1][1];
				data[i][0] = data[i-1][0]+1;
			}
		}
		
		//还差几个左括号
		int disL = r-l <=0? 0: r-l;
		//还差几个右括号
		int disR = l-r <= 0? 0 : l-r;
		

		
		
		
		
	}

}
