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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author MV
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.mycompany.tiralabra_maven.SolmuTest.class, com.mycompany.tiralabra_maven.MainTest.class, com.mycompany.tiralabra_maven.AstarTest.class, com.mycompany.tiralabra_maven.LabyrinttiTest.class})
public class Tiralabra_mavenSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
