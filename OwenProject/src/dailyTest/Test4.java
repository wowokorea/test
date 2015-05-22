package dailyTest;
public class Test4 {

	public static char NO_NEW_LINE = 'L';

	public static String template(String template, Object... args) {
		StringBuffer buf = new StringBuffer(template.length() + args.length	* 10);
		StringBuffer buf2 = new StringBuffer(template.length() + args.length * 10);

		boolean braceOpened = false;
		int argIndex = 0;
		int targetArgIndex = -1;
		boolean optFlag = false;
		char optVal = '\n';

		for (int i = 0; i < template.length(); i++) {
			char ch = template.charAt(i);
			
			if (ch == '\\') {
				i++;
				continue;
			}

			if (ch == '{') {
				braceOpened = true;
			} else if (ch == '}') {

				Object obj = args[targetArgIndex == -1 ? argIndex++ : targetArgIndex];

				for (int j = 0; j < obj.toString().length(); j++) {
					char ch2 = obj.toString().charAt(j);

					if (ch2 == optVal && optFlag) {
						ch2 = ' ';
					}
					buf2.append(ch2);
				}
				buf2.trimToSize();
				buf.append(buf2);
				targetArgIndex = -1;
				braceOpened = false;
			} else if (braceOpened == true) {
				if (Character.isDigit(ch)) {
					targetArgIndex = targetArgIndex == -1 ? Character
							.getNumericValue(ch) : targetArgIndex * 10
							+ Character.getNumericValue(ch);
				} else if (ch == ',') { // 옵션 구분자
					continue;
				} else if (ch == NO_NEW_LINE) {
					optFlag = true;
				}
			} else if (braceOpened == false) {
				buf.append(ch);
			}
		}

		buf.trimToSize();
		return buf.toString();
	}

	public static void main(String[] args) {

		System.out.println("{ Hello } : " + template("\\{{}\\}", "Hello"));
		System.out.println("abc def : " + template("{0}", "abc\ndef", "123\n456"));
		System.out.println("abc def : " + template("{1,L}", "abc\ndef", "123\n456"));

	}
}
