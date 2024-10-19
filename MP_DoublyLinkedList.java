/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm_proj;

public class MP_DoublyLinkedList {
    private class Node {
        MP_Employee employee;
        Node next, prev;

        Node(MP_Employee employee) {
            this.employee = employee;
        }
    }

    private Node head, tail;

    public void add(MP_Employee employee) {
        Node newNode = new Node(employee);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public boolean remove(int id) {
        Node current = head;
        while (current != null) {
            if (current.employee.getID() == id) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next; 
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev; 
                }
                return true; 
            }
            current = current.next;
        }
        return false; 
    }
    
    public MP_Employee searchByID(int id) {
        Node current = head;
        while (current != null) {
            if (current.employee.getID() == id) {
                return current.employee; 
            }
            current = current.next;
        }
        return null; 
    }

    public MP_Employee[] getEmployees() {
        java.util.List<MP_Employee> employeesList = new java.util.ArrayList<>();
        Node current = head;
        while (current != null) {
            employeesList.add(current.employee);
            current = current.next;
        }
        return employeesList.toArray(new MP_Employee[0]);
    }
}
