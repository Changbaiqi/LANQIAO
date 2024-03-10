package cbq;

import java.util.Scanner;

public class 小A的回文串 {

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
        * 这里设置成len*2+1+2主要是开辟一个数组用于寄存我们需要判断的回文字符串
        * 比如：^#a#b#a#* 需要开原长度的*2+1+2也就是3*2+1+2=9
        * ^#a#b#c#b#a#* 需要开原长度的*2+1+2也就是5*2+1+2=13
        */
        char resText[] = new char[text.length*2+1+2];


        resText[0]='^';
        resText[1]='#';
        for(int i= 0; i <text.length ; ++i){
            resText[i*2+2] = text[i];
            resText[i*2+2+1] = '#';
        }
        resText[resText.length-1] = '*';

        //用于存储以i为中心的回文长度
        int ans[] = new int[resText.length];

        int i= 1;
        int maxLen = 0; //这个是用于记录最长回文长度
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
            //用于比较赋值最长回文
            maxLen = maxLen<len ? len : maxLen;
            ++i;
        }
//
//        System.out.println("最长回文长度为："+maxLen);
//        System.out.println("回文的数组："+pr(ans));
//        System.out.println(maxLen);
        return maxLen;
    }

}
