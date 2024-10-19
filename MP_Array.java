package midterm_proj;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kudoi
 */
public class MP_Array {
    private final MP_Employee[] array;
    private int size;

    /**
     *
     * @param capacity
     */
    public MP_Array(int capacity) {
        array = new MP_Employee[capacity];
        size = 0;
    }

    public void add(MP_Employee employee) {
        if (size < array.length) {
            array[size++] = employee;
        }
    }

    public boolean remove(int id) {
        for (int i = 0; i < size; i++) {
            if (array[i].getID() == id) {
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[--size] = null; 
                return true; 
            }
        }
        return false; 
    }
    
    public MP_Employee searchByID(int id) {
        for (int i = 0; i < size; i++) {
            if (array[i] != null && array[i].getID() == id) {
                return array[i]; 
            }
        }
        return null; 
    }

    public MP_Employee[] getEmployees() {
        MP_Employee[] result = new MP_Employee[size];
        System.arraycopy(array, 0, result, 0, size);
        return result;
    }
}

