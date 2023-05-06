package lanqiao;

import java.math.BigInteger;
import java.util.Arrays;

public class 路径 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int map[][] = new int[2022][2022];
		
//		for(int y = 1 ; y <map.length ; ++y) {
//			for(int x = y+1 ; x < map[y].length ; ++x) {
//				if(y==x)
//					continue;
//				if(Math.abs(y-x)>21)
//					break;
//				int len = lcd(y,x);
//				map[y][x] = len;
//				map[x][y] = len;
//			}
//		}
		
		for(int y = 1; y < map.length ; ++y) {
			for(int x = y+1 ; x<= (y+21>2021?2021:y+21); ++x) {
				if(y==x)
					continue;
				if(Math.abs(y-x)>21)
					break;
				int len = lcd(y,x);
				map[y][x] = len;
				map[x][y] = len;
			}
		}
		
		dijkstra(map, 1, 2021);
		//dijs(1,2021);
		
		//System.out.println(lcd(15,75));
		
	}
	

	
    /**
     * Dijkstra核心算法
     * @param map 地图
     * @param start 起始点
     * @param end 终点
     */
    public static void dijkstra(int map[][],int start,int end){

        //用于寄存最小距离
        int dis[] = new int[map.length];
        //用于寄存父结点
        int parent[] = new int[map.length];
        //标记是否选择了
        boolean select[] = new boolean[map.length];

        //初始化距离全为最大值
        Arrays.fill(dis,Integer.MAX_VALUE);
        //初始化父结点为自身
        for(int i = 1 ; i <parent.length ; ++i)
            parent[i] = i;

        //初始化起点
        dis[start] = 0; //自己到自己的距离为0
        select[start] = true; //标记为选择了

        //代表当前所选的点
        int point  = start;
        while(true){
            int resPoint = -1; //临时存储所选点
            int resDis = Integer.MAX_VALUE; //临时存储所选边的长度

            for(int i= 1; i < map.length ; ++i){
                //过滤已选点
                if(select[i])
                    continue;

                //过滤题目要求，比如距离为0的点表示不连通
                if(map[point][i]==0)
                    continue;
                //。。。。

                //判断是否总值是否小于当面边的距离
                if(dis[i]<map[i][point]+dis[point])
                    continue;

                //更新距离
                dis[i] = map[i][point]+dis[point];
                parent[i] = point;
            }

            //找最小边
            for(int i = 1; i < select.length ; ++i){
                //过滤已选边
                if(select[i])
                    continue;
                //过滤比单当前大的值
                if(resDis<dis[i])
                    continue;

                resPoint =i;
                resDis = dis[i];
            }
            //选择最小边
            if(resPoint!=-1){
                point = resPoint;
                select[point]=true;
            }

            //如果已经搜寻到终点那么就退出
            if(point==end)
                break;
        }
        //输出最小距离
        System.out.println(dis[end]);
        //输出回溯路径
        pr(parent,end);
    }
	
	public static int lcd(int a, int b ) {
//		int max = a<b? b: a;
//		
//		while(true) {
//			if(max%a==0 && max%b==0)
//				break;
//			++max;
//		}
		return a*b/gcd(a,b);
	}
	
	public static int gcd(int a,int b) {
		return b==0?a:gcd(b,a%b);
	}
	
	
	//这一部分用于回溯路径
    public static void pr(int parent[],int end){
        while(end!=parent[end]){
            System.out.print(end+"<-");
            end = parent[end];
        }
        System.out.print(end);
    }

}
