package problems;

import java.util.HashMap;
import java.util.Map;

public class LruCache {

  private final Map<Integer, DNode> map;
  private final int cap;
  private final DNode head, tail;

  public LruCache(int capacity) {
    this.cap = capacity;
    this.map = new HashMap<>();
    this.head = new DNode();
    this.tail = new DNode();
    head.next = tail;
    tail.last = head;
  }

  public int get(int key) {
    DNode node = map.get(key);
    if (node == null) {
      return -1;
    } else {
      updateDLinkList(node);
      return node.val;
    }
  }

  public void put(int key, int value) {
    DNode node = map.get(key);
    if (node == null) {
      node = new DNode();
    }
    node.key = key;
    node.val = value;
    map.put(key, node);
    updateDLinkList(node);
  }

  private void updateDLinkList(DNode recent) {
    if (recent.next != null) {
      // remove it from existing list
      DNode last = recent.last;
      DNode next = recent.next;
      last.next = next;
      next.last = last;
    }

    // insert recent next to head
    DNode second = head.next;
    head.next = recent;
    recent.last = head;
    recent.next = second;
    second.last = recent;

    if (map.size() > cap) {
      // remove the last node
      DNode last = tail.last;
      map.remove(last.key);
      tail.last = last.last;
      last.last.next = tail;
    }
  }
}

class DNode {

  DNode last;
  DNode next;
  int key;
  int val;
}