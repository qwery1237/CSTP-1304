package Dictionary;

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
    if (aDict[probe(key)] == null)
      return "";
    return aDict[probe(key)].value;
  }

  public void delete(Integer key) {
    aDict[probe(key)] = null;
  }

}