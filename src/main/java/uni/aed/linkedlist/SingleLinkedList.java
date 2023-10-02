/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.linkedlist;

/**
 *
 * @author mitch
 */
public class SingleLinkedList {
    
    Nodo head;
    
    public static void main(String[] args) {
        SingleLinkedList lista = new SingleLinkedList();
        lista.addLast(10);
        lista.addLast(20);
        lista.addLast(30);
        System.out.println("La lista es: " + lista.toString());
    }
    
    public void addFirst(int data) {
        Nodo newNodo = new Nodo(data);
        newNodo.next = head;
        head = newNodo;
    }
    
    public void addLast(int data) {
        Nodo newNodo = new Nodo(data);
        if (head == null){
            head = newNodo;
            return;
        }
        Nodo current = head;
        while (current.next != null)
            current = current.next;
        current.next = newNodo;
    }
    
    public void remove(int data) {
        if(head == null)
            return;
        if(head.data == data) {
            head = head.next;
            return;
        }
        Nodo current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        
        if (current.next != null)
            current.next = current.next.next;
    }
    
    public String toString() {
        if (head == null)
            return "Lista vacía";

        String lista = "" + head.data + "->";
        Nodo current = head;
        while (current.next != null) {
            lista = lista + current.next.data + "->";
            current = current.next;
        }
        return lista;
    }
   
    public void clear() {
        head = null;
    }
    
    public Nodo getHead(){
        return head;
    }
    
}
