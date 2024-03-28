package cbq;

public class ĞÒÔËÊı×Ö1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long ans =0;
		for(int i =1; i<=20000000;++i) {
			if(check(i)) { ++ans;if(ans==2023) {System.out.println(i);}}
		}
		System.out.println(ans);
	}
	
	static boolean check(int num) {
		
		String  res = Integer.toBinaryString(num);
		int sum =0;
		for(int i= 0;i<res.length();++i) {sum += Integer.parseInt(res.charAt(i)+"",2);}
		if(num%sum!=0) return false;
		
		res = num+"";
		sum =0;
		for(int i= 0;i<res.length();++i) {sum += Integer.parseInt(res.charAt(i)+"",10);}
		
		if(num%sum!=0) return false;
		
		res = Integer.toOctalString(num);
		sum =0;
		for(int i= 0;i<res.length();++i) {sum += Integer.parseInt(res.charAt(i)+"",8);}
		if(num%sum!=0) return false;
		
		res = Integer.toHexString(num);
		sum =0;
		for(int i= 0;i<res.length();++i) {sum += Integer.parseInt(res.charAt(i)+"",16);}
		if(num%sum!=0) return false;
		
		
		return true;
	}

}
