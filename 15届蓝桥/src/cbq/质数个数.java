package cbq;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/4661/
 * @author ������
 * @class["�ֽ�������"]
 */
public class �������� {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		
		System.out.println(solve(n));
	}

	
	
	 /**
     * �ֽ������������㷨
     * @param n ��Ҫ�ֽ������
     * @return ���ؿ��Էֽ���ٸ�������
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
