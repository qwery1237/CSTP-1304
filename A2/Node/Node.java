package Node;

public class Node {
  Integer key;
  String value;
  Node next;

  public Node() {
    key = null;
    value = null;
    next = null;
  }

  public Node(Integer key, String value) {
    this.key = key;
    this.value = value;
    next = null;
  }
}