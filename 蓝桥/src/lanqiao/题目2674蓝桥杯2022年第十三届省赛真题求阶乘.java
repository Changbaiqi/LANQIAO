package lanqiao;

import java.util.Scanner;

/**
 * 满足 N! 的末尾恰好有 K 个 0 的最小的 N 是多少? 

如果这样的 N 不存在输出 −1。
 * @author 20840
 *
 */
public class 题目2674蓝桥杯2022年第十三届省赛真题求阶乘 {
	
	
	
	public static void polo_1(long num) {
		
		long l = 1 ;
		long r = Long.MAX_VALUE-5;
		while(l<r) {
			long mid = (l+r)/2;
			if(num <=polo_2(mid)) {
				r = mid;
			}else
			{
				l = mid+1;
			}
		}
		if(polo_2(r)!=num) {
			System.out.println(-1);
		}else {
			System.out.println(r);
		}
		
	}
	
	public static long polo_2(long num) {
		
		long res = 0;
		while(num!=0) {
			res = res+ num/5;
			num/=5;
		}
		
		return res;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//判断有多少个5
		//使用二分搜索快速搜寻数字
		//查询多少个零
		Scanner sc = new Scanner(System.in);
		
		long num = sc.nextLong();
		
		polo_1(num);
		
		
	}

}
