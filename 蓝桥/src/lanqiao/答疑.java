package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class ���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc  = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Student data[] = new Student[n];
		for(int i=0 ; i < n ; ++i) {
			data[i] = new Student(sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(data,(x,y)->{
			if(x.sum==y.sum) {
				return x.form-y.form;
			}
			return	x.sum-y.sum;
		});
		
		long ans=0;
		long res =0;
		for(int i = 0 ; i <n ; ++i) {
			if(i==0) {
				res+=data[i].form;
				ans+=res;
			}
			if(i>0) {
				res+=data[i-1].e+data[i].form;
				ans+=res;
			}
		}
		System.out.println(ans);
		
	}
	
	public static class Student{
		int s = 0;
		int a = 0;
		int e = 0;
		int form=0;
		int sum = 0;
		Student(int s,int a,int e){
			this.s = s;
			this.a = a;
			this.e = e;
			form+=s+a;
			sum+=s+a+e;
		}
	}
}

