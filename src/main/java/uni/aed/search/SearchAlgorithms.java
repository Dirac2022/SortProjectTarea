/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.search;

/**
 *
 * @author mitch
 */
public class SearchAlgorithms {
    
    public <T extends Comparable<T>> int binarySearch(T[] arr, T target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            
            int mid = (left + right) / 2;
            int comparison = arr[mid].compareTo(target);
            
            if (comparison == 0)
                return mid;
            if (comparison < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
    
    public <T> int linearSearch(T[] arr, T target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i].equals(target))
                return i;
        return -1;
    }
        
}
