import java.util.LinkedList;
import java.util.Queue;

public class MergeSortIterative {
  Integer[] arr;

  MergeSortIterative(Integer[] arr) {
    this.arr = arr;
  }

  Integer[] merge(Integer[] arr1, Integer[] arr2) {
    Integer[] result = new Integer[arr1.length + arr2.length];

    int resultIndex = 0;
    int arr1Index = 0;
    int arr2Index = 0;

    while (resultIndex < result.length) {
      if (arr1Index >= arr1.length) {
        result[resultIndex++] = arr2[arr2Index++];
        continue;
      }

      if (arr2Index >= arr2.length) {
        result[resultIndex++] = arr1[arr1Index++];
        continue;
      }

      if (arr1[arr1Index] < arr2[arr2Index]) {
        result[resultIndex++] = arr1[arr1Index++];
      } else {
        result[resultIndex++] = arr2[arr2Index++];
      }
    }

    return result;
  }

  void mergeSort() {
    Queue<Integer[]> aQueue = new LinkedList<>();

    for (int i = 0; i < arr.length; i++) {
      aQueue.add(new Integer[] { arr[i] });
    }

    while (!aQueue.isEmpty()) {
      Integer[] arr1 = aQueue.remove();
      Integer[] arr2 = aQueue.remove();

      Integer[] sorted = merge(arr1, arr2);

      if (sorted.length == arr.length) {
        arr = sorted;
        return;
      }
      aQueue.add(sorted);
    }
  }

  void print(Integer[] arr) {
    int i = 0;
    for (var el : arr) {
      if (el == null)
        System.out.println("null");
      if (el != null)
        System.out.println("arr[" + i++ + "] = " + el);
    }
  }

  public static void main(String[] args) {
    Integer[] x = { 2, 44, 3, 67, 8, 1 };
    MergeSortIterative arr = new MergeSortIterative(x);

    arr.mergeSort();
    arr.print(arr.arr);
  }

}