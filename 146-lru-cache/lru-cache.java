

public class LRUCache {
    int capacity;
    int current;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        current = 0;
        cache = new HashMap<>();
        head = new KV();
        tail = new KV();
        head.next = tail;
        tail.prev = head;
    }
    KV head;
    KV tail;
    Map<Integer,KV> cache;
    public int get(int key) {
        KV kv = cache.get(key);
        if(kv == null) return -1;
        removeNode(kv);
        addInbetweenHead(kv);
        return kv.value;
    }
    
    public void put(int key, int value) {
       KV kv = cache.get(key);
       if(kv == null) {
           kv = new KV();
           cache.put(key, kv);

           kv.key = key;
           kv.value = value;
           if (current < capacity) {
               current++;
           } else {
               KV torem = tail.prev;
               removeNode(tail.prev);
               cache.remove(torem.key);
           }
           addInbetweenHead(kv);
       } else {
           kv.value = value;
           removeNode(kv);
           addInbetweenHead(kv);
       }
    }

    public void addInbetweenHead(KV kv){
        KV temp = head.next;
        head.next = kv;
        kv.prev = head;
        kv.next = temp;
        temp.prev = kv;
    }

    public void removeNode(KV kv){
        KV prev = kv.prev;
        KV post = kv.next;
        prev.next = post;
        post.prev = prev;
    }
}

class KV{
    int key;
    int value;

    KV next;
    KV prev;
}