/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import BE.Student;
import BE.Teacher;
import java.util.ArrayList;
import DAL.StudentDataManager;


import java.util.List;

/**
 * @author robiesun
 */

public class PersonFile 
    
{
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Teacher> teachers = new ArrayList<>();

    public PersonFile()
    {
//        Student student1 = new Student("123456","Robie","robie01@hotmail.com", "student1");
//        Student student2 = new Student( "234567","Michal", "michalbae@hotmail.com", "student2");
//        Student student3 = new Student( "345678","Jesper", "jesper@hotmail.com", "student3");
//        Student student4 = new Student("456789","Edwin",  "edwinsilva@hotmail.com", "student4");

//        students.add(student1);
//        students.add(student2);
//        students.add(student3);
//        students.add(student4);
//        
//        //Mock data of Teachers
//        Teacher teacher1 = new Teacher( "123", "Jeppe","jeppe@hotmail.com", "teacher");
//         Teacher teacher2 = new Teacher( "1234", "Peter","peter@hotmail.com", "teacher");
//        //Add teachers
//        teachers.add(teacher1);
//        teachers.add(teacher2);
        
    }

    //Returning lists
    public ArrayList<Student> allStudents()
    {
        StudentDataManager dm = new StudentDataManager();
         return dm.getStudents();
    }
//
//    public ArrayList<Teacher> allTeachers()
//    {
//      
//        return teachers;
//        
//    }
}
