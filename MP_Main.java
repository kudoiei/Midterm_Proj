/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midterm_proj;

/**
 *
 * @author kudoi
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;


public class MP_Main extends JFrame {
    
public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MP_Main ui = new MP_Main();
            ui.setVisible(true);
        });
    }

    private final JTextField nameField, positionField, ageField, idField;
    private final JTable employeeTable;
    private final DefaultTableModel tableModel;
    private final JComboBox<String> structureComboBox;
   
    private final MP_Array mpArray = new MP_Array(10);
    private final MP_DoublyLinkedList mpLinkedList = new MP_DoublyLinkedList();
    private final MP_StackArray mpStackArray = new MP_StackArray(10);
    private final MP_StackLL mpStackLL = new MP_StackLL();
    private final MP_QueueArray mpQueueArray = new MP_QueueArray(10);
    private final MP_QueueLL mpQueueLL = new MP_QueueLL();
    private final MP_PreArray mpPreArray = new MP_PreArray();
    private final MP_PreLL mpPreLL = new MP_PreLL();
    private final MP_PreStack mpPreStack = new MP_PreStack();
    private final MP_PreQueue mppreQueue = new MP_PreQueue();

    /**
     *
     */
    public MP_Main() {
        setTitle("Employee Management System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Position:"));
        positionField = new JTextField();
        inputPanel.add(positionField);

        inputPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        structureComboBox = new JComboBox<>(new String[]{
            "Array", "Linked List", "Stack (Array)", "Stack (Linked List)",
            "Queue (Array)", "Queue (Linked List)", "Predefined ArrayList",
            "Predefined LinkedList", "Predefined Stack", "Predefined Queue"
        });
        inputPanel.add(new JLabel("Select Structure:"));
        inputPanel.add(structureComboBox);

        JButton addButton = new JButton("Add Employee");
        JButton removeButton = new JButton("Remove Employee");
        JButton searchButton = new JButton("Search Employee");
        JButton displayButton = new JButton("Display Employees");

         addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeEmployee();
            }
        });
        
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchEmployee();
            }
        });


        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayEmployees();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(displayButton);

        String[] columnNames = {"ID", "Name", "Position", "Age"};
        tableModel = new DefaultTableModel(columnNames, 0);
        employeeTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(employeeTable);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(tableScrollPane, BorderLayout.SOUTH);
    }

//    private void addEmployee() {
        String name = nameField.getText();
        String position = positionField.getText();
        byte age = Byte.parseByte(ageField.getText());
        int id = Integer.parseInt(idField.getText());
        MP_Employee employee = new MP_Employee(name, position, age, id);

        String selectedStruc = (String) structureComboBox.getSelectedItem();

        switch (selectedStruc) {
            case "Array" -> mpArray.add(employee);
            case "Linked List" -> mpLinkedList.add(employee);
            case "Stack (Array)" -> mpStackArray.push(employee);
            case "Stack (Linked List)" -> mpStackLL.push(employee);
            case "Queue (Array)" -> mpQueueArray.enqueue(employee);
            case "Queue (Linked List)" -> mpQueueLL.enqueue(employee);
            case "Predefined ArrayList" -> mpPreArray.add(employee);
            case "Predefined LinkedList" -> mpPreLL.add(employee);
            case "Predefined Stack" -> mpPreStack.push(employee);
            case "Predefined Queue" -> mppreQueue.enqueue(employee);
        }

        clearFields();
    }

    private void removeEmployee() {
        int id = Integer.parseInt(idField.getText());
        String selectedStruc = (String) structureComboBox.getSelectedItem();
        boolean removed = false;

        switch (selectedStruc) {
            case "Array" -> removed = mpArray.remove(id);
            case "Linked List" -> removed = mpLinkedList.remove(id);
            case "Stack (Array)" -> {
                MP_Employee popped = mpStackArray.pop();
                removed = popped != null && popped.getID() == id;
            }
            case "Stack (Linked List)" -> {
                MP_Employee poppedLinked = mpStackLL.pop();
                removed = poppedLinked != null && poppedLinked.getID() == id;
            }
            case "Queue (Array)" -> {
                MP_Employee dequeued = mpQueueArray.dequeue();
                removed = dequeued != null && dequeued.getID() == id;
            }
            case "Queue (Linked List)" -> {
                MP_Employee dequeuedLinked = mpQueueLL.dequeue();
                removed = dequeuedLinked != null && dequeuedLinked.getID() == id;
            }
            case "Predefined ArrayList" -> removed = mpPreArray.remove(id);
            case "Predefined LinkedList" -> removed = mpPreLL.remove(id);
            case "Predefined Stack" -> {
                MP_Employee poppedPredefined = mpPreStack.pop();
                removed = poppedPredefined != null && poppedPredefined.getID() == id;
            }
            case "Predefined Queue" -> {
                MP_Employee dequeuedPredefined = mppreQueue.dequeue();
                removed = dequeuedPredefined != null && dequeuedPredefined.getID() == id;
            }
        }

        if (removed) {
            JOptionPane.showMessageDialog(this, "Employee removed successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Employee not found.");
        }

    }
    
    private void searchEmployee() {
    int id = Integer.parseInt(idField.getText());
    MP_Employee foundEmployee = null;

    String selectedStruc = (String) structureComboBox.getSelectedItem();
    
    switch (selectedStruc) {
        case "Array" -> foundEmployee = mpArray.searchByID(id);
        case "Linked List" -> foundEmployee = mpLinkedList.searchByID(id);
        case "Stack (Array)" -> foundEmployee = mpStackArray.searchByID(id);
        case "Stack (Linked List)" -> foundEmployee = mpStackLL.searchByID(id);
        case "Queue (Array)" -> foundEmployee = mpQueueArray.searchByID(id);
        case "Queue (Linked List)" -> foundEmployee = mpQueueLL.searchByID(id);
        case "Predefined ArrayList" -> foundEmployee = mpPreArray.searchByID(id);
        case "Predefined LinkedList" -> foundEmployee = mpPreLL.searchByID(id);
        case "Predefined Stack" -> foundEmployee = mpPreStack.searchByID(id);
        case "Predefined Queue" -> foundEmployee = mppreQueue.searchByID(id);
    }

    if (foundEmployee != null) {
        String employeeDetails = "Employee found:\n" +
            "ID: " + foundEmployee.getID() + "\n" +
            "Name: " + foundEmployee.getName() + "\n" +
            "Position: " + foundEmployee.getPosition() + "\n" +
            "Age: " + foundEmployee.getAge();
    JOptionPane.showMessageDialog(this, employeeDetails);
    } else {
        JOptionPane.showMessageDialog(this, "Employee not found.");
    }
}

    private void displayEmployees() {
        
        tableModel.setRowCount(0);

        String selectedStructure = (String) structureComboBox.getSelectedItem();

        switch (selectedStructure) {
            case "Array" -> {
                for (MP_Employee employee : mpArray.getEmployees()) {
                    if (employee != null) {
                        tableModel.addRow(new Object[]{employee.getID(), employee.getName(), employee.getPosition(), employee.getAge()});
                    }
                }
            }
            case "Linked List" -> {
                for (MP_Employee employee : mpLinkedList.getEmployees()) {
                    if (employee != null) {
                        tableModel.addRow(new Object[]{employee.getID(), employee.getName(), employee.getPosition(), employee.getAge()});
                    }
                }
            }
            case "Stack (Array)" -> {
                for (MP_Employee employee : mpStackArray.getEmployees()) {
                    if (employee != null) {
                        tableModel.addRow(new Object[]{employee.getID(), employee.getName(), employee.getPosition(), employee.getAge()});
                    }
                }
            }
            case "Stack (Linked List)" -> {
                for (MP_Employee employee : mpStackLL.getEmployees()) {
                    if (employee != null) {
                        tableModel.addRow(new Object[]{employee.getID(), employee.getName(), employee.getPosition(), employee.getAge()});
                    }
                }
            }
            case "Queue (Array)" -> {
                for (MP_Employee employee : mpQueueArray.getEmployees()) {
                    if (employee != null) {
                        tableModel.addRow(new Object[]{employee.getID(), employee.getName(), employee.getPosition(), employee.getAge()});
                    }
                }
            }
            case "Queue (Linked List)" -> {
                for (MP_Employee employee : mpQueueLL.getEmployees()) {
                    if (employee != null) {
                        tableModel.addRow(new Object[]{employee.getID(), employee.getName(), employee.getPosition(), employee.getAge()});
                    }
                }
            }
            case "Predefined ArrayList" -> {
                for (MP_Employee employee : mpPreArray.getEmployees()) {
                    if (employee != null) {
                        tableModel.addRow(new Object[]{employee.getID(), employee.getName(), employee.getPosition(), employee.getAge()});
                    }
                }
            }
            case "Predefined LinkedList" -> {
                for (MP_Employee employee : mpPreLL.getEmployees()) {
                    if (employee != null) {
                        tableModel.addRow(new Object[]{employee.getID(), employee.getName(), employee.getPosition(), employee.getAge()});
                    }
                }
            }
            case "Predefined Stack" -> {
                for (MP_Employee employee : mpPreStack.getEmployees()) {
                    if (employee != null) {
                        tableModel.addRow(new Object[]{employee.getID(), employee.getName(), employee.getPosition(), employee.getAge()});
                    }
                }
            }
            case "Predefined Queue" -> {
                for (MP_Employee employee : mppreQueue.getEmployees()) {
                    if (employee != null) {
                        tableModel.addRow(new Object[]{employee.getID(), employee.getName(), employee.getPosition(), employee.getAge()});
                    }
                }
            }
        }
    }


    private void clearFields() {
        nameField.setText("");
        positionField.setText("");
        ageField.setText("");
        idField.setText("");
    }

}

