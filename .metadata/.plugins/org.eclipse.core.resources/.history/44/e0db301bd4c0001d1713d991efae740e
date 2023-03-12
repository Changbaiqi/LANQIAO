package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		  Scanner sc=new Scanner(System.in);
		  int n=sc.nextInt();
		  int arr[]=new int[n];
		  for (int i=0;i<n;i++) {
			  arr[i]=sc.nextInt();
		  }
		  Arrays.sort(arr);	  
		  int sum=0;
		  
		  //if(n>2)
		  int i = 0;
		  int last = -5;
		  while(i<n){
			  if(last!=arr[i]) {
				  if(sum!=0) {
					  System.out.println(last+" "+sum);
					  sum=1;
					  last=arr[i];
					  ++i;
					  continue;
				  }else {
					  last=arr[i];
					  sum=1;
					  ++i;
					  continue;
				  }
				  
			  }
			  
			  
			  
			  ++sum;
			  
			  if(i==n-1) {
				  System.out.println(last+" "+sum);
			  }
			  ++i;
		  }
//		  for(int i=0;i<n;i++) {
//			  sum++;
//			  
//			 if(arr[i]!=arr[i+1]) {
//				  System.out.println(arr[i]+" "+sum);
//				  sum=0;
//			  }
//			  //System.out.println(arr[i]);
//	  }
	 }

}
