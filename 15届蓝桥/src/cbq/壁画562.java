package cbq;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/564/
 * @author ������
 * @class ǰ׺�͡�˼ά�⡢ö��
 */
public class �ڻ�562 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	
		int T = sc.nextInt();
		
		for(int i=0;i<T;++i){
			int N = sc.nextInt();  //���ֳ���
			int len = (N+1)/2; //��󳤶�
			int data[] = new int[N+1];
			char arr[] = sc.next().toCharArray(); //��������
			for(int x = 0;x<N;++x) {data[x+1] = arr[x]-'0'+data[x];}
			int max = 0;
			for(int x= 1;x<=N-len+1;x++) {
				max = Math.max(max, data[x+len-1]-data[x-1]);
			}
			System.out.printf("Case #%d: %d\n",i+1,max);
		}
	}

}
