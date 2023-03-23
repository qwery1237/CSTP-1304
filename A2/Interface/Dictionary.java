package Interface;

public interface Dictionary {

  int TABLE_SIZE = 23;

  public int getHashIndex(Integer key);

  public int getSize();

  public boolean isEmpty();

  public void insert(Integer key, String value);

  public String get(Integer key);

  public void delete(Integer key);
}