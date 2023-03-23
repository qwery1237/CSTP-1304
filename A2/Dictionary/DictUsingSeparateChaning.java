package Dictionary;

import Interface.Dictionary;
import Node.Node;

public class DictUsingSeparateChaning implements Dictionary {

  public Node[] aDict;

  public DictUsingSeparateChaning() {
    aDict = new Node[TABLE_SIZE];
  }

  public int getHashIndex(Integer key) {
    return key % TABLE_SIZE;
  }

  public void insert(Integer key, String value) {
    Node tmp = aDict[getHashIndex(key)];

    if (tmp == null) {
      aDict[getHashIndex(key)] = new Node(key, value);
      return;
    }

    while (tmp != null) {
      if (tmp.key == key) {
        tmp.value = value;
        return;
      }
      if (tmp.next == null)
        break;
      tmp = tmp.next;
    }

    tmp.next = new Node(key, value);
  }

  public String get(Integer key) {
    Node tmp = aDict[getHashIndex(key)];

    while (tmp != null) {
      if (tmp.key == key)
        return tmp.value;
      tmp = tmp.next;
    }
    return null;
  }

  public void delete(Integer key) {
    Node tmp = aDict[getHashIndex(key)];

    if (tmp.key == key) {
      if (tmp.next != null) {
        aDict[getHashIndex(key)] = tmp.next;
      } else {
        aDict[getHashIndex(key)] = null;
      }
      tmp = null;
      return;
    }

    while (tmp.next != null) {

      if (tmp.next.key == key) {

        if (tmp.next.next == null) {
          tmp.next = null;
        } else {
          tmp.next = tmp.next.next;
        }
        return;
      }

      tmp = tmp.next;
    }
  }

}