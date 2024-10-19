/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midterm_proj;

/**
 *
 * @author kudoi
 */
public class MP_QueueLL {    
    private class Node {
        MP_Employee employee;
        Node next;

        Node(MP_Employee employee) {
            this.employee = employee;
        }
    }

    private Node head, tail;

    public void enqueue(MP_Employee employee) {
        Node newNode = new Node(employee);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = tail; 
        }
    }

    public MP_Employee dequeue() {
        if (head == null) {
            return null; 
        }
        MP_Employee dequeuedEmployee = head.employee;
        head = head.next; 
        if (head == null) {
            tail = null; 
        }
        return dequeuedEmployee;
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
