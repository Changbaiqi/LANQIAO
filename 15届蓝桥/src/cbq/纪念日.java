package cbq;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
/**
 * 无
 * @author 长白崎
 * @class["第十一届蓝桥杯省赛"]
 */
public class 纪念日 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDateTime late = LocalDateTime.of(1921, 7,23,12,0);
		LocalDateTime now = LocalDateTime.of(2020, 7,1,12,0);
		long dif = ChronoUnit.MINUTES.between(late, now);
		System.out.println(dif);
		
	}

}
