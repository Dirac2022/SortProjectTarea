/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.gui.heap;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author mitch
 */
public class Heap {

    ArrayList<Position<Integer>> position = new ArrayList<>();
    LinkedPositionalList<Integer> heap;
    Integer[] sortedList;

    public void initialize(Integer[] data) {
        heap = new LinkedPositionalList<>();
        sortedList = new Integer[data.length];

        for (int i = 0; i < data.length; i++)
            position.add(heap.addLast(data[i]));
        System.out.println("Este es el heap: " + heap);
        System.out.println("Tanaño del heap: " + heap.size());
        System.out.println("Tamaño del arreglo de posiciones: " + position.size());
    }

    public Integer[] sort() {
        build();
        System.out.println("Hemos construido el heap, lo mostramos a continuación: " + heap.toString());
        extract();
        return sortedList;
    }

    private void build() {
        Position<Integer> actual, indiceHijoMayor;
        boolean hecho;

        for (int i = (heap.size() - 2) / 2; i >= 0; i--) {
            actual = position.get(i); // actual = pos1
            hecho = false;

            while (!hecho) {
                if (2 * position.indexOf(actual) + 1 > heap.size() - 1)
                    hecho = true;
                else {
                    indiceHijoMayor = maxChild(actual, position.get(heap.size() - 1));
                    // = maxChild(pos1, pos3)
                    if (heap.get(actual) < heap.get(indiceHijoMayor)) {
                        swap(actual, indiceHijoMayor);
                        actual = indiceHijoMayor;
                    } else
                        hecho = true;
                }
            }

            assert esHeapValido(heap, i, heap.size() - 1)
                    : "Error: La fase de construcción no esta funcionando correctamente";
        }

        pruebaImpresion(heap.size());
    }

    private boolean esHeapValido(LinkedPositionalList<Integer> heap, int inicio, int fin) {

        for (int i = inicio; i < fin / 2; i++) {
            Position<Integer> posi = position.get(i);
            Position<Integer> posiLeft = position.get(2 * i + 1);
            Position<Integer> posiRight = position.get(2 * i + 2);
            if (heap.get(posi) < Math.max(heap.get(posiLeft), heap.get(posiRight)))
                return false;
        }
        return true;
    }

    private void extract() {
        Position<Integer> actual, indiceHijoMayor;
        boolean hecho;

        for (int tamanio = heap.size() - 1; tamanio >= 0; tamanio--) {
            sortedList[tamanio] = heap.get(position.get(0));
            Integer element = heap.get(position.get(tamanio));
            heap.set(position.get(0), element);

            actual = position.get(0);
            hecho = false;

            while (!hecho) {
                if (2 * position.indexOf(actual) + 1 > tamanio)
                    hecho = true;
                else {
                    indiceHijoMayor = maxChild(actual, position.get(tamanio));

                    if (heap.get(actual) < heap.get(indiceHijoMayor)) {
                        swap(actual, indiceHijoMayor);
                        actual = indiceHijoMayor;
                    } else
                        hecho = true;
                }
            }

            assert esHeapValido(heap, tamanio, heap.size() - 1)
                    : "Error, la fase de construcción no esta funcionando correctamente";
            pruebaImpresion(tamanio);
        }
    }

    // maxChild(pos1, pos3)
    public Position<Integer> maxChild(Position<Integer> posicion, Position<Integer> fin) {
        // posicion es pos1
        Position<Integer> resultado, indiceHijoDerecho;
        Position<Integer> indiceHijoIzquierdo = position.get(2 * position.indexOf(posicion) + 1);
        try {
            indiceHijoDerecho = position.get(2 * position.indexOf(posicion) + 2);
        } catch (IndexOutOfBoundsException e) {
            indiceHijoDerecho = indiceHijoIzquierdo;
        }
        assert position.indexOf(indiceHijoIzquierdo) <= position.indexOf(fin)
                : "Error: el nodo en posicion " + posicion + " no tiene hijos";

        if (position.indexOf(indiceHijoDerecho) <= position.indexOf(fin)
                && heap.get(indiceHijoIzquierdo) < heap.get(indiceHijoDerecho))
            resultado = indiceHijoDerecho;
        else
            resultado = indiceHijoIzquierdo;

        return resultado;
    }

    public void swap(Position<Integer> a, Position<Integer> b) {
        Integer elementA = heap.get(a);
        Integer elementB = heap.get(b);
        heap.set(a, elementB);
        heap.set(b, elementA);
        elementA = null;
        elementB = null;
    }

    public String toString() {
        return heap.toString();
    }

    private void pruebaImpresion(int limite) {
        for (int i = 0; i < limite; i++) {
            Position<Integer> posi = position.get(i);
            System.out.print(" " + heap.get(posi));
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Integer[] nums = { 10, 7, 8, 5, 4, 1, 2, 3, 6, 9 };
        Integer[] sortedList;

        Heap heap = new Heap();

        heap.initialize(nums);
        sortedList = heap.sort();

        System.out.println("Lista ordenada: " + Arrays.deepToString(sortedList));

    }

}

