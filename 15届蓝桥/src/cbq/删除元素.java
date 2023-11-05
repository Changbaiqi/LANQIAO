package cbq;

import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/problem/22228
 * @class 基础题、数组
 * @author 长白崎
 *
 */
public class 删除元素 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n= sc.nextInt();
			int arr[] = new int[n];
			for(int i=0; i < n; ++i) {arr[i] = sc.nextInt();}
			int flag = sc.nextInt();
			for(int i=0,x=0 ; i < n; ++i) {if(x==0&& flag==arr[i]) { x=1;continue;} System.out.print(arr[i]+" ");}	
            System.out.println();
		}
	}
}
