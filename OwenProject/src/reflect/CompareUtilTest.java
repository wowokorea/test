package reflect;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CompareUtilTest implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {

		// 1. 클래스 명 비교
		if (!compareClassName(o1, o2)) {
			return 1;
		}

		// 2. 필드 비교
		if (!compareFieldsSize(o1, o2)) {
			return 1;
		}

		// 3. 필드 타입 값 비교
		if (!compareTypeAndValue(o1, o2)) {
			return 1;
		}

		return 0;
	}

	/**
	 * 인스턴스명 비교
	 * 
	 * @param o1
	 * @param o2
	 * @return boolean
	 */
	private boolean compareClassName(Object o1, Object o2) {

		String o1ClassName = o1.getClass().getSimpleName();
		String o2ClassName = o2.getClass().getSimpleName();

		if (!o1ClassName.equals(o2ClassName)) {
			return false;
		}

		return true;
	}

	/**
	 * 인스턴스의 필드 사이즈 비교
	 * 
	 * @param o1
	 * @param o2
	 * @return boolean
	 */
	private boolean compareFieldsSize(Object o1, Object o2) {

		Field[] o1Fields = o1.getClass().getDeclaredFields();
		Field[] o2Fields = o2.getClass().getDeclaredFields();
		int o1FieldCount = o1Fields.length;
		int o2FieldCount = o2Fields.length;

		if (o1FieldCount != o2FieldCount) {
			return false;
		}

		return true;
	}

	/**
	 * 인스턴스의 필드, 값 비교
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 */
	private boolean compareTypeAndValue(Object o1, Object o2) {

		Field[] o1Fields = o1.getClass().getDeclaredFields();
		Field[] o2Fields = o2.getClass().getDeclaredFields();

		Map<Object, String> o1InfoList = new HashMap<Object, String>();
		Map<Object, String> o2InfoList = new HashMap<Object, String>();

		for (Field field : o1Fields) {
			field.setAccessible(true);
			Class<?> clazz = field.getType();
			String value = null;
			try {
				value = field.get(o1).toString();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

			o1InfoList.put(clazz, value);
		}

		for (Field field : o2Fields) {
			field.setAccessible(true);
			Class<?> clazz = field.getType();
			String value = null;
			try {
				value = field.get(o2).toString();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			o2InfoList.put(clazz, value);
		}

		if (!o1InfoList.equals(o2InfoList)) {
			return false;
		}

		return true;

	}

}
