package lanqiao;

/**
 * ������������

С���ر�ϲ�� 2�������ǹ�Ԫ 2020 �꣬���ر���ˡ�

���ܺ��棬�ڹ�Ԫ 1 �굽��Ԫ 2020 �꣨�������У��ж��ٸ���ݵ���λ�а������� 2��

�����ύ��

����һ�������յ��⣬��ֻ��Ҫ���������ύ���ɡ�����Ľ��Ϊһ�����������ύ��ʱֻ��д�����������д��������ݽ��޷��÷֡�

 * @author 20840
 *
 */

public class ����A������2 {

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
