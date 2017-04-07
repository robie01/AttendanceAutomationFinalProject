/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author robiesun
 */
public abstract class Person {

//    private static int idGenerator = 0;
    
    private String id;
    private String name;
    private String email;
    private String password;

    public Person(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

       public Person( String id, String name){
        
    }
       
    @Override
    public String toString()
    {
        return "Students"+ "\n" + "\n"+ "StudentName:"+getName() + "\n" + "Id:" + getId() + "\n" + "Email:"+getEmail()+ "\n" +"Password"+ getPassword();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
     public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    

   


}

