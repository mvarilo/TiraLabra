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
    private int g_score;
    private int f_score;
    private int index;
    private int totalCost;
    private Solmu edellinen;
    private boolean visited;

    /**
     * Luo solmun ja tallentaa koordinaatit
     *
     * @param i
     * @param j
     */
    public Solmu(int i, int j) {
        this.g_score = Integer.MAX_VALUE;
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

    /**
     *
     * @param i
     */
    public void set_g_score(int i) {
        this.g_score = i;
    }

    /**
     *
     * @return
     */
    public int get_g_score() {
        return this.g_score;
    }

    /**
     *
     * @param goal
     */
    public void set_f_score(Solmu goal) {
        this.f_score = Math.abs((this.x - goal.getX()) + (this.y - goal.getY())) + get_g_score();
    }

    /**
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
     *
     */
    public void setObstacle() {
        this.obstacle = true;
    }

    /**
     *
     * @param i
     */
    public void setIndex(int i) {
        this.index = i;
    }

    /**
     *
     */
    public void setVisited() {
        this.visited = true;
    }

    /**
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
     *
     * @param current
     */
    public void setPrevious(Solmu current) {
        this.edellinen = current;
    }

    Solmu getPrevious() {
        return this.edellinen;
    }
}
