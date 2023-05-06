package lanqiao;

public class 求最小公倍数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lcd(4,8));
	}

	
	public static int lcd(int a,int b) {
		return a*b/gcd(a,b);
	}
	
	public static int gcd(int a,int b) {
		return b==0?a:gcd(b,a%b);
	}
}
