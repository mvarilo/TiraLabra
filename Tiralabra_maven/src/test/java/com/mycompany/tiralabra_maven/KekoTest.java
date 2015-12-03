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

    Keko keko;
    Solmu solmu, solmu2, solmu3;

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
        this.keko = new Keko(3);
        this.solmu = new Solmu(1, 2);
        this.solmu.set_f_score(6);
        this.solmu2 = new Solmu(3, 4);
        this.solmu2.set_f_score(4);
        this.solmu3 = new Solmu(6, 6);
        this.solmu3.set_f_score(1);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class Keko.
     */
    @Test
    public void testAdd() {
        this.keko.add(solmu);
        String result = this.keko.getSolmuIndex(0).toString();
        assertEquals("x: 1, y: 2", result);
    }

    /**
     * Test of isEmpty method, of class Keko.
     */
    @Test
    public void testIsEmptyFalse() {
        this.keko.add(solmu);
        boolean expResult = false;
        boolean result = this.keko.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class Keko.
     */
    @Test
    public void testIsEmptyTrue() {
        boolean expResult = true;
        boolean result = this.keko.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of poll method, of class Keko.
     */
    @Test
    public void testPoll() {
        this.keko.add(solmu);
        Solmu expResult = solmu;
        Solmu result = this.keko.poll();
        assertEquals(expResult, result);
    }

    /**
     * Test of contains method, of class Keko.
     */
    @Test
    public void testContainsTrue() {
        this.keko.add(solmu);
        this.keko.add(solmu2);
        this.keko.add(solmu3);
        boolean expResult = true;
        boolean result = this.keko.contains(solmu3);
        assertEquals(expResult, result);
    }

    /**
     * Test of contains method, of class Keko.
     */
    @Test
    public void testContainsFalse() {
        this.keko.add(solmu);
        this.keko.add(solmu2);
        boolean expResult = false;
        boolean result = this.keko.contains(solmu3);
        assertEquals(expResult, result);
    }

    /**
     * Test of getLength method, of class Keko.
     */
    @Test
    public void testGetLength() {
        int expResult = 0;
        int result = this.keko.getLength();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIndex method, of class Keko.
     */
    @Test
    public void testGetIndex() {
        int i = 0;
        this.keko.add(solmu);
        Solmu expResult = solmu;
        Solmu result = this.keko.getSolmuIndex(i);
        assertEquals(expResult, result);
    }

}
