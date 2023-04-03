
class HeapSort {
  Integer[] arr;
  int lastIndex;

  HeapSort() {
    arr = new Integer[100];
    lastIndex = -1;
    for (Integer el : new Integer[] { 89, 29, 23, 36, 48, 94, 13, 27, 70, 76, 37, 42, 58 }) {
      arr[++lastIndex] = el;
    }
  }

  void insert(int el) {

    arr[++lastIndex] = el;
    bubbleUp(lastIndex);
  }

  void remove() {
    arr[0] = arr[lastIndex];
    arr[lastIndex--] = null;
    bubbleDown(0);
  }

  void bubbleDown(int index) {

    int indexOfLeftChild = 2 * index + 1;
    int indexOfRightChild = indexOfLeftChild + 1;

    if (indexOfLeftChild > lastIndex)
      return;

    if (indexOfLeftChild == lastIndex) {
      if (arr[index] < arr[indexOfLeftChild])
        swap(indexOfLeftChild, index);
      return;
    }

    if (arr[index] > arr[indexOfLeftChild] && arr[index] > arr[indexOfRightChild])
      return;

    if (arr[indexOfLeftChild] > arr[indexOfRightChild]) {
      swap(indexOfLeftChild, index);
      bubbleDown(indexOfLeftChild);
    } else {
      swap(indexOfRightChild, index);
      bubbleDown(indexOfRightChild);
    }
  }

  void bubbleUp(int index) {
    int parentIndex = (index - 1) / 2;
    if (arr[parentIndex] < arr[index]) {
      swap(parentIndex, index);
      if (parentIndex == 0)
        return;
      bubbleUp(parentIndex);
    }
  }

  void swap(int a, int b) {
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }

  void heapSort() {
    for (int i = arr.length - 1; i >= 0; i--) {
      bubbleDown(i);
    }
  }

  void print() {
    int i = 0;
    for (var el : arr) {
      if (el != null)
        System.out.println("arr[" + i++ + "] = " + el);
    }
  }

  public static void main(String[] args) {
    HeapSort aHeap = new HeapSort();
    aHeap.print();
    aHeap.heapSort();
    aHeap.print();
  }
}