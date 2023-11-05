package cbq;

import java.util.Arrays;
import java.util.Scanner;

public class ��������㷨�� {
	 public static void main(String[] args) {
	        //��������
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
	        //��ʼ��dp���������ֵ��Ϊ-1
	        for(int y = 0 ; y<=i ; ++y)
	            Arrays.fill(dp[i],-1);
	        
	        return dfs(dp,bit,i,0,0,true,true);
	    }


	    /**
	     * �����������λDP�ĺ����㷨
	     * @param dp DP������
	     * @param bit ���������Ҫ������ÿһλ�����֣����ִ洢��λ��Ϊ�����λ��ʼ������˵���Ǵ�123������֣���ô����������Ӧ����[][3][2][1]
	     * @param index ������ڱ�ǵ�ǰdfs���Ƕ�Ӧ�������һ��λ�ã�dfs�Ǵ����λ�ȵݹ鵽���λ����λ��Ȼ��ӵ�λ�𽥵ݹ鵽���λ
	     * @param preNum ���������Ҫ�����������ڼ�¼ǰ��dfs��ѡ������
	     * @param limit ���������Ҫ���ڱ���Ƿ�ǰ�ݹ鵽��dfs�Ƿ������λ���ƣ�������λ������֮ǰ�ݹ��dfs�й�
	     * @param zero ���������Ҫ�����ڼ�¼�Ƿ���ǰ���㣬���ǰ�������˼ָ���ǳ���һλ�������бȵ�ǰdfs����һλ�ߵ�λ�������㣬���磺
	     *             123������֣�����������λdp��ʱ���൱�ڼ�¼1~123�������������ж��ٷ���Ҫ��ģ���ô�����λ��ʼ001��002��...��024
	     *             �����0����ľ���ǰ����
	     * @return ���ص�ǰλ����ȡ���ĺϷ����ֵ�ȫ������
	     */
	    public static long dfs(long dp[][],int bit[],int index,int preNum,int sum,boolean limit ,boolean zero){
	        //����ѵ������һλ��ô��ֱ���˳��͵�
	        if(index==0)
	            return 1;

	        //�������ǰ���㣬����û�����λ���ƣ������е�ǰλ��indexΪ��׼��ǰ����ΪpreNum������״ֵ̬��ô��ֱ�ӷ���
	        if(!zero && !limit && dp[index][preNum]!=-1 )
	            return dp[index][preNum];

	        int maxNum = limit?bit[index]:9;
	        long ans = 0;
	        for(int i = 0 ; i <=maxNum ; ++i){
	            //���￪ʼ��ӹ�����������������
	        	
//	        	if(i>=3)
//	        	if(sum%i!=0)
//	        		continue;

	            //���￪ʼ����������
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
