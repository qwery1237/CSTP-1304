import java.util.Arrays;

public class MergeSortRecursive {
  Integer[] arr;

  MergeSortRecursive(Integer[] arr) {
    this.arr = arr;
  }

  Integer[] sort(Integer[] arr) {
    if (arr.length <= 1) {
      return arr;
    }

    int middle = arr.length / 2;
    Integer[] left = Arrays.copyOfRange(arr, 0, middle);
    Integer[] right = Arrays.copyOfRange(arr, middle, arr.length);

    left = sort(left);
    right = sort(right);

    return merge(left, right);

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
    arr = sort(arr);
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
    MergeSortRecursive arr = new MergeSortRecursive(x);

    arr.mergeSort();
    arr.print(arr.arr);
  }

}