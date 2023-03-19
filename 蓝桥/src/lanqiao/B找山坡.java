package lanqiao;

import java.util.Scanner;
import java.util.Stack;

public class B��ɽ�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int data[] = new int[n];
		Stack<Integer> stack = new Stack<>();
		int ans =0 ;
		for(int i = 0; i< n ; ++i) {
			data[i] = sc.nextInt();
			while(stack.size()>0 && data[stack.peek()]> data[i]) stack.pop();
			if(stack.isEmpty()) 
				stack.push(i);
			else if(data[stack.peek()]== data[i])
				ans = Math.max(ans, i-stack.peek());
			else
				stack.push(i);
		}
		System.out.println(ans);
		
		
	}

}
