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
 * Testaa Labyrintti-luokkaa
 * 
 * @author MV
 */
public class LabyrinttiTest {

    Labyrintti labyrintti;

    /**
     *
     */
    public LabyrinttiTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
        labyrintti = new Labyrintti(7);
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of getSolmu method, of class Labyrintti.
     */
    @Test
    public void testGetSolmu() {
        System.out.println("getSolmu");
        int x = 0;
        int y = 0;
        String expResult = new Solmu(0,0).toString();
        String result = this.labyrintti.getSolmu(x, y).toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStart method, of class Labyrintti.
     */
    @Test
    public void testGetStart() {
        System.out.println("getStart");
        String expResult = "x: 0, y: 0";
        String result = this.labyrintti.getStart().toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGoal method, of class Labyrintti.
     */
    @Test
    public void testGetGoal() {
        System.out.println("getGoal");
        String expResult = "x: 1, y: 1";
        String result = this.labyrintti.getGoal().toString();
        assertEquals(expResult, result);
    }

}
