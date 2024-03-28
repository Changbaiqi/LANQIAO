package cbq;

/**
 * 无
 * @author 20840
 * @class["数论","前缀和"]
 */
public class 数列求值 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[20190324];
		int MOD = 10000;
		arr[0]=arr[1]=arr[2]=1;
		for( int i = 3;i<arr.length;++i) {
			arr[i]=(arr[i-1]+arr[i-2]+arr[i-3])%MOD;
		}
		System.out.println(arr[arr.length-1]);
	}

}
