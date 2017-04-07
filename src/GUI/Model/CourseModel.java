/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BE.Course;
import BLL.PersonManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author robiesun
 */
public final class CourseModel {
  
    PersonManager pm = new PersonManager();
 
    List<Course> listOfCourses = new ArrayList<>();
    
   
    public CourseModel()
    {   
//        
//        Course sde = new Course(1,"SDE");
//        Course sco = new Course(2,"SCO");
//        Course ito = new Course(3,"ITO");
//        Course dbo = new Course(4,"DBO");
//        
//        addCourse(sde);
//        addCourse(sco);
//        addCourse(ito);
//        addCourse(dbo);
//        
    }
    
    public ArrayList<Course> getCourse()
    {
        return pm.getCourse();
    }

    
    public void addCourse(Course course)
    {
       listOfCourses.add(course);
    }

    public List<Course> getListOfCourses() {
        return listOfCourses;
    }
    

    @Override
    public String toString () {
    return listOfCourses.toString();
}  
   
    
    
}
