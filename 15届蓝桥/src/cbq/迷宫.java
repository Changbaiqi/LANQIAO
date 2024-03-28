package cbq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * https://www.lanqiao.cn/problems/602/learning/?subject_code=2&group_code=4&match_num=13&match_flow=2&origin=cup
 * @author 长白崎
 * @class["第十三届蓝桥javaB组国赛","字典序","BFS"]
 */
public class 迷宫 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//U,R,L,D
		char map[][] ={
				"01010101001011001001010110010110100100001000101010".toCharArray(), 
				"00001000100000101010010000100000001001100110100101".toCharArray(), 
				"01111011010010001000001101001011100011000000010000".toCharArray(), 
				"01000000001010100011010000101000001010101011001011".toCharArray(), 
				"00011111000000101000010010100010100000101100000000".toCharArray(), 
				"11001000110101000010101100011010011010101011110111".toCharArray(), 
				"00011011010101001001001010000001000101001110000000".toCharArray(), 
				"10100000101000100110101010111110011000010000111010".toCharArray(), 
				"00111000001010100001100010000001000101001100001001".toCharArray(), 
				"11000110100001110010001001010101010101010001101000".toCharArray(), 
				"00010000100100000101001010101110100010101010000101".toCharArray(), 
				"11100100101001001000010000010101010100100100010100".toCharArray(), 
				"00000010000000101011001111010001100000101010100011".toCharArray(), 
				"10101010011100001000011000010110011110110100001000".toCharArray(), 
				"10101010100001101010100101000010100000111011101001".toCharArray(), 
				"10000000101100010000101100101101001011100000000100".toCharArray(), 
				"10101001000000010100100001000100000100011110101001".toCharArray(), 
				"00101001010101101001010100011010101101110000110101".toCharArray(), 
				"11001010000100001100000010100101000001000111000010".toCharArray(), 
				"00001000110000110101101000000100101001001000011101".toCharArray(), 
				"10100101000101000000001110110010110101101010100001".toCharArray(), 
				"00101000010000110101010000100010001001000100010101".toCharArray(), 
				"10100001000110010001000010101001010101011111010010".toCharArray(), 
				"00000100101000000110010100101001000001000000000010".toCharArray(), 
				"11010000001001110111001001000011101001011011101000".toCharArray(), 
				"00000110100010001000100000001000011101000000110011".toCharArray(), 
				"10101000101000100010001111100010101001010000001000".toCharArray(), 
				"10000010100101001010110000000100101010001011101000".toCharArray(), 
				"00111100001000010000000110111000000001000000001011".toCharArray(), 
				"10000001100111010111010001000110111010101101111000".toCharArray()};
		bfs(map);
	}
	static void bfs(char map[][]) {
		Queue<String[]> qu = new LinkedList<String[]>();
		
		boolean vi[][] = new boolean[map.length][map[0].length];
		qu.offer(new String[] {"0","0","0",""}); vi[0][0] = true;
		
		while(!qu.isEmpty()) {
			String point[] = qu.poll();
			int y= Integer.parseInt(point[0]);
			int x= Integer.parseInt(point[1]);
			int step = Integer.parseInt(point[2]);
			if(y==map.length-1 && x==map[0].length-1) {
//				System.out.println(step);
				System.out.println(point[3]);
				return;
			}
			
			int next[][]= {
					{y+1,x},
					{y,x-1},
					{y,x+1},
					{y-1,x}
					
			};
			String c[]= {"D","L","R","U"};
			
			for(int i=0;i<4;++i) {
				if(next[i][0]<0 || next[i][1]<0 || next[i][0]>=map.length || next[i][1]>=map[0].length) continue;
				if(map[next[i][0]][next[i][1]]=='1')continue;
				if(vi[next[i][0]][next[i][1]]) continue;
				vi[next[i][0]][next[i][1]] = true;
				qu.offer(new String[] {next[i][0]+"",next[i][1]+"",(step+1)+"",point[3]+c[i]});
			}
		}
		
	}
	
	
	
	
	static class Reader{
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer st = new StringTokenizer("");
		
		static String next() {
			while(st.hasMoreTokens()){
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return st.nextToken();
		}
		
		static int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
