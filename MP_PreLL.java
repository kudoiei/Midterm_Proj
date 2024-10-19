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

public class MP_PreLL {
    private LinkedList<MP_Employee> employees = new LinkedList<>();

    public void add(MP_Employee employee) {
        employees.add(employee);
    }

    public boolean remove(int id) {
        return employees.removeIf(employee -> employee.getID() == id); 
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

