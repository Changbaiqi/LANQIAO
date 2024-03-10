package cbq;


public class P1008NOIP1998普及组三连击 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean tags[] = new boolean[10];
		int data[] = new int[10];
		dfs(tags,data,1);
	}
	
	
	/**
	 * dfs算法
	 * @param tags
	 * @param data
	 * @param index
	 */
	static void dfs(boolean tags[],int data[],int index) {
		//判断是否越界
		if(index>=10) {
			int v1 = data[1]*100+data[2]*10+data[3];
			int v2 = data[4]*100+data[5]*10+data[6];
			int v3 = data[7]*100+data[8]*10+data[9];
			if(v1*2 == v2 && v1*3 ==v3)
				System.out.println(v1+" "+v2+" "+v3);
			return;
		}
		for(int i =1;i<=9;++i) {
			//如果使用过了
			if(tags[i])
				continue;
			tags[i] = true;
			data[index] = i;
			dfs(tags,data,index+1);
			tags[i] = false;
		}
	}

}
