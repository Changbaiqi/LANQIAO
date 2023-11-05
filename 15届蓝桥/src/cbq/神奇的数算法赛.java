package cbq;

import java.util.Arrays;
import java.util.Scanner;

public class 神奇的数算法赛 {
	 public static void main(String[] args) {
	        //测试数据
//	        Scanner sc = new Scanner(System.in);
//	        int a = sc.nextInt();

		 System.out.println(slove(130));
	        System.out.println(slove(100));
	    }


	    public static long slove(int num){
	        int bit[] = new int[13];

	        int i =0;
	        while(num!=0){
	            bit[++i] = num%10;
	            num/=10;
	        }

	        long dp[][] = new long[i+1][10];
	        //初始化dp数组里面的值都为-1
	        for(int y = 0 ; y<=i ; ++y)
	            Arrays.fill(dp[i],-1);
	        
	        return dfs(dp,bit,i,0,0,true,true);
	    }


	    /**
	     * 这个函数是数位DP的核心算法
	     * @param dp DP的数组
	     * @param bit 这个数组主要用来存每一位的数字，数字存储的位置为从最高位开始，比如说我们存123这个数字，那么在数组里面应该是[][3][2][1]
	     * @param index 这个用于标记当前dfs的是对应数组的哪一个位置，dfs是从最高位先递归到最低位（个位）然后从低位逐渐递归到最高位
	     * @param preNum 这个变量主要的作用是用于记录前面dfs所选的数字
	     * @param limit 这个变量主要用于标记是否当前递归到的dfs是否有最高位限制，这个最高位限制与之前递归的dfs有关
	     * @param zero 这个变量主要是用于记录是否含有前导零，这个前导零的意思指的是除这一位以外所有比当前dfs的这一位高的位数都是零，比如：
	     *             123这个数字，我们利用数位dp的时候相当于记录1~123这个区域的数字有多少符合要求的，那么从最低位开始001、002、...、024
	     *             这里的0代表的就是前导零
	     * @return 返回当前位所能取到的合法数字的全部数量
	     */
	    public static long dfs(long dp[][],int bit[],int index,int preNum,int sum,boolean limit ,boolean zero){
	        //如果搜到了最后一位那么就直接退出就得
	        if(index==0)
	            return 1;

	        //如果不是前导零，并且没有最高位限制，而且有当前位数index为基准的前导数为preNum的搜索状态值那么就直接返回
	        if(!zero && !limit && dp[index][preNum]!=-1 )
	            return dp[index][preNum];

	        int maxNum = limit?bit[index]:9;
	        long ans = 0;
	        for(int i = 0 ; i <=maxNum ; ++i){
	            //这里开始添加过滤条件。。。。。
	        	
//	        	if(i>=3)
//	        	if(sum%i!=0)
//	        		continue;

	            //这里开始正常的搜索
	            if(zero && i==0)
	                ans +=dfs(dp,bit,index-1,i,sum+i,limit && i==bit[index] ? true:false,true);
	            else
	                ans+=dfs(dp,bit,index-1,i,sum+i,limit && i==bit[index] ? true:false,false);

	        }

	        if(!zero && !limit)
	            dp[index][preNum] = ans;

	        return ans;
	    }
}
