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
    Solmu solmu2;
    Solmu solmu3;

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
        this.solmu2 = new Solmu(2, 5);
        this.solmu3 = new Solmu(7, 7);
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
    public void pushAndPopMultiple() {
        this.pino.push(solmu3);
        this.pino.push(solmu2);
        this.pino.push(solmu);
        this.pino.pop();
        this.pino.pop();
        String otetaanPinosta = this.pino.pop().toString();
        assertEquals("x: 7, y: 7", otetaanPinosta);
    }

    @Test
    public void testEmptyTrue() {
        String tyhja = "" + this.pino.empty();
        assertEquals("true", tyhja);
    }

    @Test
    public void testEmptyFalse() {
        this.pino.push(solmu);
        String tyhja = "" + this.pino.empty();
        assertEquals("false", tyhja);
    }

    /**
     * Test of contains method, of class Pino.
     */
    @Test
    public void testContainsTrue() {
        System.out.println("contains");

        this.pino.push(solmu3);
        this.pino.push(solmu2);
        this.pino.push(solmu);

        boolean result = this.pino.contains(solmu2);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of contains method, of class Pino.
     */
    @Test
    public void testContainsFalse() {
        System.out.println("contains");

        this.pino.push(solmu3);
        this.pino.push(solmu);

        boolean result = this.pino.contains(solmu2);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

}
