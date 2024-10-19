/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midterm_proj;

/**
 *
 * @author kudoi
 */
import java.util.LinkedList;
import java.util.Queue;

public class MP_PreQueue {
    private final Queue<MP_Employee> employees = new LinkedList<>();

    public void enqueue(MP_Employee employee) {
        employees.add(employee);
    }

    public MP_Employee dequeue() {
        return employees.poll();
    }
    
    public MP_Employee searchByID(int id) {
        for (MP_Employee employee : employees) {
            if (employee.getID() == id) {
                return employee; 
            }
        }
        return null; 
    }

    public MP_Employee[] getEmployees() {
        return employees.toArray(new MP_Employee[0]);
    }
}

