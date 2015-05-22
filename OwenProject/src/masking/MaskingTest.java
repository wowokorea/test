package masking;


public class MaskingTest {
	
	public static void main(String[] args) {
		
		System.out.println("-- 이름 마스킹 --");
		System.out.println(MaskingUtil.convertToName("이종민"));
		System.out.println(MaskingUtil.convertToName("김세레나"));
		System.out.println(MaskingUtil.convertToName("Jason Park"));
		
		System.out.println();
		
		System.out.println("-- 번호 마스킹 --");
		System.out.println(MaskingUtil.convertToCellNoInHyphenMiddleAll("010-399-6417"));
		System.out.println(MaskingUtil.convertToCellNoInHyphenMiddleAll("010-6388-6417"));

		System.out.println(MaskingUtil.convertToTellNoNotInHyphenMiddleAll("0103396417"));
		System.out.println(MaskingUtil.convertToTellNoNotInHyphenMiddleAll("01063886417"));
		
		System.out.println(MaskingUtil.convertToCellNoInHyphenMiddleFirstExclusion("010-399-6417"));
		System.out.println(MaskingUtil.convertToCellNoInHyphenMiddleFirstExclusion("010-6388-6417"));

		System.out.println(MaskingUtil.convertToTellNoNotInHyphenMiddleFirstExclusion("0103396417"));
		System.out.println(MaskingUtil.convertToTellNoNotInHyphenMiddleFirstExclusion("01063886417"));
		
		System.out.println();
		
		System.out.println("-- 주소 마스킹 --");
		System.out.println(MaskingUtil.convertToAddress("경기도 시흥시 장곡읍 대우3차아파트 123동 505호"));
		System.out.println(MaskingUtil.convertToAddress("경기도 시흥시 장곡면 대우3차아파트 123동 505호"));
		System.out.println(MaskingUtil.convertToAddress("경기도 시흥시 장곡동 대우3차아파트 123동 505호"));
		
		System.out.println();
		
		System.out.println("-- IP 마스킹 --");
		System.out.println(MaskingUtil.convertToIpAddress("121.123.233.145"));
		System.out.println(MaskingUtil.convertToIpAddress("121.123.23.145"));
		System.out.println(MaskingUtil.convertToIpAddress("2001:0D88:010F:0001:0000:0000:0000:0D0C"));
		
		System.out.println();
		
		System.out.println("-- 이메일주소 마스킹 --");
		System.out.println(MaskingUtil.convertToEmailAddress("w@nate.com"));
		System.out.println(MaskingUtil.convertToEmailAddress("wo@nate.com"));
		System.out.println(MaskingUtil.convertToEmailAddress("wowokorea@nate.com"));
		
	}
	
}
