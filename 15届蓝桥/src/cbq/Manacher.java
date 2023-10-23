package cbq;
import java.util.Scanner;

public class Manacher {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		manacher(s);
	}

	/**
	 * �������㷨ģ��
	 * 
	 * @param s
	 * @return
	 */
	public static int manacher(String s) {
		
		// ��һ������Manacher�ַ���
		char[] str = new char[s.length() * 2 + 3];

		int x = 0;
		str[x++] = '^';
		str[x++] = '#';
		for (int i = 0; i < s.length(); ++i) {
			str[x++] = s.charAt(i);
			str[x++] = '#';
		}

		str[x++] = '*';

		int p[] = new int[str.length]; // ��������������ڼĴ浱ǰ������Manacher�ַ������Ե�ǰi�±��е��ַ�Ϊ�����м��ַ�������Ĵ���
		int R = 0, M = 0; // ����������Ӵ������±��Լ��м�ԳƱꡣ
		
		// �ַ�������
		for (int i = 1; i < str.length - 1; ++i) {
			// �����ǰָ���i�ַ�λ��λ����Ӵ���Rλ�õ���ߣ���ô��ֱ�Ӹ�ֵ��ǰ�ַ�Ϊ�������ĵ�����ĳ���Ϊ1��
			if (i > R)
				p[i] = 1;
			else
				p[i] = Math.min(p[2 * M - i], R - i + 1);
			//�жϻ����ַ�����������++����
			while (i - p[i] >= 1 && i + p[i] <= str.length - 1 && str[i - p[i]] == str[i + p[i]])
				p[i]++;
			//�жϵ�ǰ��i�Ƿ�Ϊ��Ļ��Ĵ�������ǵĻ��Ǿ����õ�ǰiΪ����ĵĻ������ļĴ�ֵ��
			if (i + p[i] + 1 > R) {
				M = i;
				R = i + p[i] -1;
			}
		}
		
		
		return 0;
	}

}
