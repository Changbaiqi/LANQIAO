package cbq;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/description/3748/
 * @author 长白崎
 * @class 双指针、枚举
 */
public class 牛的学术圈I3745 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 一共有几篇论文
		int L = sc.nextInt(); // 可以引用几篇论文

		Integer arr[] = new Integer[N+1];

		for (int i = 1; i <= N; ++i) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr,1,N+1,(a,b)->b-a);

		int max = 0;
		
		int l = 1,r=N;
		while(l<=N) {
			while(r>0 && arr[r]< l) --r;
			
			if(arr[l]>=l-1 && l-r<=L)
				max =l;
			++l;
		}

		System.out.println(max);
	}

}
