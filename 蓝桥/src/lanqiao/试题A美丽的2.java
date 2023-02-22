package lanqiao;

/**
 * 【问题描述】

小蓝特别喜欢 2，今年是公元 2020 年，他特别高兴。

他很好奇，在公元 1 年到公元 2020 年（包含）中，有多少个年份的数位中包含数字 2？

【答案提交】

这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。

 * @author 20840
 *
 */

public class 试题A美丽的2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum =0;
		for(int i = 1 ; i <= 2020 ; ++i) {
			
			if( (i+"").contains("2"))
				++sum;
		}
		
		System.out.println(sum);
		
	}

}
