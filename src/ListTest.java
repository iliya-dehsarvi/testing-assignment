import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListTest {

  // ONLY USE THIS FUNCTION TO CONSTRUCT LISTS FOR TESTING...
  public <E> List<E>makeList(E[] array){
    return new ArrayList<E>(Arrays.asList(array));
  }
  
  // model of a list
  // a list is a mapping from a range of natural numbers [0..n] to values.
  // in the model language, we write l_i to refer to the value that the list
  // maps the number 'i' to. This means that we write l_0 to refer to the first
  // element of the list.
  // note that n can be zero, the empty mapping.

  // we say that two values v1 and v2 are equal if v1.equals(v2) and v2.equals(v1).
  // if one of these is true but not the other... we consider this to be a broken
  // program.

  // we say that two values v1 and v2 are pointer-equal if ... well, I think I
  // just have to punt on this, and say "as defined in Java."

  // the length() method:

  // Specification:

  // if a list is a mapping from [0..n] to values, then the length of the
  // list is n+1. 

  // Tests:

  @Test
  public void testLength1() {
    Integer[] ar = {};
    List<Integer> l = makeList(ar);
    assertEquals(0, l.size());
  }

  @Test
  public void testLength2() {
    Integer[] ar = {3,4,5};
    List<Integer> l = makeList(ar);
    assertEquals(3, l.size());
  }

  // the contains method

  // if a list l is a mapping from [0..n] to values, then 
  // contains(l,v) is true exactly when there exists an i
  // such that l_i is equal to v

  @Test
  public void testContains1(){
    String[] ar = {"a","b","c"};
    List<String> l = makeList(ar);
    assertEquals(true,l.contains("b"));
  }

  @Test
  public void testContains2(){
    String[] ar = {"a","b","c"};
    List<String> l = makeList(ar);
    assertEquals(false,l.contains("d"));
  }

  // the get method

  // if a list l is a mapping from [0..n] to values, then
  // get(i) returns l_i if i is an integer in [0..n], and
  // raises the IndexOutOfBounds exception if it is not.

  @Test
  public void testGet1(){
    String[] ar = {"a","b","c"};
    List<String> l = makeList(ar);
    assertEquals("a",l.get(0));
  }

  // check it doesn't always just return the first
  @Test
  public void testGet1b(){
    String[] ar = {"a","b","c"};
    List<String> l = makeList(ar);
    assertEquals("b",l.get(1));
  }

  // actually let's check all three
  @Test
  public void testGet1c(){
    String[] ar = {"a","b","c"};
    List<String> l = makeList(ar);
    assertEquals("c",l.get(2));
  }

  

  @Test
  public void testGet2(){
    String[] ar = {"a","b","c"};
    List<String> l = makeList(ar);
    assertThrows(IndexOutOfBoundsException.class,() -> l.get(14));
  }

  @Test
  public void testGet3(){
    String[] ar = {"a","b","c"};
    List<String> l = makeList(ar);
    assertThrows(IndexOutOfBoundsException.class,() -> l.get(-14));
  }

  // try one right at the upper edge (common mistake)
  @Test
  public void testGet4(){
    String[] ar = {"a","b","c"};
    List<String> l = makeList(ar);
    assertThrows(IndexOutOfBoundsException.class,() -> l.get(3));
  }

// indexof method

// if a list is a mapping from [0..n] to values, then
// indexof(v) should return the smallest i for which
// l_i is equal to v, and -1 if there is no i for which
// l_i is equal to v.

 @Test
 public void testIndexOf1(){
   String[] ar = {"a","b","c"};
   List<String> l = makeList(ar);
   assertEquals(0,l.indexOf("a"));
 }

 @Test
 public void testIndexOf2(){
   String[] ar = {"a","b","c"};
   List<String> l = makeList(ar);
   assertEquals(1,l.indexOf("b"));
 }

 @Test
 public void testIndexOf3(){
   String[] ar = {"a","b","c"};
   List<String> l = makeList(ar);
   assertEquals(2,l.indexOf("c"));
 }

 @Test
 public void testIndexOf4(){
   String[] ar = {"a","b","c"};
   List<String> l = makeList(ar);
   assertEquals(-1,l.indexOf("d"));
 }

 @Test
 public void testIndexOf5(){
  String s1 = "zz";
   String[] ar = {"a",s1,"c",s1};
   List<String> l = makeList(ar);
   assertEquals(1,l.indexOf(s1));
 }



 // the remove method

 // given a list l which maps [0..n] to values,
 // remove(i) mutates l to be a new list l' that
 // maps [0..n-1] to values in the following way:
 // for j < i, l'_j is pointer-equal to l_j. For
 // j >= i, l'_j is pointer-equal to l_j+1. If 
 // i < 0 or i >= n, then remove(i) signals the
 // IndexOutOfBounds exception

 @Test
 public void testRemove1(){
   String[] ar = {"a","b","c","d"};
   List<String> l = makeList(ar);
   l.remove(2);
   assertEquals("a",l.get(0));
   assertEquals("b",l.get(1));
   assertEquals("d",l.get(2));
   assertThrows(IndexOutOfBoundsException.class,() -> l.get(3));
   assertThrows(IndexOutOfBoundsException.class,() -> l.get(-1));
 }
 

}
