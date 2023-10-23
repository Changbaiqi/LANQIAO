package cbq;
import java.util.Scanner;

public class Manacher {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		manacher(s);
	}

	/**
	 * 马拉车算法模板
	 * 
	 * @param s
	 * @return
	 */
	public static int manacher(String s) {
		
		// 第一部构建Manacher字符串
		char[] str = new char[s.length() * 2 + 3];

		int x = 0;
		str[x++] = '^';
		str[x++] = '#';
		for (int i = 0; i < s.length(); ++i) {
			str[x++] = s.charAt(i);
			str[x++] = '#';
		}

		str[x++] = '*';

		int p[] = new int[str.length]; // 开的这个数组用于寄存当前构建的Manacher字符串中以当前i下标中的字符为回文中间字符的最长回文串。
		int R = 0, M = 0; // 代表最长回文子串的右下标以及中间对称标。
		
		// 字符串遍历
		for (int i = 1; i < str.length - 1; ++i) {
			// 如果当前指向的i字符位置位于最长子串的R位置的左边，那么就直接赋值当前字符为回文中心的最长回文长度为1；
			if (i > R)
				p[i] = 1;
			else
				p[i] = Math.min(p[2 * M - i], R - i + 1);
			//判断回文字符串，并进行++操作
			while (i - p[i] >= 1 && i + p[i] <= str.length - 1 && str[i - p[i]] == str[i + p[i]])
				p[i]++;
			//判断当前的i是否为最长的回文串，如果是的话那就设置当前i为最长回文的回文中心寄存值。
			if (i + p[i] + 1 > R) {
				M = i;
				R = i + p[i] -1;
			}
		}
		
		
		return 0;
	}

}
