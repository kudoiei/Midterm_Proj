/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midterm_proj;

/**
 *
 * @author kudoi
 */
import java.util.Stack;

public class MP_PreStack {
    private final Stack<MP_Employee> employees = new Stack<>();

    public void push(MP_Employee employee) {
        employees.push(employee);
    }

    public MP_Employee pop() {
        return employees.isEmpty() ? null : employees.pop(); 
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
