package lanqiao;

public class ÅĞ¶ÏÊÇ·ñÎªËØÊı {
	public static void main(String[] args) {
		System.out.println(primeNumber(3));
	}
	
	
	public static boolean primeNumber(int num) {
		for(int i= 2 ; i < Math.sqrt(num); ++i) {
			if(num%i==0)
				return false;
		}
		return true;
	}
}
