/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author EdwinSilva
 */
public class Attendance {
 private String stundetClassId;
 private String studentName;
 private String studentId;   
 private int lessonId;   
 private boolean isPresent;
 
 Student student = new Student(studentId, studentName, stundetClassId)
 {

 };
    
         
 
public Attendance( String studentId, String studentName, String studentClassId, int lessonId, boolean isPresent)
{
this.studentId = studentId;
this.lessonId = lessonId;
this.isPresent = isPresent;
this.studentName = studentName;
this.stundetClassId = studentClassId;

    
} 

    public String getStundetClassId() {
        return stundetClassId;
    }

    public void setStundetClassId(String stundetClassId) {
        this.stundetClassId = stundetClassId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public boolean isIsPresent() {
        return isPresent;
    }

    public void setIsPresent(boolean isPresent) {
        this.isPresent = isPresent;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
 
 
 
 
 
}
