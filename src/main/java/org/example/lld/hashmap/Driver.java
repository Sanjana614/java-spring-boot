package org.example.lld.hashmap;

public class Driver {
    public static void main(String[] args) {
        MyMap<String, String> map = new MyHashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", null);
        map.put(null, null);
        String v1 = map.get("key2");
        String v2 = map.get("key5");
        String v3 = map.get("key6");
        map.remove("key2");
        String v4 = map.get("key2");
        System.out.println("v1: " + v1);
        System.out.println("v2: " + v2);
        System.out.println("v3: " + v3);
        System.out.println("v4: " + v4);
        String v5 = map.get(null);
        System.out.println("v5: " + v5);

    }
}
