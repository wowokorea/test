package dailyTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test5RefactoringTest {

	@Test
	public void test() {
		assertEquals("A: 1", Test5.template("A: {}", 1,3,4,5,6,7,8));
		assertEquals("A: 1 B: STR C: false", Test5.template("A: {} B: {} C: {}", 1,"STR", false));
		assertEquals("0,1,2,3,4,5,6,7,8,9,10,11,12", Test5.template("{0},{1},{2},{3},{4},{5},{6},{7},{8},{9},{10},{11},{12}", 0,1,2,3,4,5,6,7,8,9,10,11,12));
		assertEquals("12,11,10,9,8,7,6,5,4,3,2,1,0", Test5.template("{12},{11},{10},{9},{8},{7},{6},{5},{4},{3},{2},{1},{0}", 0,1,2,3,4,5,6,7,8,9,10,11,12));
		assertEquals("A = 1 B = 2 + 1 C = 22 - (3 * 3) ", Test5.template("A = {} B = {1} + {0} C = {}{1} - ({2} * {}) ", 1,2,3));
		assertEquals("{ Hello }", Test5.template("\\{ {} }", "Hello"));
		assertEquals("\\{ Hello }", Test5.template("\\\\{ {} }", "Hello"));
		assertEquals("{ Hello \\}", Test5.template("\\{ {} \\}", "Hello"));
		assertEquals("{ Hello }\\", Test5.template("\\{ {} }\\", "Hello"));
		assertEquals( "abc def", Test5.template("{0,L}", "abc\ndef"));
		assertEquals( " abc def", Test5.template("{0,L}", "\nabc\ndef"));
		assertEquals( " abc def ", Test5.template("{0,L}", "\nabc\ndef\n"));
		assertEquals( " abc def ", Test5.template("{0,L}", "\nabc\ndef\n"));
		assertEquals("{  abc def  }\\", Test5.template("\\{ {0,L} }\\", "\nabc\ndef\n"));
		assertEquals("{  abc def  }\\  abc def ", Test5.template("\\{ {0,L} }\\ {0,L}", "\nabc\ndef\n"));
		assertEquals("{  123 456  }\\  abc def ", Test5.template("\\{ {1,L} }\\ {0,L}", "\nabc\ndef\n", "\n123\n456\n"));
	}

}
