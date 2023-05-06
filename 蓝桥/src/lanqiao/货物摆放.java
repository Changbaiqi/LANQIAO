package lanqiao;

import java.util.ArrayList;

public class »õÎï°Ú·Å {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long sum = 2021041820210418l;
		
		ArrayList<Long> data = new ArrayList<Long>();
		for(long i =1 ; i <= Math.sqrt(sum) ; ++i) {
			if(sum%i==0) {
				data.add(sum/i);
				if(i!=sum/i)
					data.add(i);
			}		
		}
		
		long ans =0 ;
		for (Long long1 : data) {
			for (Long long2 : data) {
				for (Long long3 : data) {
					if(long1*long2*long3==sum)
						++ans;
				}
			}
		}
		System.out.println(ans);
		
		
	}

}
