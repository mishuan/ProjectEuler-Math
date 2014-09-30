package utility.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import utility.WildCardEditDistance;

public class WildCardEditDistanceTest {
   WildCardEditDistance gen;

   @Test
   public void testOneDistance() {
      List<String> array = WildCardEditDistance.getVariations("string", 1);
      assertEquals("strin*", array.toArray()[array.size() - 2]);
   }
}
