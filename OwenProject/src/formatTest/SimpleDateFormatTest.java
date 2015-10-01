package formatTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleDateFormatTest {
	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		
		Calendar cal = Calendar.getInstance();
		
		Date sysdate = cal.getTime();
		
		System.out.println(sdf.format(sysdate));
		
	}
}
