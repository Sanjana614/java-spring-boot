package org.example.lld.lrucache;

public class LRUCacheDemo {
    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>(3);

        cache.put("a", 1);
        cache.put("b", 2);
        cache.put("c", 3);

        System.out.println(cache.get("a")); // ✅ 1  (a is accessed, so it becomes most recently used)

        cache.put("d", 4); // ❌ "b" gets evicted (least recently used)

        System.out.println(cache.get("b")); // ✅ null (b was evicted)
        System.out.println(cache.get("c")); // ✅ 3   (c is still there)
        System.out.println(cache.get("d")); // ✅ 4   (d was just inserted)
        System.out.println(cache.get("a")); // ✅ 1   (a is still present because it was recently used)

        // Add more
        cache.put("e", 5); // ❌ "c" will be evicted now (LRU among [c, d, a])

        System.out.println(cache.get("c")); // ✅ null (c was evicted)
        System.out.println(cache.get("d")); // ✅ 4   (still present)
        System.out.println(cache.get("a")); // ✅ 1   (still present)
        System.out.println(cache.get("e")); // ✅ 5   (just inserted)

        // Overwriting a value
        cache.put("a", 10); // "a" updated

        System.out.println(cache.get("a")); // ✅ 10  (updated value)

        // Force another eviction
        cache.put("f", 6); // ❌ "d" evicted (LRU among [d, e, a])

        System.out.println(cache.get("d")); // ✅ null (evicted)
        System.out.println(cache.get("e")); // ✅ 5
        System.out.println(cache.get("a")); // ✅ 10
        System.out.println(cache.get("f")); // ✅ 6
    }
}
