package lanqiao;

import java.util.HashSet;

/**
 * 【问题描述】

小蓝在一张无限大的特殊画布上作画。

这张画布可以看成一个方格图，每个格子可以用一个二维的整数坐标表示。

小蓝在画布上首先点了一下几个点：(0, 0), (2020, 11), (11, 14), (2000, 2000)。只有这几个格子上有黑色，其它位置都是白色的。

每过一分钟，黑色就会扩散一点。具体的，如果一个格子里面是黑色，它就会扩散到上、下、左、右四个相邻的格子中，使得这四个格子也变成黑色（如果原来就是黑色，则还是黑色）。

请问，经过 2020 分钟后，画布上有多少个格子是黑色的。

【答案提交】

这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。

 * @author 20840
 *
 */
public class 试题B扩散 {
	static long sum = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> data1 = new HashSet<>();
		HashSet<String> data2 = new HashSet<>();
		
		data1.add("0,0");
		data1.add("2020,11");
		data1.add("11,14");
		data1.add("2000,2000");
		
		for(int i = 1; i <= 2020 ; ++i) {
			data1.forEach(e->{
				String s[] = e.split(",");
				Long x = Long.valueOf(s[0]);
				Long y = Long.valueOf(s[1]);
				String up = String.valueOf(x+1)+","+String.valueOf(y);
				String down = String.valueOf(x-1)+","+String.valueOf(y);
				String left = String.valueOf(x)+","+String.valueOf(y-1);
				String right = String.valueOf(x)+","+String.valueOf(y+1);
				if(!data1.contains(up)) {
					data2.add(up);
					++sum;
				}
				if(!data1.contains(down)) {
					data2.add(down);
					++sum;
				}
				if(!data1.contains(left)) {
					data2.add(left);
					++sum;
				}
				if(!data1.contains(right)) {
					data2.add(right);
					++sum;
				}
				
			});
			data1.addAll(data2);
			data2.clear();
		}
		System.out.println(sum);
		
	}

}
