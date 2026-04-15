package neetcode.lruCache;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.neetcode.lruCache.LRUCache;

/**
 * Tests for {@link LRUCache} — least recently used cache ({@code get} / {@code put} in average O(1)}).
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class LRUCacheTest {

    /** Example 1 from problem statement (constructor + sequence of operations). */
    @Test
    public void testExample1() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 10);
        Assert.assertEquals(10, cache.get(1));
        cache.put(2, 20);
        cache.put(3, 30);
        Assert.assertEquals(20, cache.get(2));
        Assert.assertEquals(-1, cache.get(1));
    }

    @Test
    public void testGetMissingReturnsMinusOne() {
        LRUCache cache = new LRUCache(10);
        Assert.assertEquals(-1, cache.get(42));
    }

    @Test
    public void testPutOverwritesValueWithoutEvictingSameKey() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 100);
        cache.put(1, 200);
        Assert.assertEquals(200, cache.get(1));
        cache.put(2, 20);
        cache.put(3, 30);
        Assert.assertEquals(-1, cache.get(1));
        Assert.assertEquals(20, cache.get(2));
        Assert.assertEquals(30, cache.get(3));
    }

    /**
     * After {@code get(key)}, that key becomes most recently used; next eviction spares it if another key is LRU.
     */
    @Test
    public void testGetRefreshesRecency() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 10);
        cache.put(2, 20);
        Assert.assertEquals(10, cache.get(1));
        cache.put(3, 30);
        Assert.assertEquals(-1, cache.get(2));
        Assert.assertEquals(10, cache.get(1));
        Assert.assertEquals(30, cache.get(3));
    }

    @Test
    public void testCapacityOne() {
        LRUCache cache = new LRUCache(1);
        cache.put(1, 10);
        cache.put(2, 20);
        Assert.assertEquals(-1, cache.get(1));
        Assert.assertEquals(20, cache.get(2));
    }

    @Test
    public void testPutEvictsLeastRecentlyUsed() {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        Assert.assertEquals(-1, cache.get(1));
        Assert.assertEquals(2, cache.get(2));
        Assert.assertEquals(3, cache.get(3));
        Assert.assertEquals(4, cache.get(4));
    }

    @DataProvider
    public static Object[][] provideCapacityBoundaries() {
        return new Object[][] {
                {1},
                {2},
                {100},
        };
    }

    @Test
    @UseDataProvider("provideCapacityBoundaries")
    public void testFreshCacheGetAlwaysMinusOne(int capacity) {
        LRUCache cache = new LRUCache(capacity);
        Assert.assertEquals(-1, cache.get(0));
        Assert.assertEquals(-1, cache.get(1000));
    }
}
