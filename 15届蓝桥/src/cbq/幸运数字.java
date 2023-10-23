package cbq;

import java.math.BigInteger;

/**
 * https://www.lanqiao.cn/problems/3499/learning/?page=1&first_category_id=1&sort=students_count&name=%E5%B9%B8%E8%BF%90
 * @class 第十四届蓝桥杯JavaB组省赛、枚举，进制转换
 * @author 长白崎
 *
 */
public class 幸运数字 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		int num =1;
		while(i!=2023) {
			if(check(num)) {
				System.out.println(num);
				++i;
			}
			++num;
		}
	}
	
	public static boolean check(int num) {
		//Dex
		long ans1 =0;
		long num1 = num;
		while(num1!=0) {
			ans1+=num1%10;
			num1/=10;
		}
		if(num%ans1!=0)
			return false;
	
		//oct
		Long ans2 = 0l;
		Long num2 = Long.parseLong(Long.toOctalString(num));
		
		while(num2!=0) {
			ans2 += num2%10;
			num2/=10;
		}
		if(num%ans2!=0)
			return false;
		
		//hex
		Long ans3 = 0l;
		char num3[] = Long.toHexString(num).toCharArray();
		
		for(int i= 0 ; i < num3.length; ++i) {
			ans3+=Long.valueOf(String.valueOf(num3[i]), 16);
			
		}
		if(num%ans3!=0)
			return false;
		
		//bit
		char num4[] = Long.toBinaryString(num).toCharArray();
		Long ans4 = 0l;
		for(int i= 0;i < num4.length ; ++i) {
			if(num4[i]=='1')
				ans4+=1;
		}
		
		if(num%ans4!=0)
			return false;
		
		
		return true;
	}

}
