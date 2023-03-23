package Node;

public class Node {
  public Integer key;
  public String value;
  public Node next;

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