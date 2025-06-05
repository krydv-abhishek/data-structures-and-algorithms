package org.abhishek.heap;

class MinHeap {

    private int[] array;
    private int currentPosition;
    private int size;

    public MinHeap(int n) {
        array = new int[n];
        currentPosition = 0;
        size = n;
    }

    private void swap(int m, int n) {
        int temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }

    private int parent(int position) {
        return position / 2;
    }

    private int leftChild(int position) {
        return 2 * position;
    }

    private int rightChild(int position) {
        return 2 * position + 1;
    }

    //insert - O(logN)
    public boolean insertKey(int key) {
        if (currentPosition == size) {
            System.out.println("Heap is full");
            return false;
        }

        int i = currentPosition;
        array[currentPosition++] = key;

        while (i > 0 && array[i] < array[parent(i)]) {
            swap(i, parent(i));
            i = parent(i);
        }
        return true;
    }

    private void minHeapify(int key) {

        int left = leftChild(key);
        int right = rightChild(key);

        int smallest = key;

        if(left<currentPosition && array[left] < array[smallest]) {
            smallest = left;
        }
        if(right<currentPosition && array[right] < array[smallest]) {
            smallest = right;
        }

        if(smallest!=key) {
            swap(key, smallest);
            minHeapify(smallest);
        }

    }

    //get min - O(1)
    public int  getMin() {
        return array[0];
    }

    //delete top element - O(logN)
    public int extractMin() {

        if(currentPosition<=0) {
            System.out.println("Heap is empty");
            return Integer.MAX_VALUE;
        }
        if(currentPosition==1) {
            currentPosition--;
            return array[0];
        }

        int root = array[0];

        array[0] = array[currentPosition-1];
        currentPosition--;
        minHeapify(0);
        return root;
    }

    public void decreaseKey(int key, int newVal) {
        array[key] = newVal;

        while(key>0 && array[key] < array[parent(key)]) {
            swap(key, parent(key));
            key = parent(key);
        }
    }

    public void deleteKey(int key) {
        decreaseKey(key, Integer.MIN_VALUE);
        extractMin();
    }

    public void increaseKey(int key, int newVal) {
        array[key] = newVal;
        minHeapify(key);
    }

    public void changeValueOnAKey(int key, int newVal) {
        if (array[key] == newVal) {
            return;
        }
        if (array[key] < newVal) {
            increaseKey(key, newVal);
        } else {
            decreaseKey(key, newVal);
        }
    }
}

class MaxHeap {

    private int[] array;
    private int currentPosition;
    private int size;

    public MaxHeap(int n) {
        array = new int[n];
        currentPosition = 0;
        size = n;
    }

    private void swap(int m, int n) {
        int temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }

    private int parent(int position) {
        return position / 2;
    }

    private int leftChild(int position) {
        return 2 * position;
    }

    private int rightChild(int position) {
        return 2 * position + 1;
    }

    //insert - O(logN)
    public boolean insertKey(int key) {
        if (currentPosition == size) {
            System.out.println("Heap is full");
            return false;
        }

        int i = currentPosition;
        array[currentPosition++] = key;

        while (i > 0 && array[i] > array[parent(i)]) {
            swap(i, parent(i));
            i = parent(i);
        }
        return true;
    }

    private void maxHeapify(int key) {

        int left = leftChild(key);
        int right = rightChild(key);

        int largest = key;

        if(left<currentPosition && array[left] > array[largest]) {
            largest = left;
        }
        if(right<currentPosition && array[right] > array[largest]) {
            largest = right;
        }

        if(largest!=key) {
            swap(key, largest);
            maxHeapify(largest);
        }

    }

    //get min - O(1)
    public int  getMax() {
        return array[0];
    }

    //delete top element - O(logN)
    public int extractMax() {

        if(currentPosition<=0) {
            System.out.println("Heap is empty");
            return Integer.MAX_VALUE;
        }
        if(currentPosition==1) {
            currentPosition--;
            return array[0];
        }

        int root = array[0];

        array[0] = array[currentPosition-1];
        currentPosition--;
        maxHeapify(0);
        return root;
    }

    public void decreaseKey(int key, int newVal) {
        array[key] = newVal;

        while(key>0 && array[key] > array[parent(key)]) {
            swap(key, parent(key));
            key = parent(key);
        }
    }

    public void deleteKey(int key) {
        decreaseKey(key, Integer.MAX_VALUE);
        extractMax();
    }

    public void increaseKey(int key, int newVal) {
        array[key] = newVal;
        maxHeapify(key);
    }

    public void changeValueOnAKey(int key, int newVal) {
        if (array[key] == newVal) {
            return;
        }
        if (array[key] < newVal) {
            increaseKey(key, newVal);
        } else {
            decreaseKey(key, newVal);
        }
    }
}

public class StandardHeap {

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(5);
        minHeap.insertKey(5);
        minHeap.insertKey(3);
        minHeap.insertKey(2);
        minHeap.insertKey(7);
        minHeap.insertKey(9);
        minHeap.insertKey(1);
        System.out.println(minHeap.getMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.getMin());
        minHeap.insertKey(1);
        System.out.println(minHeap.getMin());

        System.out.println(" ");
        System.out.println("Max Heap");

        MaxHeap maxHeap = new MaxHeap(5);
        maxHeap.insertKey(5);
        maxHeap.insertKey(3);
        maxHeap.insertKey(2);
        maxHeap.insertKey(7);
        maxHeap.insertKey(9);
        maxHeap.insertKey(1);
        System.out.println(maxHeap.getMax());
        System.out.println(maxHeap.extractMax());
        System.out.println(maxHeap.getMax());
        maxHeap.insertKey(10);
        System.out.println(maxHeap.getMax());

    }
}
