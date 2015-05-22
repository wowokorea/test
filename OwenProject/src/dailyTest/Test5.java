package dailyTest;

public class Test5 {

	public static String template(String template, Object... args) {
		StringBuffer buf = new StringBuffer(template.length() + args.length
				* 10);

		boolean braceOpened = false;
		int argIndex = 0;
		int targetArgIndex = -1;
		char lastChar = 0;
		boolean lineFlattenFlag = false;
		for (int i = 0; i < template.length(); i++) {
			char ch = template.charAt(i);
			if (ch == '{') {
				if (lastChar != '\\') {
					braceOpened = true;
				} else {
					buf.deleteCharAt(buf.length() - 1);
					buf.append(ch);
				}
			} else if (ch == '}' && braceOpened) {
				Object selectedArg = args[targetArgIndex == -1 ? argIndex++
						: targetArgIndex];
				buf.append(lineFlatten(selectedArg, lineFlattenFlag));
				targetArgIndex = -1;
				braceOpened = false;
				lineFlattenFlag = false;
			} else if (braceOpened == true) {
				if (Character.isDigit(ch)) {
					targetArgIndex = targetArgIndex == -1 ? Character
							.getNumericValue(ch) : targetArgIndex * 10
							+ Character.getNumericValue(ch);
				} else if (ch == 'L') {
					lineFlattenFlag = true;
				}
			} else {
				buf.append(ch);
			}
			lastChar = ch;
		}
		return buf.toString();
	}

	private static String lineFlatten(Object object, boolean lineFlattenFlag) {
		String str = object.toString();
		return lineFlattenFlag ? str.replaceAll("\n", " ") : str;
	}

}
