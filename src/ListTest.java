import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Java List Model
// A list is an arrangement of objects that follows a set of rules:
// • New elements can be added to the list
// • Each element in the list is associated with an index
// • Each element in the list can be accessed by their index
// • Each element in the list can be removed by their index
// • size = number of objects in the list
// • 0 <= index < size

public class ListTest {
  // ONLY USE THIS FUNCTION TO CONSTRUCT LISTS FOR TESTING...
  public <E> List<E>makeList(E[] array){
    return new ArrayList<E>(Arrays.asList(array));
  }

  // the add() method:

  // Specification:
  // The add method traverses the list until it reaches
  // the passed index and inserts the new element at that
  // index, if the index passed is more than or equal to
  // the size of the list the IndexOutOfBounds exception
  // will be raised.

  // Tests:
  @Test
  public void testAdd() {
    Integer[] ar = {};
    List<Integer> l = makeList(ar);
    l.add(0, 1);
    assertEquals(1, l.get(0));
  }

  @Test
  public void testAddExistingIndex() {
    Integer[] ar = {2};
    List<Integer> l = makeList(ar);
    l.add(0, 1);
    assertEquals(1, l.get(0));
  }

  @Test
  public void testAddLastIndex() {
    Integer[] ar = {2};
    List<Integer> l = makeList(ar);
    l.add(1, 1);
    assertEquals(1, l.get(1));
  }

  @Test
  public void testAddOutOfBoundsIndex() {
    Integer[] ar = {2};
    List<Integer> l = makeList(ar);
    try {
      l.add(3, 1);
    } catch (IndexOutOfBoundsException e) {
      assertEquals(e.getMessage(), "Index: 3, Size: 1");
    }
  }

  // the contains() method:

  // Specification:
  // The contains method traverses the list and returns true
  // if it reaches an object that is equals to the object passed
  // returns false otherwise.

  // Tests:
  @Test
  public void testContains() {
    Integer[] ar = {1, 2, 3};
    List<Integer> l = makeList(ar);
    assertTrue(l.contains(2));
  }

  @Test
  public void testDoesNotContain() {
    Integer[] ar = {1, 2, 3};
    List<Integer> l = makeList(ar);
    assertFalse(l.contains(4));
  }

  @Test
  public void testDoesNotContainEmptyList() {
    Integer[] ar = {};
    List<Integer> l = makeList(ar);
    assertFalse(l.contains(4));
  }


  // the get() method:

  // Specification:
  // The get method returns the object at the index
  // passed. If the index passed is equals to or more than the
  // size of the list it raises IndexOutOfBounds exception.

  // Tests:
  @Test
  public void testGet() {
    Integer[] ar = {1, 2, 3, 4};
    List<Integer> l = makeList(ar);
    assertEquals(3, l.get(2));
  }

  @Test
  public void testOutOfBounds() {
    Integer[] ar = {1, 2, 3, 4};
    List<Integer> l = makeList(ar);
    try {
      l.get(4);
    } catch (IndexOutOfBoundsException e) {
      assertEquals(e.getMessage(), "Index 4 out of bounds for length 4");
    }
  }

  @Test
  public void testGetEmptyList() {
    Integer[] ar = {};
    List<Integer> l = makeList(ar);
    try {
      l.get(-1);
    } catch (IndexOutOfBoundsException e) {
      assertEquals(e.getMessage(), "Index -1 out of bounds for length 0");
    }
  }


  // the indexOf() method:

  // Specification:
  // The indexOf method traverses the list until it reaches
  // the first occurrence of the passed object and returns
  // the corresponding index. If the element is not in the
  // list it returns -1.

  // Tests:
  @Test
  public void testIndexOf() {
    Integer[] ar = {1, 2, 3, 4};
    List<Integer> l = makeList(ar);
    assertEquals(1, l.indexOf(2));
  }

  @Test
  public void testIndexOfRepeated() {
    Integer[] ar = {1, 2, 3, 2};
    List<Integer> l = makeList(ar);
    assertEquals(1, l.indexOf(2));
  }

  @Test
  public void testIndexOfNoneExisting() {
    Integer[] ar = {1, 2, 3, 2};
    List<Integer> l = makeList(ar);
    assertEquals(-1, l.indexOf(4));
  }


  // the remove() method:

  // Specification:
  // The remove method removes the object at the passed
  // index and returns that object. After this operation
  // the index of all elements after the deleted one will
  // decrease by one. If the index is more than or equal to
  // the size of the list IndexOutOfBounds exception will be
  // raised.

  // Tests:
  @Test
  public void testRemove() {
    Integer[] ar = {1, 2, 3, 2};
    List<Integer> l = makeList(ar);
    int removed = l.remove(0);
    assertEquals(1, removed);
  }

  @Test
  public void testRemoveOutboundsIndex() {
    Integer[] ar = {1, 2, 3, 2};
    List<Integer> l = makeList(ar);
    try {
      l.remove(5);
    } catch (IndexOutOfBoundsException e) {
      assertEquals(e.getMessage(), "Index 5 out of bounds for length 4");
    }
  }


  // the size() method:

  // Specification:
  // This method returns the number of elements in the list.

  // Tests:
  @Test
  public void testSize() {
    Integer[] ar = {1, 2, 3, 2};
    List<Integer> l = makeList(ar);
    assertEquals(4, l.size());
  }

  @Test
  public void testSizeEmpty() {
    Integer[] ar = {};
    List<Integer> l = makeList(ar);
    assertEquals(0, l.size());
  }


  // the subList() method:

  // Specification:
  // The subList method returns a new list with
  // all elements starting from the ith index and
  // ending before the i1th index. Where 0 <= i <= i1 < size
  // and the indexes are out of bounds the IndexOutOfBounds
  // exception will be raised.

  // Tests:
  @Test
  public void testSublist() {
    Integer[] ar = {1, 2, 3, 4, 5};
    Integer[] ar2 = {2, 3, 4};
    List<Integer> l = makeList(ar);
    List<Integer> expected = makeList(ar2);
    assertEquals(expected, l.subList(1, 4));
  }

  @Test
  public void testSublistDropLast2() {
    Integer[] ar = {1, 2, 3, 4, 5};
    Integer[] ar2 = {1, 2, 3};
    List<Integer> l = makeList(ar);
    List<Integer> expected = makeList(ar2);
    assertEquals(expected, l.subList(0, 3));
  }

  @Test
  public void testSublistGetIndex3() {
    Integer[] ar = {1, 2, 3, 4, 5};
    Integer[] ar2 = {4};
    List<Integer> l = makeList(ar);
    List<Integer> expected = makeList(ar2);
    assertEquals(expected, l.subList(3, 4));
  }

  @Test
  public void testSublistEmptyListOutBounds() {
    Integer[] ar = {};
    List<Integer> l = makeList(ar);
    try {
      l.subList(0, 1);
    } catch (IndexOutOfBoundsException e) {
      assertEquals(e.getMessage(), "toIndex = 1");
    }
  }
}