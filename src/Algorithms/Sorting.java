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
  private static int[] InsertionSort(int[] array) {
    for (int i = 0; i < array.length; i++) { //iterate through the list
      int currentElement = array[i];
      int j = i-1; //check each element before the current one
      while (j >= 0 && array[j] > currentElement) { //for all elements that are greater than it, shift them one over
        array[j+1] = array[j];
        j--;
      }
      array[j+1] = currentElement; //otherwise, stick the current element in the now empty space
    }

    return array;
  }

  public static void main(String[] args) {

    int[] array = new Random().ints(10, 1, 10).toArray();
    System.out.println("Original Array: " + Arrays.toString(array));
    int[] sorted = array.clone();
    Arrays.sort(sorted);
    System.out.println("Sorted Array: " + Arrays.toString(sorted) + "\n");

    long startTime = System.nanoTime();
    int[] insertion = InsertionSort(array);
    long endTime = System.nanoTime();
    long duration = (endTime - startTime);

    System.out.println(Arrays.equals(insertion, sorted) ? "Insertion Sort: " + duration + " ns"
                           : "Error! Insertion sort failed to sort correctly: " + Arrays.toString(insertion));


  }
}
