package cbq;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/contest/71135/E
 * @class ����
 * @author ������
 *
 */
public class ���Ĳ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int data[] = new int[n];
		for(int i=0;i<n;++i) data[i] = sc.nextInt();
		Arrays.sort(data);
		System.out.println(data[n-1]-data[0]);
	}

}
