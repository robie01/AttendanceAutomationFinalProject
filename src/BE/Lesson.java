/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;
import java.util.Date;
import java.sql.Time;

/**
 *
 * @author EdwinSilva
 */
public class Lesson {
public Lesson(Lesson lesson){
    
}
public Lesson lesson;
private int lessonId;
private int courseId;
private Date lessonDate;
private Time startTime;   
private Time endTime;   
    
    public Lesson(int lessonId, int courseId, Date lessonDate, Time startTime, Time endTime) {
        this.lessonId = lessonId;
        this.courseId = courseId;
        this.lessonDate = lessonDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Date getDate() {
        return lessonDate;
    }

    public void setDate(Date date) {
        this.lessonDate = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    
    @Override
    public String toString(){
    return "\n"+ "lessonId: " + lessonId+ "\n"+ "courseId: " + courseId + "\n"+ "Date: " + lessonDate + "\n";
        
    }
    
    
    
    
    
    
    
    
    
    
}
