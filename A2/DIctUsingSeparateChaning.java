import Interface.Dictionary;
import Node.Node;

public class DIctUsingSeparateChaning implements Dictionary {

  private Node[] aDict;

  public DIctUsingSeparateChaning() {
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

    while (tmp.next != null) {
      if (tmp.key == key) {
        tmp.value = value;
        return;
      }
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

  public static void main(String[] args) {
    DIctUsingSeparateChaning aDict = new DIctUsingSeparateChaning();
    aDict.insert(29, "29");
    aDict.insert(32, "32");
    aDict.insert(58, "58");
    aDict.insert(21, "21");
    aDict.insert(81, "81");
    aDict.insert(35, "35");
    aDict.insert(60, "60");
    aDict.insert(12, "12");
    aDict.delete(81);
    // aDict.delete(35);
    // aDict.print();
    System.out.println(aDict.get(35));
  }
}