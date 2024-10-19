/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midterm_proj;

/**
 *
 * @author kudoi
 */
public class MP_StackLL {
    private class Node {
        MP_Employee employee;
        Node next;

        Node(MP_Employee employee) {
            this.employee = employee;
        }
    }

    private Node head;

    public void push(MP_Employee employee) {
        Node newNode = new Node(employee);
        newNode.next = head;
        head = newNode;
    }

    public MP_Employee pop() {
        if (head == null) {
            return null; 
        }
        MP_Employee poppedEmployee = head.employee;
        head = head.next; 
        return poppedEmployee;
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
