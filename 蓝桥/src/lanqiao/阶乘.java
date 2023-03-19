package lanqiao;

import java.util.ArrayList;
import java.util.Scanner;

public class �׳� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i =0 ; i < T; ++i) {
			int p = sc.nextInt();
			solve(p);
			
		}
		
		
		
	}
	
	public static void solve(int p) {
		ArrayList<Integer> index = new ArrayList<Integer>();
		ArrayList<Integer> data = new ArrayList<Integer>();
		for(int i =2 ; i*i<p; ++i) {
			if(p%i==0) {
				index.add(i);
				data.add(0);
				while(p%i==0) {
					data.set(data.size()-1, data.get(data.size()-1)+1);
					p/=i;
				}
			}
		}
		
		if(p>1) { 
			index.add(p);
			data.add(1);
		}
		
		
		int l  =1,r=(int)1e9,mid,ans=0;
		while(l<=r){
			mid = (l+r)/2;
			if(check(index,data,p,mid)) {
				r=mid-1;ans=mid;
			}
			else
				l = mid+1;
		}
		System.out.println(ans);
		
		
		
	}
	
	public static boolean check(ArrayList<Integer> index,ArrayList<Integer> data,int p,int mid) {
		
		for(int i = 0; i< index.size() ; ++i) {
			int c=0;
			while(mid>0) {
				c +=mid/index.get(i);
				mid/=index.get(i);
			}
			if(c<data.get(i))
				return false;
		}
		return true;
	}
	
	

}
