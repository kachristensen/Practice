package Algorithms;

import java.util.Random;
import java.util.Arrays;

public class Sorting {

  /**
   * "Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list. At each
   * iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted
   * list, and inserts it there. It repeats until no input elements remain. Sorting is typically done in-place, by
   * iterating up the array, growing the sorted list behind it. At each array-position, it checks the value there
   * against the largest value in the sorted list (which happens to be next to it, in the previous array-position
   * checked). If larger, it leaves the element in place and moves to the next. If smaller, it finds the correct
   * position within the sorted list, shifts all the larger values up to make a space, and inserts into that
   * correct position. O(n^2)." - WIKIPEDIA
   */
  private static int[] insertionSort(int[] array) {
    for (int i = 0; i < array.length; i++) { //iterate through the array
      int currentElement = array[i];
      int j = i - 1; //check each element before the current one
      while (j >= 0 && array[j] > currentElement) { //for all elements that are greater than it, shift them one over
        array[j + 1] = array[j];
        j--;
      }
      array[j + 1] = currentElement; //otherwise, stick the current element in the now empty space
    }
    return array;
  }


  /**
   * "Selection sort... has O(n^2) time complexity. The algorithm divides the input list into two parts: the sublist of
   * items already sorted, which is built up from left to right at the front (left) of the list, and the sublist of
   * items remaining to be sorted that occupy the rest of the list. Initially, the sorted sublist is empty and the
   * unsorted sublist is the entire input list. The algorithm proceeds by finding the smallest (or largest, depending
   * on sorting order) element in the unsorted sublist, exchanging (swapping) it with the leftmost unsorted element
   * (putting it in sorted order), and moving the sublist boundaries one element to the right." - WIKIPEDIA
   */
  private static int[] selectionSort(int[] array) {
    for (int i = 0; i < array.length; i++) { //iterate through the array
      int minIndex = i;
      for (int j = i + 1; j < array.length; j++) {//find the minimum element in the unsorted array
        if (array[j] < array[i]) {
          minIndex = j;
        }
      }
      int minElement = array[minIndex]; //swap it with the lowest unsorted position in the array
      array[minIndex] = array[i];
      array[i] = minElement;
    }
    return array;
  }


  /**
   * Runs each sorting method and prints out the time it takes to sort a randomly generated array.
   */
  public static void main(String[] args) {

    int[] array = new Random().ints(10, 1, 10).toArray();
    System.out.println("Original Array: " + Arrays.toString(array));
    int[] sorted = array.clone();
    Arrays.sort(sorted);
    System.out.println("Sorted Array: " + Arrays.toString(sorted) + "\n");

    long startTime = System.nanoTime();
    int[] insertion = insertionSort(array);
    long endTime = System.nanoTime();
    long duration = (endTime - startTime);

    System.out.println(Arrays.equals(insertion, sorted) ? "Insertion Sort: " + duration + " ns"
                           : "Error! Insertion sort failed to sort correctly: " + Arrays.toString(insertion) + "\n");

    startTime = System.nanoTime();
    int[] selection = selectionSort(array);
    endTime = System.nanoTime();
    duration = (endTime - startTime);

    System.out.println(Arrays.equals(selection, sorted) ? "Selection Sort: " + duration + " ns"
                           : "Error! Selection sort failed to sort correctly: " + Arrays.toString(selection));


  }
}
