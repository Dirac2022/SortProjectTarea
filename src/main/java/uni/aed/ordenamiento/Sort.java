/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.ordenamiento;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author mitch
 */
public class Sort {
    
    
    private static <T> void merge(T[] S1, T[] S2, T[] S, Comparator<T> comp){
        int i = 0, j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0))
                S[i+j] = S1[i ++];
            else
                S[i+j] = S2[j ++];
        }
    }
    
    
    public static <T> void mergeSort(T[] S, Comparator<T> comp) {
        int n = S.length;
        if (n < 2)
            return;
        int mid = n / 2;
        T[] S1 = Arrays.copyOfRange(S, 0, mid);
        T[] S2 = Arrays.copyOfRange(S, mid, n);
        mergeSort(S1, comp);
        mergeSort(S2, comp);
        merge(S1, S2, S, comp);
    }
    
}
