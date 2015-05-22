package dailyTest;
public class Test3 {

	public String userFormat(String template, Object... objects) {

		StringBuffer sb = new StringBuffer();
		Object[] srcs = objects;
		int srcsIdx = 0;

		for (int i = 0; i < template.length(); i++) {
			char c = template.charAt(i);
			if (Character.valueOf(c).equals('{')) {
				int k = i + 2;
				StringBuffer sb2 = new StringBuffer();
				for (int j = i + 1; j < k; j++) {
					if (Character.isDigit((template.charAt(j)))) {
						sb2.append(template.charAt(j));
						k++;
					} else {
						break;
					}
				}
				i = k - 1;
				if (sb2.length() != 0) {
					sb.append(srcs[Integer.parseInt(sb2.toString())]);
				} else {
					sb.append(srcs[srcsIdx]);
					srcsIdx++;
				}
			} else {
				sb.append(c);
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {

		Test3 t3 = new Test3();

		System.out.println(t3.userFormat("이런 경우 A = {}이고 B = {} 일때 {1} + {0} 를 계산해야합니다.", 1, 2));
		System.out.println(t3.userFormat("이런 경우 A = {}이고 B = {1} + {0} C : {}", 1, 2));

		System.out.println(t3.userFormat("{0},{1},{2},{3},{4},{5},{6},{7},{8},{9},{10},{11},{12} ", 0,1,2,3,4,5,6,7,8,9,10,11,12));
		
	}
}
