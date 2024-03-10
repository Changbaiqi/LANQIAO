package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acwing.com/problem/content/description/5405/
 * 本代码解法错误，应该用二分
 * @author 长白崎
 *
 */
public class 买二赠一 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int N = Reader.nextInt();

		PriorityQueue<Long> qu = new PriorityQueue<Long>((a, b) -> b.compareTo(a)); // 用于寄存
		PriorityQueue<Long> resq = new PriorityQueue<Long>((a, b) -> b.compareTo(a)); // 用于寄存可以消掉的值

		long min = Long.MIN_VALUE;
		for (int i = 1; i <= N; ++i) {
			long num = Reader.nextLong();
			qu.offer(num);
			min = Math.min(min, num);
		}

		long sum = 0;
		while(qu.size()>=2) {
			long a = qu.poll();
			long b = qu.poll();
			
			boolean isP = false;
			while(!resq.isEmpty()) {
				long res = resq.poll();
				if(a<=res) {
					isP = true;
					qu.offer(b);
					break;
				}else if(b<=res){
					isP = true;
					qu.offer(a);
					break;
				}else {
					resq.offer(res);	
					break;
				}
				
			}
			if(isP)
				continue;
			sum+=a+b;
			resq.offer(Math.min(a, b)/2);
		}
		if(!qu.isEmpty()) {
			long a = qu.poll();
			boolean isP = false;
			while(!resq.isEmpty()) {
				long res = resq.poll();
				if(a<=res) {
					isP = true;
					break;
				}else {
					resq.offer(res);	
					break;
				}
				
			}
			if(!isP) {
				sum+=a;	
			}
		}
		System.out.println(sum);
	}
	static class Reader{
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer tokenizer = new StringTokenizer("");
		
		static String next() throws IOException {
			while(!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(br.readLine());
			}
			return tokenizer.nextToken();
		}
		
		static int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
		static long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}
	

}
