package lanqiao;

import java.util.ArrayList;

/**
 * C: �׳�Լ��
��Ŀ��
������������
����׳� n! = 1 �� 2 �� 3 �� �� �� �� �� n��
���� 100! ��100 �Ľ׳ˣ��ж��ٸ�Լ����
�����ύ��
����һ�������յ��⣬��ֻ��Ҫ���������ύ���ɡ�����Ľ��Ϊһ
�����������ύ��ʱֻ��д�����������д��������ݽ��޷��÷֡�

������
����Big Integer���100��
Ȼ�����Լ�������������
100��=��pi^ai
ans=��(ai+1)

AC���룺
39001250856960000
 * @author 20840
 *
 */
public class C�׳�Լ�� {
	
	
	static ArrayList<Integer> ss = new ArrayList<Integer>();
	static Long sum = 1l;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		poloSu(100);
		polo2();
		System.out.println(sum);
	}
	
	//������������
	public static void poloSu(int num) {
		for(int i =2 ; i <= num ; ++i) {
			boolean sw = true;
			for(int x = 2 ; x <= i/2 ; ++x) {
				if(i%x==0) {
					sw = false;
				}
			}
			if(sw)
				ss.add(i);
		}
	}
	
	public static void polo2() {
		for(int i = 0 ;i < ss.size() ; ++i) {
			int cc = 0,a=100;
			while(a!=0) {
				cc += (a/=ss.get(i));
			}
			sum*=(cc+1);
		}
		
	}
	
	

}
