package lanqiao;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class �غϴ��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		LocalTime data = LocalTime.of(6, 13,22);
		int sum =0;
		while(data.isBefore(LocalTime.of(14, 36,20))) {
			data = data.plusSeconds(1);
			if(data.getMinute()==data.getSecond()&& !(data.getMinute()==59 && data.getSecond()==59))
				++sum; 
		}
		System.out.println(sum);
	}

}
