package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Dictionary.DictUsingQuadratingProbing;

public class QTest {
  DictUsingQuadratingProbing aDict = new DictUsingQuadratingProbing();

  @Test
  public void probeTest() {

    // No collision
    aDict.insert(28, "28");
    assertEquals(5, aDict.probe(28));

    // 1 collision
    aDict.delete(28);
    aDict.insert(5, "5");
    aDict.insert(28, "28");
    assertEquals(5 + 1, aDict.probe(28));

    // 2 collisions
    aDict.delete(28);
    aDict.insert(51, "51");
    aDict.insert(28, "28");
    assertEquals(5 + 4, aDict.probe(28));

  }

  @Test
  public void insertTest() {

    assertEquals("", aDict.get(27));

    aDict.insert(27, "new value");

    assertEquals("new value", aDict.get(27));

    aDict.insert(27, "Changed value");

    assertEquals("Changed value", aDict.get(27));

  }

  @Test
  public void getTest() {

    aDict.insert(27, "new value");

    assertEquals("new value", aDict.get(27));
    assertEquals("", aDict.get(29));

    aDict.insert(29, "29");

    assertEquals("29", aDict.get(29));
  }

  @Test
  public void deleteTest() {
    aDict.insert(27, "27");
    assertEquals("27", aDict.get(27));
    aDict.delete(27);
    assertEquals("", aDict.get(27));
  }
}
