package lanqiao;


import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class 巧克力 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt(); //吃巧克力天数
		int n = sc.nextInt(); //种类
		
		C data[] = new C[n+1];
		
		for(int i = 1 ; i <=n ; ++i) {
			long a = sc.nextInt(); //单价
			long b = sc.nextInt(); //保质期
			long c = sc.nextInt(); //数量
			data[i] = new C(a,b,c);
		}
		
		//对单价进行从小到大的排序
		Arrays.sort(data,1,n,(a,b)->{
			return (int)(a.getA()-b.getA());
		});
		
		
		long ans =0;
		long latemin=0;
		for(int i=1; i <=n ; ++i) {
			long min = Math.min(data[i].getB()-latemin<=0?0:data[i].getB()-latemin,data[i].getC());
			long res = min+latemin;
			
			
			
			if(res>=x) {
				
				ans+=(x-latemin)*data[i].getA();
				latemin +=x-latemin;
				//System.out.println(ans);
				break;
				//return;
			}
			
			latemin = res;
			ans+=min*data[i].getA();
		}
		if(latemin==x)
			System.out.println(ans);
		else
			System.out.println(-1);
		
	}
	
	
	static class C{
		private long a;
		private long b;
		private long c;
		public C(long a, long b, long c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}
		public long getA() {
			return a;
		}
		public void setA(long a) {
			this.a = a;
		}
		public long getB() {
			return b;
		}
		public void setB(long b) {
			this.b = b;
		}
		public long getC() {
			return c;
		}
		public void setC(long c) {
			this.c = c;
		}
		
		
		
	}

}
