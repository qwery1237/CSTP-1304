public class QuickSort {
  Integer[] arr;

  QuickSort(Integer[] arr) {
    this.arr = arr;
  }

  void quickSortRecursive(int start, int end) {

    if (start >= end)
      return;

    int pivotIndex = sort(start, end);

    quickSortRecursive(start, pivotIndex - 1);
    quickSortRecursive(pivotIndex + 1, end);
  }

  void quickSort() {
    quickSortRecursive(0, arr.length - 1);
  }

  int sort(int start, int end) {

    int pivotIndex = end;

    for (int i = end - 1; i >= start; i--) {
      if (arr[end] < arr[i]) {
        swap(--pivotIndex, i);
      }
    }

    swap(end, pivotIndex);

    return pivotIndex;
  }

  void swap(int a, int b) {
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }

  void print() {
    int i = 0;
    for (var el : arr) {
      if (el != null)
        System.out.println("arr[" + i++ + "] = " + el);
    }
  }

  public static void main(String[] args) {
    Integer[] x = { 2, 44, 3, 67, 8, 1 };
    QuickSort arr = new QuickSort(x);
    arr.quickSort();
    arr.print();
  }
}
