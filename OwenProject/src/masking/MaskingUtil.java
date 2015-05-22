package masking;

public class MaskingUtil {

	/**
	 * 이름 마스킹 처리
	 * 
	 * @param name
	 * @return
	 */
	public static String convertToName(String name) {

		String maskedName = null;
		
		if (name != null && !"".equals(name)) {
			char[] charArr = name.toCharArray();
			
			for (int i = 0; i < charArr.length; i++) {
				if (i == 0 || i == charArr.length - 1) {
					continue;
				}
				charArr[i] = '*';
			}
			
			maskedName = new String(charArr);
		}
		else {
			throw new NullPointerException();
		}
		
		return maskedName;

	}

	/**
	 * 번호 마스킹 처리 (번호 안에 하이픈(-)이 존재 할 경우)
	 * 
	 * @param no
	 * @return
	 */
	private static String convertToNo1MiddleAll(String no) {

		String maskedNo = null;
		
		if (no != null && !"".equals(no)) {
			String[] splitedArr = no.split("-");
			char[] charArr = splitedArr[1].toCharArray();
			
			for (int i = 0; i < charArr.length; i++) {
				charArr[i] = '*';
			}
			splitedArr[1] = new String(charArr);
			
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < splitedArr.length; i++) {
				sb.append(splitedArr[i]);
				if (i == splitedArr.length - 1) {
					continue;
				}
				sb.append("-");
			}
			
			maskedNo = sb.toString();
		}
		else {
			throw new NullPointerException();
		}
		
		return maskedNo;

	}

	/**
	 * 번호 마스킹 처리 (번호 안에 하이픈(-)이 존재하지 않을 경우)
	 * 
	 * @param no
	 * @return
	 */
	private static String convertToNo2MiddleAll(String no) {

		String maskedNo = null;
		
		if (no != null && !"".equals(no)) {
			String[] stringArr = new String[3];
			stringArr[0] = no.substring(0, 3);
			stringArr[1] = no.substring(3, no.length() - 4);
			stringArr[2] = no.substring(no.length() - 4, no.length());
			char[] charArr = stringArr[1].toCharArray();
			
			for (int i = 0; i < charArr.length; i++) {
				charArr[i] = '*';
			}
			
			stringArr[1] = new String(charArr);
			
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < stringArr.length; i++) {
				sb.append(stringArr[i]);
			}
			maskedNo = sb.toString();
		}
		else {
			throw new NullPointerException();
		}
		
		return maskedNo;

	}

	/**
	 * 번호 마스킹 처리 (번호안에 하이픈(-)이 존재 할 경우, 가운데번호 첫글자는 제외
	 * 
	 * @param no
	 * @return
	 */
	private static String convertToNo1MiddleFirstExclussion(String no) {

		String maskedNo = null;
		
		if (no != null && !"".equals(no)) {
			String[] splitedArr = no.split("-");
			char[] charArr = splitedArr[1].toCharArray();
			
			for (int i = 0; i < charArr.length; i++) {
				if (i == 0) {
					continue;
				}
				charArr[i] = '*';
			}
			splitedArr[1] = new String(charArr);
			
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < splitedArr.length; i++) {
				sb.append(splitedArr[i]);
				if (i == splitedArr.length - 1) {
					continue;
				}
				sb.append("-");
			}
			maskedNo = sb.toString();
		}
		else {
			throw new NullPointerException();
		}
		
		return maskedNo;

	}

	/**
	 * 번호 마스킹 처리 (번호안에 하이픈(-)이 존재하지 않을 경우, 가운데번호 첫글자는 제외
	 * 
	 * @param no
	 * @return
	 */
	private static String convertToNo2MiddleFirstExclussion(String no) {

		String maskedNo = null;
		
		if (no != null && !"".equals(no)) {
			String[] stringArr = new String[3];
			stringArr[0] = no.substring(0, 3);
			stringArr[1] = no.substring(3, no.length() - 4);
			stringArr[2] = no.substring(no.length() - 4, no.length());
			char[] charArr = stringArr[1].toCharArray();
			
			for (int i = 0; i < charArr.length; i++) {
				if (i == 0) {
					continue;
				}
				charArr[i] = '*';
			}
			stringArr[1] = new String(charArr);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < stringArr.length; i++) {
				sb.append(stringArr[i]);
			}
			maskedNo = sb.toString();
		}
		else {
			throw new NullPointerException();
		}
		
		return maskedNo;

	}

	public static String convertToTellNoInHyphenMiddleAll(String tellNo) {
		return convertToNo1MiddleAll(tellNo);
	}

	public static String convertToCellNoInHyphenMiddleAll(String cellNo) {
		return convertToNo1MiddleAll(cellNo);
	}

	public static String convertToTellNoNotInHyphenMiddleAll(String tellNo) {
		return convertToNo2MiddleAll(tellNo);
	}

	public static String convertToCellNoNotInHyphenMiddleAll(String cellNo) {
		return convertToNo2MiddleAll(cellNo);
	}

	public static String convertToTellNoInHyphenMiddleFirstExclusion(
			String tellNo) {
		return convertToNo1MiddleFirstExclussion(tellNo);
	}

	public static String convertToCellNoInHyphenMiddleFirstExclusion(
			String cellNo) {
		return convertToNo1MiddleFirstExclussion(cellNo);
	}

	public static String convertToTellNoNotInHyphenMiddleFirstExclusion(
			String tellNo) {
		return convertToNo2MiddleFirstExclussion(tellNo);
	}

	public static String convertToCellNoNotInHyphenMiddleFirstExclusion(
			String cellNo) {
		return convertToNo2MiddleFirstExclussion(cellNo);
	}

	/**
	 * 주소 마스킹 처리
	 * 
	 * @param address
	 * @return
	 */
	public static String convertToAddress(String address) {

		String maskedAddress = null;
		
		if (address != null && !"".equals(address)) {
			String[] splitedArr = address.split(" ");
			
			for (int i = 0; i < splitedArr.length; i++) {
				if (splitedArr[i].endsWith("읍") || splitedArr[i].endsWith("면")
						|| splitedArr[i].endsWith("동")) {
					char[] charArr = splitedArr[i].toCharArray();
					for (int j = 0; j < charArr.length; j++) {
						if (j == charArr.length - 1) {
							break;
						}
						charArr[j] = '*';
					}
					splitedArr[i] = new String(charArr);
					break;
				}
			}
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < splitedArr.length; i++) {
				sb.append(splitedArr[i]);
				if (i != splitedArr.length - 1) {
					sb.append(" ");
				}
			}
			maskedAddress = sb.toString();
		}
		else {
			throw new NullPointerException();
		}
		
		return maskedAddress;

	}

	/**
	 * IP주소 마스킹 처리
	 * 
	 * @param ipAddress
	 * @return
	 */
	public static String convertToIpAddress(String ipAddress) {

		String maskedIpAddress = null;
		
		if (ipAddress != null && !"".equals(ipAddress)) {
			/*
			 * IPv4 / IPv6 구분로직 IPv4 -> '.' 로 구분 IPv6 -> ':' 으로 구분
			 */
			if (ipAddress.contains(".")) { // IPv4
				String[] splitedArr = ipAddress.split("\\.");
				
				for (int i = 0; i < splitedArr.length; i++) {
					if (i == splitedArr.length - 2) {
						char[] charArr = splitedArr[i].toCharArray();
						for (int j = 0; j < charArr.length; j++) {
							charArr[j] = '*';
						}
						splitedArr[i] = new String(charArr);
						break;
					}
				}
				
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < splitedArr.length; i++) {
					sb.append(splitedArr[i]);
					if (i != splitedArr.length - 1) {
						sb.append(".");
					}
				}
				maskedIpAddress = sb.toString();
			}
			else if (ipAddress.contains(":")) { // IPv6
				String[] splitedArr = ipAddress.split("\\:");
				
				for (int i = 0; i < splitedArr.length; i++) {
					if (i == splitedArr.length - 1) {
						char[] charArr = splitedArr[i].toCharArray();
						for (int j = 0; j < charArr.length; j++) {
							charArr[j] = '*';
						}
						splitedArr[i] = new String(charArr);
						break;
					}
				}
				
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < splitedArr.length; i++) {
					sb.append(splitedArr[i]);
					if (i != splitedArr.length - 1) {
						sb.append(":");
					}
				}
				
				maskedIpAddress = sb.toString();
			}
			else {
				throw new IllegalArgumentException();
			}
			
		}
		else {
			throw new NullPointerException();
		}
		
		return maskedIpAddress;

	}

	/**
	 * 이메일주소 마스킹 처리
	 * 
	 * @param emailAddress
	 * @return
	 */
	public static String convertToEmailAddress(String emailAddress) {

		String maskedEmailAddress = null;
		if (emailAddress != null && !"".equals(emailAddress)) {
			if (emailAddress.contains("@")) {
				String[] splitedArr = emailAddress.split("@");
				char[] charArr = splitedArr[0].toCharArray();
				if (charArr.length == 1) {

				}
				else if (charArr.length == 2) {
					charArr[charArr.length - 1] = '*';
				}
				else if (charArr.length > 2) {
					int count = 0;
					
					for (int i = charArr.length - 1; i >= 0; i--) {
						if (count > 2) {
							break;
						}
						charArr[i] = '*';
						count++;
					}
				} else {
					throw new IllegalArgumentException();
				}
				splitedArr[0] = new String(charArr);

				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < splitedArr.length; i++) {
					sb.append(splitedArr[i]);
					if (i != splitedArr.length - 1) {
						sb.append("@");
					}
				}
				
				maskedEmailAddress = sb.toString();
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			throw new NullPointerException();
		}
		return maskedEmailAddress;

	}

}
