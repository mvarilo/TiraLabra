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
public class PinoTest {

    Pino pino;
    Solmu solmu;

    public PinoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        this.pino = new Pino(3);
        this.solmu = new Solmu(1, 5);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void pushAndPop() {
        this.pino.push(solmu);
        String otetaanPinosta = this.pino.pop().toString();
        assertEquals("x: 1, y: 5", otetaanPinosta);
    }

    @Test
    public void testEmpty() {
        String tyhja = "" + this.pino.empty();
        assertEquals("true", tyhja);
    }

    /**
     * Test of push method, of class Pino.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        Solmu current = null;
        Pino instance = null;
        instance.push(current);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pop method, of class Pino.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        Pino instance = null;
        Solmu expResult = null;
        Solmu result = instance.pop();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class Pino.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Solmu solmu = null;
        Pino instance = null;
        boolean expResult = false;
        boolean result = instance.contains(solmu);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
