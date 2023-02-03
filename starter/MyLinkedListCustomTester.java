
/**
 * IMPORTANT: Do not change the method headers. Your tests will be run against
 * good and bad implementations of MyLinkedList. You will only receive points
 * if your test passes when run on a good implementation and fails for the
 * corresponding bad implementation.
 */

import static org.junit.Assert.*;
import org.junit.*;

public class MyLinkedListCustomTester {

	// Optional: add test variables here

	private MyLinkedList<Integer> fiveIntegerList;
	private Integer[] intData = {1, 2, 3, 4, 5};

	private MyLinkedList<String> emptyStringList;

	private MyLinkedList<String> threeStringList;
	private String[] strData = {"Tristan Cooper", "CSE 12", "Revelle College"};

	/**
	 * This sets up the test fixture. JUnit invokes this method before
	 * every testXXX method. The @Before tag tells JUnit to run this method
	 * before each test.
	 */
	@Before
	public void setUp() throws Exception {
		fiveIntegerList = new MyLinkedList<Integer>();
		emptyStringList = new MyLinkedList<String>();
		threeStringList = new MyLinkedList<String>();
	}

	private void populateLinkedList() {
		this.emptyStringList.head.next = this.emptyStringList.tail;
		this.emptyStringList.tail.prev = this.emptyStringList.head;

		MyLinkedList<String>.Node strNode0 =  
			this.threeStringList.new Node(this.strData[0]);
		MyLinkedList<String>.Node strNode1 =  
			this.threeStringList.new Node(this.strData[1]);
		MyLinkedList<String>.Node strNode2 =  
			this.threeStringList.new Node(this.strData[2]);

		this.threeStringList.head.next = strNode0;
		strNode0.prev = this.threeStringList.head;
		strNode0.next = strNode1;
		strNode1.prev = strNode0;
		strNode1.next = strNode2;
		strNode2.prev = strNode1;
		strNode2.next = this.threeStringList.tail;
		this.threeStringList.tail.prev = strNode2;
		this.threeStringList.size = 3;

		MyLinkedList<Integer>.Node intNode0 =  
			this.fiveIntegerList.new Node(this.intData[0]);
		MyLinkedList<Integer>.Node intNode1 = 
			this.fiveIntegerList.new Node(this.intData[1]);
		MyLinkedList<Integer>.Node intNode2 = 
			this.fiveIntegerList.new Node(this.intData[2]);
		MyLinkedList<Integer>.Node intNode3 = 
			this.fiveIntegerList.new Node(this.intData[3]);
		MyLinkedList<Integer>.Node intNode4 = 
			this.fiveIntegerList.new Node(this.intData[4]);

		this.fiveIntegerList.head.next = intNode0;
		intNode0.prev = this.fiveIntegerList.head;
		intNode0.next = intNode1;
		intNode1.prev = intNode0;
		intNode1.next = intNode2;
		intNode2.prev = intNode1;
		intNode2.next = intNode3;
		intNode3.prev = intNode2;
		intNode3.next = intNode4;
		intNode4.prev = intNode3;
		intNode4.next = this.fiveIntegerList.tail;
		this.fiveIntegerList.tail.prev = intNode4;
		this.fiveIntegerList.size = 5;
	}

	/**
	 * Aims to test the add(E data) method with a valid argument.
	 */
	@Test
	public void testCustomAdd() {
		// TODO: add your test here
	}

	/**
	 * Aims to test the add(int index, E data) method.
	 * Add a valid argument to the beginning of MyLinkedList.
	 */
	@Test
	public void testCustomAddIdxToStart() {
		// TODO: add your test here
	}

	/**
	 * Aims to test the add(int index, E data) method.
	 * Add a valid argument to the middle of MyLinkedList.
	 */
	@Test
	public void testCustomAddIdxToMiddle() {
		// TODO: add your test here
	}

	/**
	 * Aims to test the remove(int index) method. Remove from an empty list.
	 */
	@Test
	public void testCustomRemoveFromEmpty() {
		// TODO: add your test here
	}

	/**
	 * Aims to test the remove(int index) method.
	 * Remove a valid argument from the middle of MyLinkedList.
	 */
	@Test
	public void testCustomRemoveFromMiddle() {
		// TODO: add your test here
	}

	/**
	 * Aims to test the set(int index, E data) method.
	 * Set an out-of-bounds index with a valid data argument.
	 */
	@Test
	public void testCustomSetIdxOutOfBounds() {
		// TODO: add your test here
	}
}
