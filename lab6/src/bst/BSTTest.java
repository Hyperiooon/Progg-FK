package bst;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BSTTest {
	private BinarySearchTree<Integer> bst;

	@Before
	public final void setUp() throws Exception {
		bst = new BinarySearchTree<Integer>();
	}

	@After
	public final void tearDown() throws Exception {
		bst.clear();
	}

	@Test
	public final void testOneInteger() {
		bst.add(4);
		assertEquals(bst.size(), 1);
		assertEquals(bst.height(), 1);
		// Fixa så att den testar sysout också
		bst.printTree();
	}

	@Test
	public final void testMoreIntegers() {
		bst.add(1);
		bst.add(2);
		bst.add(6);
		bst.add(9);
		assertEquals(bst.size(), 4);
		assertSame(bst.height(), 4);
		bst.printTree();
	}

	@Test
	public final void testSameDigits() {
		bst.add(3);
		bst.add(3);
		assertSame(bst.size(), 1);
		assertSame(bst.height(), 1);
		bst.printTree();
	}
	
	@Test
	public final void testEmptyTree() {
		assertSame(bst.size(), 0);
		assertSame(bst.height(), 0);
		bst.printTree();
	}

}
