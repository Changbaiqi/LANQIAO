package cbq;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/5888/learning/?contest_id=145
 * @class 区间、极值、序列
 * @author 长白崎
 *
 */
public class 摆玩具算法赛 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	int k = sc.nextInt();
    	
    	int data[] = new int[n];
    	int dif[] = new int[n-1];
    	
    	for(int i=0;i < n ; ++i) {
    		data[i] = sc.nextInt();
    	}
    	for(int i=1; i < n ; ++i) {
    		dif[i-1] = data[i]-data[i-1];
    	}
    	
    	Arrays.sort(dif);
    	
    	int res = data[n-1]-data[0];
    	
    	for(int i=0; i < k-1; ++i) {
    		res  = res - dif[dif.length-1-i];
    	}
    	
    	System.out.println(res);
    	
    	
    }

}