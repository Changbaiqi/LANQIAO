package cbq;

public class µü´úÈ«ÅÅÁĞ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[] = new int[3];
		data[0]=1;
		data[1]=2;
		data[2]=3;
		
		boolean state[] = new boolean[3];
		
		for(int i =0;i < 3; ++i) {
			state[i]= true;
			for(int j = 0; j < 3; ++j) {
				if(state[j])
					continue;
				state[j]=true;
				for(int z = 0  ; z < 3; ++z) {
					if(state[z])
						continue;
					state[z]=true;
					System.out.printf("%d %d %d\n",data[i],data[j],data[z]);
					state[z]=false;
				}
				state[j]=false;
			}
			state[i]=false;
		}
		
	}

}
