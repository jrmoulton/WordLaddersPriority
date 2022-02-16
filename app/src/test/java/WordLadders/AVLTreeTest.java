
package WordLadders;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AVLTreeTest {
	AVLTree<Integer> classUnderTest = new AVLTree<Integer>();
    private Integer[] primeList = { 1, 2, 3, 5, 7, 11, 13, 17, 23, 29, 31, 37, 43};

	@Test
	void testPrintTree() {
        classUnderTest.setRoot(null);
        for (int number : primeList) {
            classUnderTest.insert(number);
        }
        String valid = 
"""

         43(0)
      37(1)
         31(0)
   29(2)
      23(0)
17(3)
         13(0)
      11(1)
         7(0)
   5(2)
         3(0)
      2(1)
         1(0)""";
		assertEquals(valid, classUnderTest.toString());
	}

    @Test void testDeleteMin() {
        classUnderTest.setRoot(null);
        for (int number : primeList) {
            classUnderTest.insert(number);
        }
        String valid = 
"""

         43(0)
      37(1)
         31(0)
   29(2)
      23(0)
17(3)
         13(0)
      11(1)
         7(0)
   5(2)
         3(0)
      2(1)""";
        assertEquals(1, classUnderTest.deleteMin());

        assertEquals(valid, classUnderTest.toString());
    }

    @Test
    void testDeleteTillEmptyDoesNotFail() {
        classUnderTest.setRoot(null);
        for (int number : primeList) {
            classUnderTest.insert(number);
        }
        while (!classUnderTest.isEmpty()) {
            classUnderTest.deleteMin();
        }

    }
}
