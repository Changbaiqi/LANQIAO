package cbq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/1240/
 * @author 长白崎
 * @class ["双指针"]
 */
public class 日志统计 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		int D = sc.nextInt();
		int K = sc.nextInt();
		
		ArrayList<int[]> arr = new ArrayList<int[]>();
		
		int data[] = new int[100002];
		
		for(int i=1;i<=N;++i) {
			int ts = sc.nextInt();
			int id = sc.nextInt();
			++data[id]; //统计数量
			arr.add(new int[] {ts,id});
		}
		
		Collections.sort(arr,(a,b)->{
			if(a[1]!=b[1]) {
				return a[1]-b[1];
			}else {
				return a[0]-b[0];
			}
		});
		
		
		boolean map[] = new boolean[100002];
		long ans =0;
		for(int i= K-1;i<arr.size();++i) {
			
			//id不等直接过
			if(arr.get(i)[1]!=arr.get(i-K+1)[1])
				continue;
			int dif =  arr.get(i)[0]-arr.get(i-K+1)[0]; //时间差值
			if(dif<D && !map[arr.get(i)[1]]) {
				++ans;
				map[arr.get(i)[1]]=true;
				System.out.println(arr.get(i)[1]);
			}
		}
//		
//		for(int i = 0;i<=100002;++i) {
//			if(map[i])
//				System.out.println(i);
//		}
	}

}
