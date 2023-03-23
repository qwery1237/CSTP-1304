package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Dictionary.DictUsingSeparateChaning;

public class STest {
  DictUsingSeparateChaning aDict = new DictUsingSeparateChaning();

  @Test
  public void insertTest() {

    assertEquals(null, aDict.get(27));

    aDict.insert(27, "new value");

    assertEquals("new value", aDict.get(27));

    aDict.insert(27, "Changed value");

    assertEquals("Changed value", aDict.get(27));

    aDict.insert(27 + 23, "50");
    aDict.insert(27 - 23, "4");

    assertEquals("50", aDict.aDict[4].next.value);
    assertEquals("4", aDict.aDict[4].next.next.value);

  }

  @Test
  public void getTest() {

    aDict.insert(27, "27");
    aDict.insert(27 + 23, "50");
    aDict.insert(27 - 23, "4");

    assertEquals("27", aDict.get(27));
    assertEquals(null, aDict.get(29));

    aDict.insert(29, "29");

    assertEquals("50", aDict.get(50));
    assertEquals("4", aDict.get(4));
  }

  @Test
  public void deleteTest() {
    aDict.insert(27, "27");
    aDict.insert(27 + 23, "50");
    aDict.insert(27 - 23, "4");

    aDict.delete(27);
    assertEquals("50", aDict.aDict[4].value);
    assertEquals("4", aDict.aDict[4].next.value);

    aDict.delete(4);
    assertEquals(null, aDict.aDict[4].next);
  }
}
