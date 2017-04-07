/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Course;
import BE.Student;
import BE.Teacher;
import DAL.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author robiesun
 */
public class PersonManager 
{
    PersonFile pf = new PersonFile();
    TeacherDataManager TDB = new TeacherDataManager();
    StudentDataManager MG = new StudentDataManager();
    CourseDataManager CDM = new CourseDataManager();
    
    
    private static PersonManager PERSONMANAGER = new PersonManager();
    AttendanceDataManager ADM = new AttendanceDataManager();
    
    
    
    public static PersonManager getInstance( ) 
    {
      return PERSONMANAGER;
    }
    
    public PersonManager()
    {
        
    }

//    public ArrayList<Teacher> getAllTeachers()
//    {
//        return MG.allTeachers();
//    }
    
    public ArrayList<Integer> getAttendedStudents(int lessonId)
    {
        return ADM.getPresentStudentsDB(lessonId);
    }
    
    

    public ArrayList<Student> getAllStudents()
    {
        return MG.getStudents();
    }
    
    public ArrayList<Student> get1Students()
    {
        return MG.get1Students();
    }
    
    public ArrayList<Course> getCourse()
    {
        return CDM.getCourses();
    }
    
    public ArrayList<Teacher> getAllTeachers() 
    {
        return TDB.getTeachers();
    }
            
}
