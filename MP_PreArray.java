/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midterm_proj;

/**
 *
 * @author kudoi
 */
import java.util.ArrayList;

public class MP_PreArray {
    private final ArrayList<MP_Employee> employees = new ArrayList<>();

    public void add(MP_Employee employee) {
        employees.add(employee);
    }

    public boolean remove(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getID() == id) {
                employees.remove(i); 
                return true; 
            }
        }
        return false; 
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

