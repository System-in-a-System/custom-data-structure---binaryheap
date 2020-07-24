

/**
 * The Class BinaryIntHeap
 * Represents a custom data structure BinaryIntHeap
 * 
 */
public class BinaryIntHeap {
	
	/** Array-based "buckets" to hold BinaryIntHeap's elements. */
	private int [] elements;
	
	/** The size of the BinaryIntHeap. */
	private int size = 0;
	
	
	
	
	/**
	 * Instantiates an empty BinaryIntHeap.
	 */
	public BinaryIntHeap() {
		elements = new int[8];
	}
	
	
	
	/**
	 * Inserts new integers into the BinaryIntHeap
	 *
	 * @param element is the integer value to be inserted into the BinaryIntHeap 
	 */
	public void insert(int element) {
		
		// Locate the landing position for a new int
							  // increment the size before assigning its value to the landing position
							  // in order to avoid assigning position at index 0 
		int landingPosition = ++size;
		
		
		// Resize when the arrays capacity has been reached
		if (size >= elements.length - 1)
			resize();
		
		
		//  As long as the parent node has a lower priority...
		while(landingPosition > 1 && element > elements[landingPosition/2]) {
			
			// swap places with the parent node and percolate up the binary heap 
			elements[landingPosition] = elements[landingPosition/2];
			landingPosition = landingPosition/2;
		}
		
		// Assign new int to its final landing position in the heap
		elements[landingPosition] = element;
	}
	
	
	
	/**
	 * Returns and removes the element with the highest priority
	 *
	 * @return the int value with the highest priority (=the biggest int value)
	 */ 
	public int pullHighest() {
		
		// Capture the element with the highest priority
		int highest = elements[1];
		
		
		// Move the last element to the root of the heap
		elements[1] = elements[size];
		elements[size] = 0;
		size--;
		
		// Capture the smallest element (that is now in the root of the heap)
		int littleton = elements[1];
		
		
		// Set the starting position of the perlocation
		int sourcePosition = 1;
		
		while(sourcePosition < size && sourcePosition*2 < elements.length) {	
			
			int controlPosition = sourcePosition * 2;
			
			// If the left child is smaller than the right child...
			if (elements[controlPosition] < elements[controlPosition + 1]) 
				controlPosition++; // we are taking the right child as a comparison material
			
			
			
			// If the child is bigger than the parent...
			if (elements[controlPosition] > littleton)  {
				
				// swap their positions (=perlocate down the binary heap)
				elements[sourcePosition] = elements[controlPosition];
				elements[controlPosition] = littleton;
				sourcePosition = controlPosition;
			
				
			// If the child is smaller than the parent, then it is on its place (=binary heap logic is preserved)	
			} else 
				break;
		}
		
		return highest;
	}
	
	
	
	/**
	 * Returns the current size of the BinaryIntHeap
	 *
	 * @return the int representation of the current size of the BinaryIntHeap
	 */
	public int size() {
		return size;
	}
	
	
	/**
	 * Returns underlying capacity of the array the BinaryIntHeap is based on
	 *
	 * @return the size of the array the BinaryIntHeap is based on
	 */
	public int underlyingCapacity() {
		return elements.length;
	}
	
	
	
	/**
	 * Checks if the BinaryIntHeap is empty.
	 *
	 * @return true, if the BinaryIntHeap is empty
	 */
	// True if heap is empty
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	
	/**
	 * Resizes the array BinaryIntHeap is based on.
	 */
	private void resize() {
		
		// Declare a new array which is double size of the original 
		int doubleSize = (elements.length - 1) * 2 + 1; 
		int temp[] = new int[doubleSize];
		
		// Copy elements to the newly declared array
		System.arraycopy(elements, 1, temp, 1, elements.length-1);
		
		// Reassign 
		elements = temp;
	}
}
