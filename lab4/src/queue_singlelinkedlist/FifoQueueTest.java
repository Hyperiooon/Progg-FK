package queue_singlelinkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FifoQueueTest {
	private FifoQueue<Integer> q1;
	private FifoQueue<Integer> q2;
	private FifoQueue<Integer> q3;
	private FifoQueue<Integer> q4;

	@BeforeEach
	void setUp() {
		q1 = new FifoQueue<Integer>();
		q2 = new FifoQueue<Integer>();
		q3 = new FifoQueue<Integer>();
		q4 = new FifoQueue<Integer>();

		for (int i = 0; i < 5; i++) {
			q3.offer(i);
			int p = i + 4;
			q4.offer(p);
		}
	}

	@AfterEach
	void tearDown() {
		q1 = null;
		q2 = null;
		q3 = null;
		q4 = null;
	}

	@Test
	void testAppendTwoEmptyQueues() {
		q1.append(q2);
		assertTrue(q1.isEmpty());
		assertTrue(q1.size() == 0);
	}

	@Test
	void testEmptyAppendNotEmpty() {
		q1.append(q3);
		assertFalse(q1.isEmpty());
		assertTrue(q3.isEmpty());
		int i = q1.peek();
		assertEquals(5, q1.size());
		assertEquals(0, i);
	}

	@Test
	void testNotEmptyAppendEmpty() {
		q3.append(q1);
		assertTrue(q1.isEmpty());
		assertFalse(q3.isEmpty());
		int i = q3.peek();
		assertEquals(5, q3.size());
		assertEquals(0, i);

	}

	@Test
	void testNotEmptyAppendNotEmpty() {
		q3.append(q4);
		assertFalse(q3.isEmpty());
		assertTrue(q4.isEmpty());
		int i = q3.peek();
		assertEquals(10, q3.size());
		assertEquals(4, i);
	}

	@Test
	void testAppendItSelf() {
		try {
			q3.append(q3);
			fail("IllegalArgumentException e");
		} catch (IllegalArgumentException e) {
			// successful test
		}
	}

}
