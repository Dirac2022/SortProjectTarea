/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.doublelinkedlist;

import uni.aed.linkedlist.Nodo;

/**
 *
 * @author mitch
 */
public class DoubleLinkedList {
    
    Node head;
    Node tail;
    
    public static void main(String[] args) {
        
        DoubleLinkedList list = new DoubleLinkedList();
        
        list.addLast(1);
        list.addLast(5);
        list.addLast(8);
        list.addFirt(80);
        System.out.println(list);
        list.remove(5);
        System.out.println("Despues de remover un elemento");
        System.out.println(list);
    }
    
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (tail == null){
            head = tail = newNode;
            return;
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = tail.next;
        }
    }
    
    public void addFirt(int data) {
        Node newNode = new Node(data);
        if (head == null){
            head = tail = newNode;
            return;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            
        }
    }
    
    public void remove(int data) {
        
        Node node = new Node(data);
        
        if(head == null)
            return;
        
        if(head.data == data) {
            head = head.next;
            return;
        }
        
        if (tail.data == data){
            tail = tail.prev;
            tail.next = null;
            return ;
        }
        
        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }
        
        System.out.println("Se encontro current : " + current.data);
        if (current.data == data){
            System.out.println("Entramos al if");
            Node prev = current.prev;
            Node next = current.next;
            current.prev.next = next;
            System.out.println("current.prev: " + current.prev.data);
            current.next.prev = prev;
            System.out.println("current.next: " + current.next.data);
        }
            
            
    }
    
    public String toString2() {
        Node current = head;
        String strList = "";
        while (current != null) {
            strList += "->"  + current.data;
            current = current.next;
        }
        
        return strList;
    }
    
    public String toString() {
        Node current = head;
        String strList = "";
        while (current != null) {
            if (current.prev == null)
                strList = "null <-" + current.data + " -> " + current.next.data;
            else if (current.next == null)
                strList = strList + "||" + current.prev.data + "<-" + current.data + "-> null";
            else
                strList = strList + "||" + current.prev.data + "<-" + current.data + "->" + current.next.data;
            current = current.next;
        }
        
        return strList;
    }
    
    public void clear() {
        head = null;
        tail = null;
    }
    
}
