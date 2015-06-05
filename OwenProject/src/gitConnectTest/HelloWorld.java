package gitConnectTest;

public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
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
		*/
		
		System.out.println("너랑은 상관없음1");
		
		for (int i = 0; i < 3; i++) {
			System.out.println("----------------------" + i + "----------------------");
			
			try {
				//throw new Exception();
			} catch (Exception e) {
				System.out.println("익셉션 발생");
				
				if (i < 3) {

					try {
						Thread.sleep(1);
					} catch (Exception e2) {
						System.out.println("스레드 슬립에서 익셉션 발생");
						break;
					}
					
					System.out.println("다시 돌아라");
					
					continue;
				} else {
					System.out.println("오류 계속나서 끝");
				}
				
				System.out.println("로그 찍을거야");
				return;
				
			}
			
			break;
			
		}
		
		System.out.println("너랑은 상관없음2");
		System.out.println("너랑은 상관없음3");
		
	}

}
