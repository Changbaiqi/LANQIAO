package lanqiao;

import java.math.BigInteger;
/**
 * https://www.lanqiao.cn/problems/1020/learning/?page=1&first_category_id=1&sort=students_count&tags=%E5%9B%BD%E8%B5%9B
 * @author 长白崎
 *
 */
public class 阶乘约数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int data[] = new int[101];
		
		for(int i =1 ; i <=100 ; ++i) {
			slove(i,data);
		}
		
		long ans=1;
		for(int i=1 ; i <=100 ; ++i) {
			if(data[i]!=0)
				ans*=(data[i]+1);
		}
		System.out.println(ans);
		
	}
	
	
	//
	public static void slove(int num,int data[]) {
		
		//这一步主要是判断是否是质数
		for(int i= 2; i <=Math.sqrt(num) ; ++i) {
			//如果不是质数那么就进行拆解
			if(num%i==0) {
				//这里的作用主要是看如果不是质数那么拆解成多少个质数
				while(num%i==0) {
					num/=i;
					++data[i];
				}
				
			}
		}
		
		if(num>1) {
			++data[num];
		}
	}

}
