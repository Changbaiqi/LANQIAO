package cbq;

import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/5128/learning/?contest_id=144
 * @class ��
 * @author ������
 *
 */
public class ������ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		
		
		
		//����
		int q = sc.nextInt();
		//ѯ�ʵ�·������
		int n = sc.nextInt();
		
		for(int i=0 ; i < n ; ++i) {
			char path[] = sc.next().toCharArray();
			int now = 1;
			for(int x = 0;x < path.length ; ++x) {
				if(path[x]=='R') {
					now =now*2;
				}else {
					now = now*2-1;
				}
			}
			System.out.println(now);
		}
		
		
		
		
	}

}
