package cbq;

import java.util.Scanner;

public class СA�Ļ��Ĵ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		long max =0;
		for(int i=0;i<str.length()-1;++i) {
			String a1 = str.substring(0, i);
			String a2 = str.substring(i,str.length());
			String res = a2+a1;
			long len = manacher(res.toCharArray());
			max= max<len?len:max;
		}
		System.out.println(max);
		
	}
	
	public static long manacher(char text[]){
        /*
        * �������ó�len*2+1+2��Ҫ�ǿ���һ���������ڼĴ�������Ҫ�жϵĻ����ַ���
        * ���磺^#a#b#a#* ��Ҫ��ԭ���ȵ�*2+1+2Ҳ����3*2+1+2=9
        * ^#a#b#c#b#a#* ��Ҫ��ԭ���ȵ�*2+1+2Ҳ����5*2+1+2=13
        */
        char resText[] = new char[text.length*2+1+2];


        resText[0]='^';
        resText[1]='#';
        for(int i= 0; i <text.length ; ++i){
            resText[i*2+2] = text[i];
            resText[i*2+2+1] = '#';
        }
        resText[resText.length-1] = '*';

        //���ڴ洢��iΪ���ĵĻ��ĳ���
        int ans[] = new int[resText.length];

        int i= 1;
        int maxLen = 0; //��������ڼ�¼����ĳ���
        while(i<resText.length-2){
            int l = i-1;
            int r= i+1;
            int len =0;
            while(resText[l]==resText[r]){
                ++len;
                --l;
                ++r;
            }

            ans[i] = len;
            //���ڱȽϸ�ֵ�����
            maxLen = maxLen<len ? len : maxLen;
            ++i;
        }
//
//        System.out.println("����ĳ���Ϊ��"+maxLen);
//        System.out.println("���ĵ����飺"+pr(ans));
//        System.out.println(maxLen);
        return maxLen;
    }

}
