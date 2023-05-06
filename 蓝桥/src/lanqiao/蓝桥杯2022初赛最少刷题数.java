package lanqiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class 蓝桥杯2022初赛最少刷题数 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		
		int N  = Integer.parseInt(br.readLine());
		String[] s= br.readLine().split(" ");
		
		int data[] = new int[N];
		int cnt[] = new int[100000+1];
		for(int i= 0; i < N ; ++i) {
			data[i]=Integer.parseInt(s[i]);
			++cnt[data[i]]; //计算第几位数字
		}
		
		
		
		
		for(int i= 1; i < cnt.length ; ++i) {
			cnt[i]+=cnt[i-1];
		}
		
		for(int i= 0; i< N ; ++i) {
			int a1 =cnt[100000]-cnt[data[i]];
			int a2 = cnt[Math.max(data[i]-1, 0)];
			if( a1<= a2) {
				System.out.print(0+" ");
				continue;
			}
			
			int l = data[i]+1,r=100000,mid;
			while(l<=r) {
				mid = (l+r)/2;
				if(cnt[100000]-cnt[mid]>cnt[mid-1]-1)
					l=mid+1;
				else
					r=mid-1;
			}
			System.out.print(l-data[i]+" ");
		}
		
		
		
		
	}

}

