/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tiralabra_maven;

/**
 *
 * @author MV
 */
class Solmu {

    private int x, y;
    private boolean obstacle;

    Solmu(int i, int j) {
        this.x = i;
        this.y = j;
    }

    public String toString() {
        return "x: " + this.x + ", y: " + this.y;
    }

    boolean isObstacle() {
        return obstacle;
    }
}
