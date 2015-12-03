/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tiralabra_maven;

import java.util.Stack;
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
public class AstarTest {

    Labyrintti labyrintti;
    Astar astar;
    Solmu start, goal;

    public AstarTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.labyrintti = new Labyrintti(7);
        this.start = labyrintti.getStart();
        this.goal = labyrintti.getGoal();

        this.astar = new Astar(labyrintti);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of search method, of class Astar.
     */
    @Test
    public void testSearch() {
        this.astar.search();
    }

}
