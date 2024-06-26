package lanqiao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 1.数组切分
1.问题描述
已知一个长度为 N NN 的数组: A 1 , A 2 , A 3 , … A N A_{1}, A_{2}, A_{3}, \ldots A_{N}A 
1
​
 ,A 
2
​
 ,A 
3
​
 ,…A 
N
​
  恰好是 1 ∼ N 1 \sim N1∼N 的一个排列。现在要求你将 A AA 数组切分成若干个 (最少一个, 最多 N NN 个) 连续的子数组, 并且 每个子数组中包含的整数恰好可以组成一段连续的自然数。

例如对于 A = 1 , 3 , 2 , 4 A={1,3,2,4}A=1,3,2,4, 一共有 5 种切分方法:

1324 {1}{3} {2}{4}1324 : 每个单独的数显然是 (长度为 1 的) 一段连续的自然数。

{ 1 } { 3 , 2 } { 4 } : { 3 , 2 } \{1\}\{3,2\} \{4\}:\{3,2\}{1}{3,2}{4}:{3,2} 包含 2 22 到 3 33 , 是 一段连续的自然数, 另外 1 {1}1 和 4 {4}4 显然 也是。

{ 1 } { 3 , 2 , 4 } : { 3 , 2 , 4 } \{1\}\{3,2,4\}:\{3,2,4\}{1}{3,2,4}:{3,2,4} 包含 2 22 到 4 44 , 是一段连续的自然数, 另外 1 {1}1 显然也是。

{ 1 , 3 , 2 } { 4 } : { 1 , 3 , 2 } \{1,3,2\} \{4\}:\{1,3,2\}{1,3,2}{4}:{1,3,2} 包含 1 11 到 3 33 , 是 一段连续的自然数, 另外 4 {4}4 显然也是。

{ 1 , 3 , 2 , 4 } \{1,3,2,4\}{1,3,2,4} : 只有一个子数组, 包含 1 11 到 4 44 , 是 一段连续的自然数。

2.输入格式
第一行包含一个整数 N NN 。第二行包含 N NN 个整数, 代表 A AA 数组。

3.输出格式
输出一个整数表示答案。由于答案可能很大, 所以输出其对 1000000007 取模后的值

4.样例输入
4
1 3 2 4

5.样例输出
5

6.数据范围
对于 30 % 30 \%30% 评测用例, 1 ≤ N ≤ 20 1 \leq N \leq 201≤N≤20.

对于 100 % 100 \%100% 评测用例, 1 ≤ N ≤ 10000 1 \leq N \leq 100001≤N≤10000.
 * @author 20840
 *
 */
public class 数组切分 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc =  new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int data[] = new int[N+1];
		
		int dp[] = new int[N+1];
		dp[0] = 1;
		for(int i =1 ; i < data.length ; ++i) {
			data[i] = sc.nextInt();
			check(data,dp,i);
		}

		System.out.println(dp[N]%(((int)1e9)+7));
	}
	
	public static void check(int data[],int dp[],int index) {
		
		
		int min=data[index],max = data[index];
		for(int i =index ; i > 0 ; --i){
			min = Math.min(min, data[i]);
			max = Math.max(max, data[i]);
			if((index-i)==max-min) {
				dp[index]+=dp[i-1];
				dp[index]%=(((int)1e9)+7);
			}
		}
	}
	
	
	
	
}


