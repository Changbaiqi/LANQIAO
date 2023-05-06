package lanqiao;

import java.math.BigInteger;
import java.util.Arrays;

public class ·�� {

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
     * Dijkstra�����㷨
     * @param map ��ͼ
     * @param start ��ʼ��
     * @param end �յ�
     */
    public static void dijkstra(int map[][],int start,int end){

        //���ڼĴ���С����
        int dis[] = new int[map.length];
        //���ڼĴ游���
        int parent[] = new int[map.length];
        //����Ƿ�ѡ����
        boolean select[] = new boolean[map.length];

        //��ʼ������ȫΪ���ֵ
        Arrays.fill(dis,Integer.MAX_VALUE);
        //��ʼ�������Ϊ����
        for(int i = 1 ; i <parent.length ; ++i)
            parent[i] = i;

        //��ʼ�����
        dis[start] = 0; //�Լ����Լ��ľ���Ϊ0
        select[start] = true; //���Ϊѡ����

        //����ǰ��ѡ�ĵ�
        int point  = start;
        while(true){
            int resPoint = -1; //��ʱ�洢��ѡ��
            int resDis = Integer.MAX_VALUE; //��ʱ�洢��ѡ�ߵĳ���

            for(int i= 1; i < map.length ; ++i){
                //������ѡ��
                if(select[i])
                    continue;

                //������ĿҪ�󣬱������Ϊ0�ĵ��ʾ����ͨ
                if(map[point][i]==0)
                    continue;
                //��������

                //�ж��Ƿ���ֵ�Ƿ�С�ڵ���ߵľ���
                if(dis[i]<map[i][point]+dis[point])
                    continue;

                //���¾���
                dis[i] = map[i][point]+dis[point];
                parent[i] = point;
            }

            //����С��
            for(int i = 1; i < select.length ; ++i){
                //������ѡ��
                if(select[i])
                    continue;
                //���˱ȵ���ǰ���ֵ
                if(resDis<dis[i])
                    continue;

                resPoint =i;
                resDis = dis[i];
            }
            //ѡ����С��
            if(resPoint!=-1){
                point = resPoint;
                select[point]=true;
            }

            //����Ѿ���Ѱ���յ���ô���˳�
            if(point==end)
                break;
        }
        //�����С����
        System.out.println(dis[end]);
        //�������·��
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
	
	
	//��һ�������ڻ���·��
    public static void pr(int parent[],int end){
        while(end!=parent[end]){
            System.out.print(end+"<-");
            end = parent[end];
        }
        System.out.print(end);
    }

}
