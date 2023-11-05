package cbq;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 * https://www.lanqiao.cn/problems/5889/learning/?contest_id=145
 * @class 优先队列
 * @author 长白崎
 *
 */
public class 通关算法赛 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();//关卡数量
		int P = sc.nextInt();//初始经验值

		List<Node> data[] = new ArrayList[n+1];
		for(int i= 0;i<=n;++i) {data[i] = new ArrayList<Node>();}
		
		for(int i=1 ; i<= n;++i) {
			int f = sc.nextInt();
			int s = sc.nextInt();
			int k = sc.nextInt();
			data[f].add(new Node(f,i,s,k)); 
		}
		
		
		PriorityQueue<Node> pri = new PriorityQueue<Node>();
		long ans =P;
		long sum=0;
		for(int i =0;i < data[0].size();++i) {pri.offer(data[0].get(i));}
		
		while(!pri.isEmpty()) {
			Node node = pri.poll();
			if(node.k>ans)
				break;
			for(int i=0; i< data[node.id].size();++i){pri.offer(data[node.id].get(i));}
			++sum;
			ans+=node.s;
		}
		System.out.println(sum);
		
	}
	
	static class Node implements Comparable<Node>{
		int f;//前置关卡
		int id;
		int s;//表示经验值
		int k;//挑战成功需要的经验值
		public Node(int f, int id, int s, int k) {
			super();
			this.f = f;
			this.id = id;
			this.s = s;
			this.k = k;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return k-o.k;
		}
		
		
	}
	
}
