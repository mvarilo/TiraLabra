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
public class KekoTest {

    public KekoTest() {
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
     * Test of add method, of class Keko.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Solmu start = null;
        Keko instance = null;
        instance.add(start);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class Keko.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Keko instance = null;
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of poll method, of class Keko.
     */
    @Test
    public void testPoll() {
        System.out.println("poll");
        Keko instance = null;
        Solmu expResult = null;
        Solmu result = instance.poll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class Keko.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Solmu neighbour = null;
        Keko instance = null;
        boolean expResult = false;
        boolean result = instance.contains(neighbour);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLength method, of class Keko.
     */
    @Test
    public void testGetLength() {
        System.out.println("getLength");
        Keko instance = null;
        int expResult = 0;
        int result = instance.getLength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIndex method, of class Keko.
     */
    @Test
    public void testGetIndex() {
        System.out.println("getIndex");
        int i = 0;
        Keko instance = null;
        Solmu expResult = null;
        Solmu result = instance.getIndex(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
