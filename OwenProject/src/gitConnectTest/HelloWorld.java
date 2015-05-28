package gitConnectTest;

public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long currentMiliSeconds = System.currentTimeMillis();
		System.out.println(currentMiliSeconds);
		
		long totalSeconds = currentMiliSeconds / 1000;
		System.out.println(totalSeconds);
		
		long currentSeconds = totalSeconds % 60;
		System.out.println(currentSeconds);
		
		long totalMinute = totalSeconds / 60;
		System.out.println(totalMinute);
		
		long currentMinute = totalMinute % 60;
		System.out.println(currentMinute);
		
		long totalHours = currentMinute / 60;
		System.out.println(totalHours);
		
		long currentHours = totalHours % 24;
		System.out.println(currentHours);
		
	}

}
