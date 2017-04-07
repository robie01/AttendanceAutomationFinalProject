/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BE.Student;
import BE.Teacher;
import BLL.PersonManager;
import DAL.StudentDataManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author robiesun
 */
public class PersonModel 
{
     private static PersonModel PERSONMODEL = new PersonModel();
     
     StudentDataManager dm = new StudentDataManager();
    
     PersonManager pm = PersonManager.getInstance();
    
    
    public static PersonModel getInstance( ) {
      return PERSONMODEL;
   }
    
    
    
    private PersonModel() // Singleton pattern
    {

    }

    public ArrayList<Student> getListOfStudents1()
    {
        return pm.get1Students();
    }
    
    
    
    public ArrayList<Student> getListOfStudents()
    {
        return dm.getStudents();
    }
    
    public List<Teacher> getListOfTeachers()
    {
        return pm.getAllTeachers();
    }
    
    
    public ArrayList<Integer> getAttendedStudents(int lessonId) 
    {
        return pm.getAttendedStudents(lessonId);
    }
    
}
