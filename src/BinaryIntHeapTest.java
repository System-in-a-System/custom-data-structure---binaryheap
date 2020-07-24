import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class BinaryIntHeapTest {

	
	/**
	 * Method to be executed before each test method
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Testing started");
	}

	
	
	/**
	 * Method to be executed after each test method
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Testing completed");
	}
	

	
	
	@Test
	void test() {
		// Test size() and isEmpty()
		BinaryIntHeap testHeap = new BinaryIntHeap();
		assertTrue(testHeap.isEmpty());
		assertEquals(0, testHeap.size());	
				
		testHeap.insert(1);
		assertFalse(testHeap.isEmpty());
		assertEquals(1, testHeap.size());
				
				
		// Test insert()
		testHeap.insert(5);
		testHeap.insert(3);
		testHeap.insert(4);
		testHeap.insert(2);
		assertFalse(testHeap.isEmpty());
		assertEquals(5, testHeap.size());
				
				
		// Test pullHighest()
		assertEquals(5, testHeap.pullHighest());
		assertEquals(4, testHeap.pullHighest());
		assertEquals(3, testHeap.pullHighest());
		assertEquals(2, testHeap.pullHighest());
		assertEquals(1, testHeap.pullHighest()); 
			
		assertEquals(0, testHeap.size());
		assertTrue(testHeap.isEmpty());
				
				
				
		// Test resizing
		assertEquals(8, testHeap.underlyingCapacity());
			
		for(int i = 0; i <= 8; i++) 
			testHeap.insert(i);
				
		assertEquals(15, testHeap.underlyingCapacity());
	}

}
