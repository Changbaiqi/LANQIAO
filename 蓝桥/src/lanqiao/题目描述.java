package lanqiao;

import java.util.Arrays;

public class ��Ŀ���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int map[] = new int[10];
		Arrays.fill(map, 2021);
		
		int i = 1;
		while(true) {
			int res = i;
			boolean cc=false;
			while(res!=0) {
				int index = res%10;
				res/=10;
				if(map[index]>0)
					--map[index];
				else {
					System.out.println(i-1);
					return;
				}
					
			}
			++i;
		}
		
	}

}
