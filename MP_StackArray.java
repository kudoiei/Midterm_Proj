/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midterm_proj;

/**
 *
 * @author kudoi
 */
public class MP_StackArray {
    private final MP_Employee[] stack;
    private int top;

    public MP_StackArray(int capacity) {
        stack = new MP_Employee[capacity];
        top = -1;
    }

    public void push(MP_Employee employee) {
        if (top < stack.length - 1) {
            stack[++top] = employee;
        }
    }

    public MP_Employee pop() {
        if (top == -1) {
            return null;
        }
        return stack[top--]; 
    }
    
    public MP_Employee searchByID(int id) {
        for (int i = 0; i <= top; i++) {
            if (stack[i] != null && stack[i].getID() == id) {
                return stack[i]; 
            }
        }
        return null; 
    }

    public MP_Employee[] getEmployees() {
        MP_Employee[] result = new MP_Employee[top + 1];
        System.arraycopy(stack, 0, result, 0, top + 1);
        return result;
    }
}

