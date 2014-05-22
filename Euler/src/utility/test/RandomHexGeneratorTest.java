package utility.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import utility.RandomHexGenerator;

public class RandomHexGeneratorTest {

	RandomHexGenerator magicGenerator;
	int hexArray;
	int matchArray;
	int stringLength;

	@Before
	public void setUp() throws Exception {
		hexArray = 30;
		matchArray = 50;
		stringLength = 20;
		magicGenerator = new RandomHexGenerator(hexArray, matchArray,
				stringLength, 5);
	}

	@Test
	public void hexGeneratorTest() {
		assertEquals(magicGenerator.clientArraySize, hexArray);
		assertEquals(magicGenerator.stringLength, stringLength);
		assertEquals(magicGenerator.clientStrings.length, hexArray);
		assertEquals(magicGenerator.clientStrings[0].length(), stringLength);
	}

	@Test
	public void matchGeneratorTest() throws Exception {
		for (int i = 0; i < hexArray; i++) {
			if (magicGenerator.matchedIndex[i] > -1) {
				assertEquals(
						magicGenerator.matchStrings[i],
						magicGenerator.clientStrings[magicGenerator.matchedIndex[i]]);
			}
		}
		assertEquals(magicGenerator.matchStrings.length, matchArray);
		magicGenerator.reconstruct(hexArray, matchArray, stringLength, 0);
		assertEquals(magicGenerator.numOfMatches, hexArray);
		for (int i = 0; i < hexArray; i++) {
			if (magicGenerator.matchedIndex[i] > -1) {
				assertEquals(
						magicGenerator.matchStrings[i],
						magicGenerator.clientStrings[magicGenerator.matchedIndex[i]]);
			}
		}
	}
}
