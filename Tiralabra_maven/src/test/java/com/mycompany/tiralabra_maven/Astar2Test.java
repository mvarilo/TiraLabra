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

    Labyrintti labyrintti;
    Astar2 astar2;
    Solmu start, goal;

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
        this.labyrintti = new Labyrintti();
        this.astar2 = new Astar2(labyrintti);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of searchKeko method, of class Astar2.
     */
    @Test
    public void testSearchKeko() {
        this.astar2.searchKeko();
        Pino polku = this.astar2.getPolku();

        String solmu1 = polku.pop().toString();
        String solmu2 = polku.pop().toString();
        String solmu3 = polku.pop().toString();
        String solmu4 = polku.pop().toString();
        String solmu5 = polku.pop().toString();
        String solmu6 = polku.pop().toString();
        String solmu7 = polku.pop().toString();
        String solmu8 = polku.pop().toString();
        String solmu9 = polku.pop().toString();
        String solmu10 = polku.pop().toString();
        String solmu11 = polku.pop().toString();

        String lyhinPolku = solmu1 + "; " + solmu2 + "; " + solmu3 + "; " + solmu4
                + "; " + solmu5 + "; " + solmu6 + "; " + solmu7 + "; " + solmu8 + "; " + solmu9
                + "; " + solmu10 + "; " + solmu11;

        assertEquals("x: 2, y: 0; x: 3, y: 0; x: 4, y: 0; x: 4, y: 1; x: 5, y: 1; x: 5, y: 2; x: 6, y: 2; x: 6, y: 3; x: 6, y: 4; x: 5, y: 4; x: 4, y: 4",
                lyhinPolku);
    }

    /**
     * Test of searchPriorityQueue method, of class Astar2.
     */
    @Test
    public void testSearchPriorityQueue() {
        this.astar2.searchPriorityQueue();
        Pino polku = this.astar2.getPolku();

        String solmu1 = polku.pop().toString();
        String solmu2 = polku.pop().toString();
        String solmu3 = polku.pop().toString();
        String solmu4 = polku.pop().toString();
        String solmu5 = polku.pop().toString();
        String solmu6 = polku.pop().toString();
        String solmu7 = polku.pop().toString();
        String solmu8 = polku.pop().toString();
        String solmu9 = polku.pop().toString();
        String solmu10 = polku.pop().toString();
        String solmu11 = polku.pop().toString();

        String lyhinPolku = solmu1 + "; " + solmu2 + "; " + solmu3 + "; " + solmu4
                + "; " + solmu5 + "; " + solmu6 + "; " + solmu7 + "; " + solmu8 + "; " + solmu9
                + "; " + solmu10 + "; " + solmu11;

        assertEquals("x: 2, y: 0; x: 3, y: 0; x: 3, y: 1; x: 3, y: 2; x: 4, y: 2; x: 5, y: 2; x: 6, y: 2; x: 6, y: 3; x: 6, y: 4; x: 5, y: 4; x: 4, y: 4",
                lyhinPolku);
    }

}
