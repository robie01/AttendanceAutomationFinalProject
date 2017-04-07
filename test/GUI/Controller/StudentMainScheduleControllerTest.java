/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Lesson;
import java.sql.Time;
import java.sql.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author robiesun
 */
public class StudentMainScheduleControllerTest {
    
    public StudentMainScheduleControllerTest() {
    }

    @Test
    public void testRetrieveDayOfWeekFromLesson() {
        System.out.println("retrieveDayOfWeekFromLesson");
        
       Lesson lesson = new Lesson(0, 0, new Date(117,10,10), new Time(12, 12, 12), new Time(12, 12, 12));
        System.out.println(lesson.getDate()
        );
        StudentMainScheduleController instance = new StudentMainScheduleController();

        
        int expResult = 5;
        int result = instance.retrieveDayOfWeekFromLesson(lesson);
       
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
   
    
}
