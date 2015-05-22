package dailyTest;
public class Test1 {

	private String encode(String src) {

		StringBuffer sb = new StringBuffer();
		char c;

		for (int i = 0; i < src.length(); i++) {

			c = src.charAt(i);

			if (Character.isLetterOrDigit(c)) {
				sb.append(c);
			} else {
				sb.append('%' + Integer.toHexString((int) c));
			}
		}

		return sb.toString();

	}

	private String decode(String src) {

		StringBuffer sb = new StringBuffer();
		char c;

		for (int i = 0; i < src.length(); i++) {

			c = src.charAt(i);

			if (Character.isLetterOrDigit(c)) {
				sb.append(c);
			} else {
				if (Character.valueOf(c).equals('%')) {
					String hexCd = src.substring(i + 1, i + 2) + src.substring(i + 2, i + 3);
					int ii = Integer.valueOf(hexCd, 16);
					sb.append((char) ii);

					i = i + 2;
				} else {
					sb.append(c);
				}
			}

		}

		return sb.toString();
	}

	public static void main(String[] args) {

		Test1 t = new Test1();

		System.out.println(t.encode("Happy Joy Joy!"));
		System.out.println(t.decode("Happy%20Joy%20Joy%21"));
		
		System.out.println(t.encode("http://algospot.com/*"));			// 이부분이 예외케이스로 걸립니다.
		System.out.println(t.decode("http://algospot.com/%2a"));		
	}

}
