package lanqiao;

public class ɽ {
    
	static int sun = 0;
	
	public static void main(String[] args) {
		
		
		for(int i = 2022 ; i <= 2022222022 ; ++i) {
			
			if(check(i)) {
				++sun;
			}
			
		}
		System.out.println(sun);
		
	}
	
	
	public static boolean check(int num) {
		String str = String.valueOf(num);
		char num_c[] = str.toCharArray();
		
		for(int i = 1; i <= num_c.length/2 ; ++i) {
			
			//�Ƿ��ʺϵ�����
			if(num_c[i-1] <= num_c[i] && num_c[ num_c.length-1-(i-1) ] == num_c[i-1] && num_c[ num_c.length-1-(i)]== num_c[i] ) {
				
			}else {
				return false;
			}
		}
		
		
		
		
		
		return true;
	}
}