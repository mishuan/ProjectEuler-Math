package utility.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import utility.WildCardEditDistance;

public class WildCardEditDistanceTest {
	WildCardEditDistance gen;

	@Before
	public void setUp() throws Exception {
		gen = new WildCardEditDistance();
	}

	@Test
	public void testOneDistance() {
		List<String> array = gen.getVariations("string", 1);
		assertEquals("strin*", array.toArray()[array.size() - 2]);
	}
}
