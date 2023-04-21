import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Java标准库中没有提供LRU缓存的实现，但是可以使用Java集合框架中的LinkedHashMap来实现LRU缓存。
 * LinkedHashMap是HashMap的一个子类，它会保留插入顺序或者访问顺序（即最近访问的元素在最前面）。
 * 可以通过重写LinkedHashMap的removeEldestEntry方法来控制缓存的大小。
 * 当缓存大小超过预设的阈值时，removeEldestEntry方法会返回true，此时需要删除最久未被访问的元素。
 *
 * @param <K>
 * @param <V>
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}
