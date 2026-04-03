package neetcode.minStack;

import org.junit.Assert;
import org.junit.Test;

import ttg.traning.neetcode.minStack.MinStack;

/**
 *
 * @author ttg
 */
public class MinStackTest {

    @Test
    public void testExampleSequence() {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        Assert.assertEquals(0, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(2, minStack.top());
        Assert.assertEquals(1, minStack.getMin());
    }

    @Test
    public void testSingleElement() {
        MinStack minStack = new MinStack();
        minStack.push(42);
        Assert.assertEquals(42, minStack.top());
        Assert.assertEquals(42, minStack.getMin());
    }

    @Test
    public void testDuplicateMinimums() {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(1);
        Assert.assertEquals(1, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(1, minStack.top());
        Assert.assertEquals(1, minStack.getMin());
    }

    @Test
    public void testNonIncreasingPushes() {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(3);
        minStack.push(3);
        minStack.push(1);
        Assert.assertEquals(1, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(3, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(3, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(5, minStack.getMin());
    }

    @Test
    public void testPushAfterPopRestoresMinTracking() {
        MinStack minStack = new MinStack();
        minStack.push(10);
        minStack.push(5);
        minStack.push(7);
        Assert.assertEquals(5, minStack.getMin());
        minStack.pop();
        minStack.pop();
        Assert.assertEquals(10, minStack.getMin());
        minStack.push(2);
        Assert.assertEquals(2, minStack.getMin());
    }
}
