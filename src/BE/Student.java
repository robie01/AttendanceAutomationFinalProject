/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author robiesun
 */
public class Student extends Person {

    private String classId;

    public Student(String studentId, String studentName, String studentEmail, String stundetPassword, String studentClassId) {

        super(studentId, studentName, studentEmail, stundetPassword);
        attendence.set("NO");
        this.classId = studentClassId;
    }

    public Student(String studentId, String studentName, String studentClassId) {
        super(studentId, studentName);
        this.classId = studentClassId;
        attendence.set("NO");
    }

    private final StringProperty attendence = new SimpleStringProperty();

    public String getAttendence() {
        return attendence.get();
    }

    public void setAttendence(String value) {
        attendence.set(value);
    }

    public StringProperty attendenceProperty() {
        return attendence;
    }
    
    
}
