/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tiralabra_maven;

import java.util.ArrayList;
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
        String expResult = "x: 4, y: 4";
        String result = this.labyrintti.getGoal().toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of tulosta method, of class Labyrintti.
     */
    @Test
    public void testTulosta() {
        System.out.println("tulosta");
        Labyrintti instance = null;
        instance.tulosta();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visualisoi method, of class Labyrintti.
     */
    @Test
    public void testVisualisoi() {
        System.out.println("visualisoi");
        Labyrintti instance = null;
        instance.visualisoi();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNeighbours method, of class Labyrintti.
     */
    @Test
    public void testGetNeighbours() {
        System.out.println("getNeighbours");
        Solmu current = null;
        Labyrintti instance = null;
        ArrayList<Solmu> expResult = null;
        ArrayList<Solmu> result = instance.getNeighbours(current);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dist_between method, of class Labyrintti.
     */
    @Test
    public void testDist_between() {
        System.out.println("dist_between");
        Solmu current = null;
        Solmu neighbour = null;
        Labyrintti instance = null;
        int expResult = 0;
        int result = instance.dist_between(current, neighbour);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
