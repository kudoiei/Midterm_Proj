/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midterm_proj;

/**
 *
 * @author kudoi
 */
public class MP_QueueArray {
    private final MP_Employee[] queue;
    private int front, rear, size;

    public MP_QueueArray(int capacity) {
        queue = new MP_Employee[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(MP_Employee employee) {
        if (size < queue.length) {
            rear = (rear + 1) % queue.length; 
            queue[rear] = employee;
            size++;
        } 
    }

    public MP_Employee dequeue() {
        if (size == 0) {
            
            return null; 
        }
        MP_Employee dequeuedEmployee = queue[front];
        front = (front + 1) % queue.length; 
        size--;
        return dequeuedEmployee;
    }
    
    public MP_Employee searchByID(int id) {
        for (int i = 0; i < size; i++) {
            int index = (front + i) % queue.length;
            if (queue[index] != null && queue[index].getID() == id) {
                return queue[index]; 
            }
        }
        return null; 
    }

    public MP_Employee[] getEmployees() {
        MP_Employee[] employees = new MP_Employee[size];
        for (int i = 0; i < size; i++) {
            employees[i] = queue[(front + i) % queue.length];
        }
        return employees;
    }
}
