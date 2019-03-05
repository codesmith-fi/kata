package romanNumerals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class romanNumeralParserTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testParseInt_1() {
		assertEquals("I", romanNumeralParser.parseInt(1));
	}
	
	@Test
	void testParseInt_5() {
		assertEquals("V", romanNumeralParser.parseInt(5));
	}
	
	@Test
	void testParseInt_1900() {
		assertEquals("MCM", romanNumeralParser.parseInt(1900));
	}
}
