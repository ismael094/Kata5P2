
package model;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Histogram<T> {
    private final Map<T,Integer> map;
    
    public Histogram() {
        map = new HashMap();
    }
    
    public int get(T key) {
        return map.get(key);
    }
    
    public Set<T> keySet() {
        return map.keySet();
    }
    
    public void increment(T key) {
        if (map.get(key) != null) {
            map.put(key, map.get(key)+1);
        } else {
            map.put(key, 1);
        }
    }
    
}
