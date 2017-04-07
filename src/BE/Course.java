/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import GUI.Model.CourseModel;

/**
 *
 * @author robiesun
 */
public class Course {
    
    private int courseId;
    private String courseName; 
    
   public Course(){
       
   }
    public Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

   
 
    public int getId() {
        return courseId;
    }

    public void setId(int id) {
        this.courseId = id;
    }

    public String getName() {
        return courseName;
    }

    public void setName(String name) {
        this.courseName = name;
    }

    @Override
    public String toString() {
        return courseId + courseName; //To change body of generated methods, choose Tools | Templates.
    }

    
   
}

