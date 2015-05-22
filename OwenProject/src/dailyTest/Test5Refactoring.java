package dailyTest;


public class Test5Refactoring {

	public static String template(String template, Object... srcs) {
		
		StringBuffer buf = new StringBuffer(template.length() + srcs.length	* 10);

		boolean isBraceOpened = false;			// 중괄호 열린여부 플래그
		int sourceIndex = 0;					// 소스문자열 인덱스
		int targetSourceIndex = -1;				// 대상소스 문자열 인덱스
		char lastChar = 0;						// 버퍼에 가장 최근에 입력된 문자열 값
		boolean lineFlattenFlag = false;		// 라인패턴 플래그
		
		for (int i = 0; i < template.length(); i++) {
			char ch = template.charAt(i);
			
			if (ch == '{') {
				isBraceOpened = checkLastCharacterIsBackSlash(buf, isBraceOpened, lastChar, ch);
				
			} else if (ch == '}' && isBraceOpened == true) {
				Object selectedSource = getSourceIndex(sourceIndex, targetSourceIndex, srcs);
				
				buf.append(lineFlatten(selectedSource, lineFlattenFlag));
				targetSourceIndex = -1;
				isBraceOpened = false;
				lineFlattenFlag = false;
				
			} else if (isBraceOpened == true) {
				if (Character.isDigit(ch)) {
					targetSourceIndex = getTargetSourceIndex(targetSourceIndex,	ch);
					
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

	private static boolean checkLastCharacterIsBackSlash(StringBuffer buf, boolean isBraceOpened, char lastChar, char ch) {
		
		if (lastChar != '\\') {
			isBraceOpened = true;
		} else {
			buf.deleteCharAt(buf.length() - 1);
			buf.append(ch);
		}
		
		return isBraceOpened;
		
	}

	private static int getTargetSourceIndex(int targetSourceIndex, char ch) {
		
		if (targetSourceIndex == -1) {
			targetSourceIndex = Character.getNumericValue(ch);
		} else {
			targetSourceIndex = targetSourceIndex * 10 + Character.getNumericValue(ch);
		}
		
		return targetSourceIndex;
		
	}

	private static Object getSourceIndex(int sourceIndex, int targetSourceIndex, Object... srcs) {
		
		Object selectedSource;
		
		if (targetSourceIndex == -1) {
			sourceIndex++;
			selectedSource = srcs[sourceIndex];
		} else {
			selectedSource = srcs[targetSourceIndex];
		}
		
		return selectedSource;
		
	}
	
	private static String lineFlatten(Object object, boolean lineFlattenFlag) {
		
		String str = object.toString();
		return lineFlattenFlag ? str.replaceAll("\n", " ") : str;
		
	}
	
}
