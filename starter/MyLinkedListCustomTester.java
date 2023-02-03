/*
 * Name: Tristan Cooper
 * Email: tmcooper@ucsd.edu
 * PID: A17085814
 * Sources used: MyLinkedListPublicTester.java starter code for reference
 * 
 * This file, MyLinkedListCustomTester.java, contains the custom (hidden) 
 * tests for MyLinkedList.java using JUnit.
 */


/**
 * IMPORTANT: Do not change the method headers. Your tests will be run against
 * good and bad implementations of MyLinkedList. You will only receive points
 * if your test passes when run on a good implementation and fails for the
 * corresponding bad implementation.
 */

import static org.junit.Assert.*;
import org.junit.*;

/**
 * This class contains the custom tests for MyLinkedList.java 
 */
public class MyLinkedListCustomTester {

	private MyLinkedList<Integer> fiveIntegerList;
	private Integer[] intData = {1, 2, 3, 4, 5};

	private MyLinkedList<String> emptyStringList;

	private MyLinkedList<String> threeStringList;
	private String[] strData = {"Tristan Cooper", "CSE 12", "Revelle College"};

	private MyLinkedList<String> twoStringList;
	private String[] twoStrData = {"beginning", "end"};

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
		twoStringList = new MyLinkedList<String>();
	}

	/**
	 * This idea for this method was copied from MyLinkedListPublicTester.java
	 * Has a similar effect as @Before, as it's called in tester 
	 * methods before calling their respective methods to test so that other 
	 * tests aren't affected by data changes.
	 */
	private void populateLinkedList() {
		this.emptyStringList.head.next = this.emptyStringList.tail;
		this.emptyStringList.tail.prev = this.emptyStringList.head;

		MyLinkedList<String>.Node twoStrNode0 = 
			this.twoStringList.new Node(this.twoStrData[0]);
		MyLinkedList<String>.Node twoStrNode1 = 
			this.twoStringList.new Node(this.twoStrData[1]);
		this.twoStringList.head.next = twoStrNode0;
		twoStrNode0.prev = this.twoStringList.head;
		twoStrNode0.next = twoStrNode1;
		twoStrNode1.prev = twoStrNode0;
		twoStrNode1.next = this.twoStringList.tail;
		this.twoStringList.tail.prev = twoStrNode1;
		this.twoStringList.size = 2;


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
		this.populateLinkedList();
		MyLinkedList<Integer>.Node oldLastNode = this.fiveIntegerList.tail.prev;
		this.fiveIntegerList.add(6);

		assertEquals("Size should be incremented", 6, 
			this.fiveIntegerList.size);
		assertEquals("New node should be accessible from the tail", 
			Integer.valueOf(6), this.fiveIntegerList.tail.prev.data);

		assertEquals("Tail should point back to the new node", 
			Integer.valueOf(6), this.fiveIntegerList.tail.prev.data);
		assertEquals("New node should point back to the previous last node", 
			this.fiveIntegerList.tail.prev.prev.data, oldLastNode.data);
		assertEquals("Previous last node should point forward to the new node", 
			oldLastNode.next.data, this.fiveIntegerList.tail.prev.data);
		assertSame("Previous last node next next should be tail",
            oldLastNode.next.next, this.fiveIntegerList.tail);
	}

	/**
	 * Aims to test the add(int index, E data) method.
	 * Add a valid argument to the beginning of MyLinkedList.
	 */
	@Test
	public void testCustomAddIdxToStart() {
		this.populateLinkedList();

		MyLinkedList<String>.Node oldFirstNode = this.threeStringList.head.next;
		this.threeStringList.add(0, "Point Loma");

		assertEquals("Size should be incremented", 4, 
			this.threeStringList.size);
		assertEquals("New node should be accessible from the head", 
			"Point Loma", this.threeStringList.head.next.data);
		assertSame("Old first node should point backward to the new node", 
			oldFirstNode.prev, this.threeStringList.head.next);
		assertSame("Old node should be accessible from the new node", 
			this.threeStringList.head.next.next, oldFirstNode);
		assertSame("New node should point backward to the head", 
			this.threeStringList.head.next.prev, this.threeStringList.head);	
	}

	/**
	 * Aims to test the add(int index, E data) method.
	 * Add a valid argument to the middle of MyLinkedList.
	 */
	@Test
	public void testCustomAddIdxToMiddle() {
		this.populateLinkedList();
		this.twoStringList.add(1, "middle");
		MyLinkedList<String>.Node endNode = 
			this.twoStringList.tail.prev;
		MyLinkedList<String>.Node beginningNode = 
			this.twoStringList.head.next;

		assertEquals("Size should be incremented", 3, 
			this.twoStringList.size);
		assertEquals("New node should be accessible from the beginning node", 
			"middle", beginningNode.next.data);
		assertSame("Middle node should be after the beginning node", 
			beginningNode.next, this.twoStringList.head.next.next);
		assertSame("Middle node should be before the end node", 
			endNode.prev, this.twoStringList.head.next.next);
		assertEquals("New node should be accessible from the end node", 
			"middle", endNode.prev.data);
		assertEquals("Middle node should be accessible from the tail", 
			"middle", this.twoStringList.tail.prev.prev.data);
	}

	/**
	 * Aims to test the remove(int index) method. Remove from an empty list.
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public void testCustomRemoveFromEmpty() {
		this.populateLinkedList();
		// Can't remove from an empty list
		this.emptyStringList.remove(0);
		// Can't remove from a negative index
		this.emptyStringList.remove(-1);
		// Can't remove from an index greater than the size
		this.emptyStringList.remove(99);
		assertEquals(this.emptyStringList.size, 0);
	}

	/**
	 * Aims to test the remove(int index) method.
	 * Remove a valid argument from the middle of MyLinkedList.
	 */
	@Test
	public void testCustomRemoveFromMiddle() {
		this.populateLinkedList();
		MyLinkedList<Integer>.Node node2 = 
			this.fiveIntegerList.head.next.next;
		MyLinkedList<Integer>.Node node3 = 
			this.fiveIntegerList.head.next.next.next;
		MyLinkedList<Integer>.Node node4 = 
			this.fiveIntegerList.tail.prev.prev;

		// Aiming to remove "3" from the middle of the list
		this.fiveIntegerList.remove(2);

		assertEquals("Size should be decremented", 4, 
			this.fiveIntegerList.size);
		assertEquals("Data in node previous to removed node should be" + 
			"immediately accessible from node after removed node", 
			node2.data, node4.prev.data);
		assertEquals("Data in node after removed node should be immediately" +
			"accessible from the node before removed node", 
			node4.data, node2.next.data);
		assertSame("Node previous to removed node should point forward to" +
			"node after removed node", node2.next, node4);
		assertSame("Node after removed node should point backward to node" +
			"previous to removed node", node4.prev, node2);
			
		assertEquals(null, node3.data);

	}

	/**
	 * Aims to test the set(int index, E data) method.
	 * Set an out-of-bounds index with a valid data argument.
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public void testCustomSetIdxOutOfBounds() {
		this.populateLinkedList();
		this.threeStringList.set(99, "out of bounds element");
		this.fiveIntegerList.set(-1, 99);
	}

	/**
	 * TESTER I ADDED TO STARTER CODE:
	 * Aims to test the set(int index, E data) method.
	 * Set the last index with a valid data argument.
	 */
	@Test
	public void testCustomSetLastIdx() {
		this.populateLinkedList();
		MyLinkedList<Integer>.Node intNode4 = 
			this.fiveIntegerList.tail.prev.prev;
		this.fiveIntegerList.set(4, 99);
		assertSame("Node before the one replaced should point to new node", 
			this.fiveIntegerList.tail.prev, intNode4.next);
		assertSame("New node should point backward to the node before it", 
			this.fiveIntegerList.tail.prev.prev, intNode4);
		assertEquals("New node should contain new data", 
			99, (int)this.fiveIntegerList.tail.prev.data);
	}
}
