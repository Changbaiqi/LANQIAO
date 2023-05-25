package lanqiao;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/1595/learning/?page=1&first_category_id=1&sort=students_count&name=%E5%92%8C%E4%B8%8E%E4%B9%98%E7%A7%AF
 * @author ������
 *
 */
public class ����˻� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//���ڴ����������
		long data[] = new long[n+1];
		long map[] = new long[n+1];
		//���ڴ����1�����Ķ�Ӧ�����±�
		int no1[] = new int[n+1];
		
		int bigIndex=0;
		for(int i =1 ; i <=n ; ++i) {
			data[i] = sc.nextInt();
			map[i] = map[i-1]+data[i];
			if(data[i]!=1)
				no1[++bigIndex] = i;
		}
		
		//���ڼ�¼��i������֮���ж��ٸ�1
		long dif[]=new long[n+1];
		for(int i =n,x = 0 ; i>=1 ;--i) {
			dif[i]=x;
			if(data[i]!=1) 
				x=0;
			else
				++x;
		}
		
		long ans =0;
		for(int l= 1 ; l <= n; ++l) {
			long now = data[l];
			//���������Java�Դ��Ķ��ֲ���
			int rr = Arrays.binarySearch(no1, 1,bigIndex+1,l);
			rr = rr>=0?rr+1:-rr-1;
			
			for(int x = rr ; x<=bigIndex ; ++x) {
				int r= no1[x];
				now*=data[r];
				
				if(now>map[n])
					break;
				
				long sum = map[r]-map[l-1];
				if(now>=sum && now<=sum+dif[r])
					++ans;
				
				
			}
		}
		
		System.out.println(n+ans);
	}

}
