/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Student;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author robiesun
 */
public class StudentDataManagerTest {
    
    public StudentDataManagerTest() {
    }

    

    /**
     * Test of getCurrentStudent method, of class StudentDataManager.
     */
    @Test
    public void testGetCurrentStudent() {
        System.out.println("getCurrentStudent");
        StudentDataManager instance = new StudentDataManager();

        Student expResult = null;
        Student result = instance.getCurrentStudent();
        assertEquals(expResult, result);
        
    }

    
    
}
