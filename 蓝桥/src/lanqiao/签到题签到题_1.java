package lanqiao;

import java.util.Scanner;

public class ǩ����ǩ����_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		char data[] = sc.nextLine().toCharArray();
		int ans =0;
		for(int i= 0 ; i < data.length ; ++i) {
			if(data[i]==' ' || data[i]=='\n' || data[i]=='\r')
				continue;
			++ans;
		}
		System.out.println(ans);
		
	}

}
