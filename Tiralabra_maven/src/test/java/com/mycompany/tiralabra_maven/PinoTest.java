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

    @Before
    public void setUp() {
        this.pino = new Pino(3);
        this.solmu = new Solmu(1, 5);
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

}
