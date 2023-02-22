package lanqiao;

import java.util.Scanner;
  
public class ×Ö·ûÍ³¼Æ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        
		Scanner sc = new Scanner(System.in);
		
		String in = sc.nextLine();
		
		int data[] = new int['z'+1];
		
		int max = 0;
		for( int i = 0; i < in.length() ; ++i){
			
			++data[in.charAt(i)];
			max = max < data[in.charAt(i)] ? data[in.charAt(i)] : max;
		}
		
		for(int i = 0 ; i < data.length ; ++i) {
			if(data[i] == max)
				System.out.print((char)i);
			
		}
		
		
	}

}
