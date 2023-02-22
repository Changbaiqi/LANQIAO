package lanqiao;

public class Ñî»ÔÈı½Ç {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(polo_1(2,4));
		
	}
	
	//¼ÆËãÖµ
	public static int polo_1(int n1,int n2) {
		
		int sum =1;
		for(int i=n2-n1;i>1 ;--i) {
			sum*=n2;
			--n2;
			if(n1>1) {
				sum/=n1;
				--n1;
			}
		}
		return sum;
	}

}
