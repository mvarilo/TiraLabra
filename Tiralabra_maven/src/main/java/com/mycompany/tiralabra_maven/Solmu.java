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
public class Solmu implements Comparable<Solmu> {

    private int x, y;
    private boolean obstacle;
    private int matkaAlkuun;
    private int f_score;
    private int index;
    private Solmu edellinen;
    private boolean visited;

    /**
     * Luo solmun ja tallentaa koordinaatit
     *
     * @param i
     * @param j
     */
    public Solmu(int i, int j) {
        this.matkaAlkuun = Integer.MAX_VALUE;
        this.x = i;
        this.y = j;
        this.obstacle = false;
        this.edellinen = null;
        this.visited = false;
    }

    /**
     * Tulostaa solmun
     *
     * @return
     */
    @Override
    public String toString() {
        return "x: " + this.x + ", y: " + this.y;
    }

    /**
     * Palauttaa solmun x-koordinaatin.
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Palauttaa solmun y-koordinaatin.
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

    /**
     * Asettaa arvon solmun matkalle alkuun.
     *
     * @param i
     */
    public void set_g_score(int i) {
        this.matkaAlkuun = i;
    }

    /**
     * Palauttaa arvion matkasta alkusolmuun.
     *
     * @return
     */
    public int get_g_score() {
        return this.matkaAlkuun;
    }

    /**
     * Asettaa arvion kokonaiskustannuksesta maaliin.
     *
     * @param goal
     */
    public void set_f_score(Solmu goal) {
        this.f_score = Math.abs(this.x - goal.getX()) + Math.abs(this.y - goal.getY()) + get_g_score();
    }

    /**
     * Asettaa arvion kokonaiskustannuksesta suoraan (testejä varten)
     *
     * @param score
     */
    public void set_f_score(int score) {
        this.f_score = score;
    }

    /**
     * Palauttaa arvion maaliin.
     *
     * @return
     */
    public int get_f_score() {
        return this.f_score;
    }

    @Override
    public int compareTo(Solmu o) {
        if (this.get_f_score() < o.get_f_score()) {
            return -1;
        } else if (this.get_f_score() > o.get_f_score()) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Asettaa solmun olevan este.
     */
    public void setObstacle() {
        this.obstacle = true;
    }

    /**
     * Asettaa solmun indeksin keossa.
     *
     * @param i
     */
    public void setIndex(int i) {
        this.index = i;
    }

    /**
     * Hakee solmun indeksin keossa.
     *
     * @return
     */
    public int getIndex() {
        return this.index;
    }

    /**
     * Asettaa solmun käydyksi.
     */
    public void setVisited() {
        this.visited = true;
    }

    /**
     * Palauttaa onko solmu käyty läpi.
     *
     * @return
     */
    public boolean isVisited() {
        if (this.visited == true) {
            return true;
        }
        return false;
    }

    /**
     * Asettaa edellisen solmun arvon.
     *
     * @param current
     */
    public void setPrevious(Solmu current) {
        this.edellinen = current;
    }

    /**
     * Palauttaa edellisen solmun.
     *
     * @return Solmu
     */
    public Solmu getPrevious() {
        return this.edellinen;
    }
}
