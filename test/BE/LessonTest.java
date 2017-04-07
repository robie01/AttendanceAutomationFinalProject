/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import java.sql.Time;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author robiesun
 */
public class LessonTest {
    
    public LessonTest() {
    }

    /**
     * Test of getLessonId method, of class Lesson.
     */
    @Test
    public void testGetLessonId() {
        System.out.println("getLessonId");
        Lesson instance = null;
        int expResult = 0;
        int result = instance.getLessonId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLessonId method, of class Lesson.
     */
    @Test
    public void testSetLessonId() {
        System.out.println("setLessonId");
        int lessonId = 0;
        Lesson instance = null;
        instance.setLessonId(lessonId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCourseId method, of class Lesson.
     */
    @Test
    public void testGetCourseId() {
        System.out.println("getCourseId");
        Lesson instance = null;
        int expResult = 0;
        int result = instance.getCourseId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCourseId method, of class Lesson.
     */
    @Test
    public void testSetCourseId() {
        System.out.println("setCourseId");
        int courseId = 0;
        Lesson instance = null;
        instance.setCourseId(courseId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Lesson.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Lesson instance = null;
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Lesson.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date = null;
        Lesson instance = null;
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartTime method, of class Lesson.
     */
    @Test
    public void testGetStartTime() {
        System.out.println("getStartTime");
        Lesson instance = null;
        Time expResult = null;
        Time result = instance.getStartTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStartTime method, of class Lesson.
     */
    @Test
    public void testSetStartTime() {
        System.out.println("setStartTime");
        Time startTime = null;
        Lesson instance = null;
        instance.setStartTime(startTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEndTime method, of class Lesson.
     */
    @Test
    public void testGetEndTime() {
        System.out.println("getEndTime");
        Lesson instance = null;
        Time expResult = null;
        Time result = instance.getEndTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEndTime method, of class Lesson.
     */
    @Test
    public void testSetEndTime() {
        System.out.println("setEndTime");
        Time endTime = null;
        Lesson instance = null;
        instance.setEndTime(endTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Lesson.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Lesson instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
