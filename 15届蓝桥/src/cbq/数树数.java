package cbq;

import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/5128/learning/?contest_id=144
 * @class 树
 * @author 长白崎
 *
 */
public class 数树数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		
		
		
		//层数
		int q = sc.nextInt();
		//询问的路径数量
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
