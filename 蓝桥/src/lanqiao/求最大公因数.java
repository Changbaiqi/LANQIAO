package lanqiao;

public class 求最大公因数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcd(36,8));
	}
	
	
	public static int gcd(int a,int b) {
		return b==0? a:gcd(b,a%b);
	}

}
