/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tiralabra_maven;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MV
 */
public class Astar2Test {
    
    public Astar2Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of search method, of class Astar2.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        Astar2 instance = null;
        instance.search();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchKeko method, of class Astar2.
     */
    @Test
    public void testSearchKeko() {
        System.out.println("searchKeko");
        Astar2 instance = null;
        boolean expResult = false;
        boolean result = instance.searchKeko();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPolku method, of class Astar2.
     */
    @Test
    public void testGetPolku() {
        System.out.println("getPolku");
        Astar2 instance = null;
        Pino expResult = null;
        Pino result = instance.getPolku();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
