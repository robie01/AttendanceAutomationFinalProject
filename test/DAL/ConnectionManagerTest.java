/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author robiesun
 */
public class ConnectionManagerTest {
    
    public ConnectionManagerTest() {
    }

    /**
     * Test of getConnection method, of class ConnectionManager.
     */
    @Test
    public void testGetConnection() throws Exception {
        System.out.println("getConnection");
        ConnectionManager instance = new ConnectionManager();
        Connection expResult = null;
        Connection result = instance.getConnection();
        assertEquals(expResult, result);
       
    }
    
}
