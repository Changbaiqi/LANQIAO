package lanqiao;

import java.util.Scanner;

public class �ۼ����� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuffer stringBuffer = new StringBuffer();
		
		while(sc.hasNext()) {
			String str = sc.next();
			stringBuffer.append(str);
		}
		
		
		char cc[] = stringBuffer.toString().toCharArray();
		
		int w=0;
		int l=0;
		for(int i = 0 ; i < cc.length ;++i) {
			if(cc[i]=='W')
				++w;
			if(cc[i]=='L')
				++l;
			
			if(i==cc.length-1) {
				System.out.println(w+":"+l);
				w=0;
				l=0;
				continue;
			}
			if(w+l==11) {
				System.out.println(w+":"+l);
				w=0;
				l=0;
			}
			
		}
		
		
		
		
		
		System.out.println();
		w=0;
		l=0;
		for(int i = 0 ; i < cc.length ;++i) {
			if(cc[i]=='W')
				++w;
			if(cc[i]=='L')
				++l;
			
			if(cc[i]=='E') {
				System.out.println(w+":"+l);
				w=0;
				l=0;
				continue;
			}
			
			if(i==cc.length-1) {
				System.out.println(w+":"+l);
				w=0;
				l=0;
				continue;
			}
			if(w+l==21) {
				System.out.println(w+":"+l);
				w=0;
				l=0;
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
