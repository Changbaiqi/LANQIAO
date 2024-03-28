package cbq;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/4661/
 * @author 长白崎
 * @class["分解质因数"]
 */
public class 质数个数 {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		
		System.out.println(solve(n));
	}

	
	
	 /**
     * 分解质因数核心算法
     * @param n 需要分解的数字
     * @return 返回可以分解多少个质因数
     */
    public static long solve(long n){
        long ans =0;
        for(int i =2 ; i <= Math.sqrt(n) ; ++i){
        	if(n%i==0) {
        		while(n%i==0) n/=i; 
        	}
        }
        if(n>1)++ans; 
        return ans;
    }
	
	

}
