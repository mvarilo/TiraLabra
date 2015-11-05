/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tiralabra_maven;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

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

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        this.solmu = new Solmu(1, 1);
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

}
