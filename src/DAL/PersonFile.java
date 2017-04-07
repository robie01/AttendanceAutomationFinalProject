/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import BE.Student;
import BE.Teacher;
import java.util.ArrayList;



/**
 * @author robiesun
 */

public class PersonFile 
{
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Teacher> teachers = new ArrayList<>();

    public PersonFile()
    {
    }

    //Returning lists
    public ArrayList<Student> allStudents()
    {
        StudentDataManager dm = new StudentDataManager();
         return dm.getStudents();

}
}