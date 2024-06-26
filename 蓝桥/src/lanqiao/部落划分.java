package lanqiao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ���仮�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
//		Scanner sc = new Scanner(System.in);
//		
//		int n = sc.nextInt();
//		int k = sc.nextInt();
//		
//		int person_x[] = new int[n];
//		int person_y[] = new int[n];
//		 
//		for(int i = 0 ; i < n ; ++i) {
//			person_x[i] = sc.nextInt();
//			person_y[i] = sc.nextInt();
//		}
//		
		
		ArrayList<E> data = new ArrayList<>();
		data.add(new E(1,2,5));
		data.add(new E(2,3,5));
		data.add(new E(2,6,5));
		data.add(new E(3,6,5));
		//data.add(new E(2,3,5));
		Boolean state = new Boolean(false);
		find(data,data.get(0),data.get(0),state);
		System.out.println(state);
		//karuskal(n,k,person_x,person_y);
		
	}
	
	public static void karuskal(int n,int k,int person_x[],int person_y[]) {
		ArrayList<E> data = new ArrayList<>();
		
		for(int y = 0; y < person_y.length ;++y) {
			for(int x = y+1 ; x< person_x.length ; ++x) {
				double dis = Math.sqrt(Math.pow(person_x[y]-person_x[x],2)+Math.pow(person_y[y]-person_y[x],2));
				data.add(new E(y,x,dis));
			}
		}
		
		data.sort(new Comparator<E>() {
			@Override
			public int compare(E o1, E o2) {
				// TODO Auto-generated method stub
				return (int)(o1.getDis()*1000-o2.getDis()*1000);
			}
		});
		
		boolean select[] = new boolean[n];
		
		int i =0;
		int index =0;
		while(i<data.size()&& index<n-k) {
			E se = data.get(i);
			if( !select[se.getStart()] || !select[se.getEnd()]) {
				select[se.getStart()] = true;
				select[se.getEnd()] = true;	
				++index;
			}
			++i;
		}
		
		System.out.printf("%.2f",data.get(index).getDis());
	}
	
	public static void find(ArrayList<E> data,E e,E next,Boolean state) {
		state = new Boolean(true);
		for(int i =  0 ; i < data.size() ; ++i) {
			if(next.getEnd()== data.get(i).getStart()) {
				if(e.getEnd()==data.get(i).getEnd()) {
					state = new Boolean(true);
				}
				find(data,e,data.get(i),state);
			}
		}
	}
	

}

class E{
	int start;
	int end;
	double dis;
	public E(int start, int end, double dis) {
		super();
		this.start = start;
		this.end = end;
		this.dis = dis;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public double getDis() {
		return dis;
	}
	public void setDis(double dis) {
		this.dis = dis;
	}
	
	
	
}
