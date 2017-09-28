/**
 * Swaps two elements in array
 * @param i1 index of first element to swap
 * @param i2 index of second element to swap
 */
private void swap(int i1, int i2) {
    T obj = backingArray[i1];
    backingArray[i1] = backingArray[i2];
    backingArray[i2] = obj;
}

/**
 * Heapifys element down the heap
 * @param i index of item to heapify
 */
private void downHeap(int i) {
    if (i * 2 <= size) {
        if (i * 2 + 1 > size) {
            if (backingArray[i * 2].compareTo(backingArray[i]) > 0)
                swap(i, i * 2);
        } else {
            boolean childALarger = backingArray[i].compareTo(backingArray[2 * i]) < 0;
            boolean childBLarger = backingArray[i].compareTo(backingArray[2 * i + 1]) < 0;
            if (childALarger && childBLarger) {
                if (backingArray[i * 2].compareTo(backingArray[i * 2 + 1]) > 0) {
                    swap(i, i * 2);
                    downHeap(i * 2);
                } else {
                swap(i, i * 2 + 1);
                downHeap(i * 2 + 1);
                }
            } else if (childALarger) {
                swap(i, 2 * i);
                downHeap(i * 2);
            } else if (childBLarger) {
                swap(i, 2 * i + 1);
                downHeap(i * 2 + 1);
            }
        }
    }
}
