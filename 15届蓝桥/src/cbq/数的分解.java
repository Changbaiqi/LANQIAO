package cbq;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 无
 * 
 * @author 20840 
 * @class["第十届蓝桥真题"]
 */
public class 数的分解 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> cc = new HashSet<>();
		for (int i = 1; i <= 2019; ++i) {
			if(!check(i))continue;
			for (int j = 1; j <= 2019 - i; ++j) {
				int z = 2019-i-j;
				if(z==0) continue;
				if(!check(j)) continue;
				if(!check(z)) continue;
				if(i==j || i==z || j==z) continue;
				
				int res[] = new int[] {i,j,z}; Arrays.sort(res);
				String c = res[0]+"-"+res[1]+"-"+res[2];
				if(cc.contains(c)) continue;
				cc.add(c);
			}
		}
		System.out.println(cc.size());
	}
	
	static boolean check(int i) {
		int res= i;
		while(res!=0) {
			if(res%10==2 || res%10==4) return false;
			res/=10;
		}
		return true;
	}
	

}
