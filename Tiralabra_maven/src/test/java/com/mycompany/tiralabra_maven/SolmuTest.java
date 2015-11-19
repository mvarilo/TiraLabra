/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tiralabra_maven;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 * Testaa Solmu-luokkaa
 *
 * @author MV
 */
public class SolmuTest {

    Solmu solmu;

    /**
     *
     */
    public SolmuTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        this.solmu = new Solmu(1, 1);
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     *
     */
    @Test
    public void testGetX() {
        int s = this.solmu.getX();
        assertEquals(s, 1);
    }

    /**
     *
     */
    @Test
    public void testGetY() {
        int s = this.solmu.getY();
        assertEquals(s, 1);
    }

    /**
     *
     */
    @Test
    public void testToString() {
        String s = this.solmu.toString();
        assertEquals("x: 1, y: 1", s);
    }

    /**
     * Test of isObstacle method, of class Solmu.
     */
    @Test
    public void testObstacle() {
        Solmu instance = new Solmu(0, 0);
        instance.setObstacle();
        boolean expResult = true;
        boolean result = instance.isObstacle();
        assertEquals(expResult, result);
    }

    /**
     * Test of set_g_score method, of class Solmu.
     */
    @Test
    public void test_g_score() {
        System.out.println("set_g_score");
        int i = 3;
        Solmu instance = new Solmu(0, 0);
        instance.set_g_score(i);
        int expResult = 3;
        int result = instance.get_g_score();
        assertEquals(expResult, result);
    }

    /**
     * Test of set_f_score method, of class Solmu.
     */
    @Test
    public void test_f_score() {
        System.out.println("set_f_score");
        Solmu goal = new Solmu(1, 1);
        Solmu instance = new Solmu(0, 0);
        instance.set_f_score(goal);
        int result = instance.get_f_score();
        System.out.println(result);
    }

    /**
     * Test of compareTo method, of class Solmu.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Solmu o = null;
        Solmu instance = null;
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isObstacle method, of class Solmu.
     */
    @Test
    public void testIsObstacle() {
        System.out.println("isObstacle");
        Solmu instance = null;
        boolean expResult = false;
        boolean result = instance.isObstacle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set_g_score method, of class Solmu.
     */
    @Test
    public void testSet_g_score() {
        System.out.println("set_g_score");
        int i = 0;
        Solmu instance = null;
        instance.set_g_score(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get_g_score method, of class Solmu.
     */
    @Test
    public void testGet_g_score() {
        System.out.println("get_g_score");
        Solmu instance = null;
        int expResult = 0;
        int result = instance.get_g_score();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set_f_score method, of class Solmu.
     */
    @Test
    public void testSet_f_score() {
        System.out.println("set_f_score");
        Solmu goal = null;
        Solmu instance = null;
        instance.set_f_score(goal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get_f_score method, of class Solmu.
     */
    @Test
    public void testGet_f_score() {
        System.out.println("get_f_score");
        Solmu instance = null;
        int expResult = 0;
        int result = instance.get_f_score();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setObstacle method, of class Solmu.
     */
    @Test
    public void testSetObstacle() {
        System.out.println("setObstacle");
        Solmu instance = null;
        instance.setObstacle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
