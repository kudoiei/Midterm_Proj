/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm_proj;

public class MP_Employee {
    
    private String name;
    private String position;
    private byte age;
    private int id;
   
    //constructors
    MP_Employee(){
        name=position="";
        age =0;
        id=0;
    }
    
    MP_Employee(String n, String p, byte a, int i){
        name=n;
        position = p;
        age = a;
        id = i;
    }   
     
    
    public void setName(String n){ name = n;}
    public void setPosition(String p){ position = p;}
    public void setAge(byte a){ age = a;}
    public void setID(int i){ id = i;}
    
   
    public String getName(){return name; }
    public String getPosition(){return position; }
    public byte getAge(){return age; }
    public int getID(){return id; }
    
    public boolean equals(MP_Employee E){
        
      return ((name.equals(E.name) && position.equals(E.position) && id==E.id));
        
    }
    
    public String toString(){
        return "Name: "+name+"\nPosition: "+position
                +"\nAge: "+age+"\nID: "+id;
    }
    
    
}
 