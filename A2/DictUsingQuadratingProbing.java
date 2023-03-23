import Interface.Dictionary;
import Node.Node;

public class DictUsingQuadratingProbing implements Dictionary {

  private Node[] aDict;

  public DictUsingQuadratingProbing() {
    aDict = new Node[TABLE_SIZE];
  }

  public int getHashIndex(Integer key) {
    return key % TABLE_SIZE;
  }

  public int probe(Integer key) {
    int index = getHashIndex(key);
    int i = 0;

    while (aDict[index] != null) {

      if (aDict[index].key == key) {
        break;
      }

      index = (getHashIndex(key) + (++i * i)) % TABLE_SIZE;
    }
    return index;
  }

  public void insert(Integer key, String value) {
    aDict[probe(key)] = new Node(key, value);
  }

  public String get(Integer key) {
    return aDict[probe(key)].value;
  }

  public void delete(Integer key) {
    aDict[probe(key)] = null;
  }

  // void print() {
  // int i = 0;
  // for (Node node : aDict) {
  // if (node == null) {
  // System.out.println(i++ + "Key : null, value : null");
  // continue;
  // }
  // System.out.println(i++ + "key: " + node.key + " val: " + node.value);
  // }
  // }

  public static void main(String[] args) {
    DictUsingQuadratingProbing aDict = new DictUsingQuadratingProbing();
    aDict.insert(29, "29");
    aDict.insert(32, "32");
    aDict.insert(58, "58");
    aDict.insert(21, "21");
    aDict.insert(81, "81");
    aDict.insert(35, "35");
    aDict.insert(60, "60");
    aDict.insert(12, "12");
    aDict.delete(21);
    aDict.insert(35, "359");
    // aDict.print();
    System.out.println(aDict.get(35));
  }
}