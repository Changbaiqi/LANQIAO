package lanqiao;

public class ��˻� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[] = {99,22,51,63,72,61,20,88,40,21,63,30,11,18,99,12,93,16,7,53,64,9,28,84,34,96,52,82,51,77};
		
		int sum = 0 ;
		for(int i= 0; i < data.length ; ++i) {
			for(int x= i+1; x < data.length ; ++x) {
				if(data[i]*data[x]>=2022)
					++sum;
			}
		}
		System.out.println(sum);
	}

}
