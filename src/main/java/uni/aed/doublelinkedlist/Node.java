/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.doublelinkedlist;

/**
 *
 * @author mitch
 */
public class Node {
    
    int data;
    Node next;
    Node prev;
    
    public Node (int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
