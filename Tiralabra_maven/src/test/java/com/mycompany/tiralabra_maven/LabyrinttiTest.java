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
        labyrintti = new Labyrintti();
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
        String expResult = new Solmu(0, 0).toString();
        String result = this.labyrintti.getSolmu(x, y).toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStart method, of class Labyrintti.
     */
    @Test
    public void testGetStart() {
        System.out.println("getStart");
        String expResult = "x: 2, y: 0";
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
     * Test of getNeighbours method, of class Labyrintti.
     */
    @Test
    public void testGetNeighbours2() {
        Solmu solmu = this.labyrintti.getSolmu(2, 0);
        Keko naapurit = this.labyrintti.getNeighbours2(solmu);
        String naapuri1 = naapurit.poll().toString();
        String naapuri2 = naapurit.poll().toString();
        String naapuri3 = naapurit.poll().toString();
        String kaikkiNaapurit = "" + naapuri1 + " " + naapuri2 + " " + naapuri3;
        assertEquals("x: 1, y: 0 x: 2, y: 1 x: 3, y: 0", kaikkiNaapurit);
    }

    /**
     * Test of dist_between method, of class Labyrintti.
     */
    @Test
    public void testDist_between() {
        System.out.println("dist_between");
        Solmu current = this.labyrintti.getSolmu(0, 1);
        Solmu neighbour = this.labyrintti.getSolmu(0, 0);
        int expResult = 1;
        int result = this.labyrintti.dist_between(current, neighbour);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSize method, of class Labyrintti.
     */
    @Test
    public void testGetSize() {
        int expResult = 49;
        int result = this.labyrintti.getSize();
        assertEquals(expResult, result);
    }

}
