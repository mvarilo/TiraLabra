/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tiralabra_maven;

/**
 * Vastaa labyrintin solmujen toteutuksesta
 *
 * @author MV
 */
public class Solmu {

    private int x, y;
    private boolean obstacle;

    /**
     * Luo solmun ja tallentaa koordinaatit
     *
     * @param i
     * @param j
     */
    public Solmu(int i, int j) {
        this.x = i;
        this.y = j;
    }

    /**
     * Tulostaa solmun
     *
     * @return 
     */
    public String toString() {
        return "x: " + this.x + ", y: " + this.y;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * Tarkastaa onko solmussa este
     *
     * @return 
     */
    public boolean isObstacle() {
        return obstacle;
    }
}
